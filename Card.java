import javax.swing.*;

// Card class extends JLabel to create image of card
class Card extends JLabel{

    // Default Constructor sets initial label to the back side of the card.
    public Card(){
         // Import image of the backside of a card and add it to a label
         ImageIcon card_image = new ImageIcon("cardBack.jpg");
         setIcon(card_image);
    }

    // Constructor
    public Card(String path){
         // Import image of the backside of a card and add it to a label
        ImageIcon card_image = new ImageIcon("./Cards/" + path);
        setIcon(card_image);
    }
    
}