import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

// Deck GUI class where the deck is built and 
// the shuffle process happens
class Deck extends JPanel{

    // Private 
    private ArrayList<Card> deckOCards = new ArrayList<Card>();
    // private Card [] deckOCards = new Card[52];
    private Card card;

    // Get path to each card
    File folder = new File("./Cards");
    

    // Constructor: set the initial panel
    public Deck(){
        // Deck attributes
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setBackground(Color.GRAY);

        // Build an ordered deck
        buildDeck();

        // Add the default Card to the panel
        card = new Card();
        add(card);
    }

    // Build ordered deck of cards
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
}