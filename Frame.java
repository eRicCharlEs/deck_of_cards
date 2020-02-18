import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Main frame utilized as the entry point for this program
class Frame extends JFrame {

    // Private
    private Deck ShuffledDeck; // Deck object
    private JButton Shuffle;    // Button object

    // Constructor
    public Frame(){
        // Add deck to frame
        ShuffledDeck = new Deck();
        add(ShuffledDeck, BorderLayout.CENTER);

        // Add button to frame
        Shuffle = new JButton("Shuffle");
        add(Shuffle, BorderLayout.SOUTH);

        // Action listener that doesnt work the way I want it to
        Shuffle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pressed");
                // Create a new JPanel object
                remove(ShuffledDeck); // Should remove previous panel
                ShuffledDeck = new Deck();

                // Add components to frame and redraw
                add(ShuffledDeck, BorderLayout.CENTER);
                // pack(); // idk if I need this
                setSize(200, 200);
            }
        });

        // Set frame attributes
        setTitle("Deck-O-Cards");
        setSize(200,200);
        setBackground(Color.GRAY);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
       // Display frame
       Frame MainFrame = new Frame();
       MainFrame.setVisible(true);
    }

}