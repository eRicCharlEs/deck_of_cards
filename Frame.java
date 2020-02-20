import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Frame class extends JFrame to establish GUI and act as entry point for program
 */
class Frame extends JFrame {
    /**
     * Private Members
     */
    private Deck deck; // Deck object
    private JButton btnDisplay;
    private JButton btnShuffle;    // Button object

    /**
     * Constructor
     */
    public Frame(){
        // Add deck to frame
        deck = new Deck();
        add(deck, BorderLayout.CENTER);

        // Initial button used to display the ordered deck of cards
        btnDisplay = new JButton("Display Deck");
        add(btnDisplay, BorderLayout.SOUTH);
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JPanel object
                remove(deck); // Should remove previous panel
                remove(btnDisplay); // Remove display button
                deck = new Deck(); // create new panel
                deck.displayDeck(); // Display new set.
                // Add components to frame and redraw
                add(deck, BorderLayout.CENTER);
                add(btnShuffle, BorderLayout.SOUTH);
                pack(); // idk if I need this
                setSize(750, 750);
            }
        });

        // Shuffle button used to display a shuffled deck
        btnShuffle = new JButton("Shuffle");
        // Action listener
        btnShuffle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JPanel object
                remove(deck); // Should remove previous panel
                deck = new Deck(); // create new panel

                deck.shuffleDeck(); // Call shuffle button

                deck.displayDeck(); // Display new set.

                // Add components to frame and redraw
                add(deck, BorderLayout.CENTER);
                pack(); // idk if I need this
                setSize(750, 750);
            }
        });

        // Set frame attributes
        setTitle("Deck-O-Cards");
        setSize(200,200);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);
    }

    public static void main(String[] args){
       // Display frame
       Frame MainFrame = new Frame();
       MainFrame.setVisible(true);
    }



}