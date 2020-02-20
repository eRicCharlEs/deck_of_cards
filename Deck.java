import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * Deck class extends JPanel to create panel containing Card objects
 */
class Deck extends JPanel{

    /**
     * Private Members
     */
    private ArrayList<Card> deckOCards = new ArrayList<Card>();
    private Card card;
    private int deck_size = 52;
    private File folder = new File("./Cards"); // Establish connection with image folder for reading
    
    /**
     * Constructor
     */
    public Deck(){
        // Deck attributes
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setBackground(Color.WHITE);

        // Build an ordered deck
        buildDeck();

        // Add the default Card to the panel
        card = new Card();
        add(card);
    }

    /**
     * Adds 52 Card objects to global ArrayList
     */
    public void buildDeck(){
        // Create list of file names associated with card images
        // because I'm using mac, we need to omit .DC_Store
        String[] files = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.equals(".DS_Store");
            }
        });
        
        // Build ArrayList of Card objects
        for(int i = 0; i < files.length; i++){
            deckOCards.add(new Card(files[i]));
        }
    }

    /**
     * Shuffles ArrayList of Card objects
     */
    public void shuffleDeck() {
        Random rando = new Random();

        for (int i = 0; i < deck_size; i++) {
            int r = i + rando.nextInt(deck_size - i);

            // Swap 
            card = new Card(); // Temporary card
            card = deckOCards.get(r);
            deckOCards.set(r, deckOCards.get(i));
            deckOCards.set(i, card);
        }
    }

    /**
     * Displays the ArrayList
     */
    public void displayDeck() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setBackground(Color.WHITE);

        // Build ArrayList of Card objects
        for(int i = 0; i < deck_size; i++){
            add(deckOCards.get(i));
        }
    }
}