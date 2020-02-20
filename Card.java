import javax.swing.*;

/**
 * Card class extends JLabel to create label object containing Image Icon
 */
class Card extends JLabel{

    // Default Constructor sets initial label icon to the back side of the card.
    public Card(){
         // Import image of the backside of a card and add it to a label
         ImageIcon card_image = new ImageIcon("cardBack.jpg");
         setIcon(card_image);
    }

    // Constructor sets label icon to card from file
    public Card(String path){
        ImageIcon card_image = new ImageIcon("./Cards/" + path);
        setIcon(card_image);
    }
    
}