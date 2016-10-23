import javax.swing.*;
import java.awt.*;


public class PlayerTurnGUI extends JFrame{

    STGame gameReference;

    JButton passButton = new JButton("Pass");

    JPanel labelPanel = new JPanel();
    JPanel cardsPanel = new JPanel();

    JLabel titleLabel = new JLabel("Your Turn");
    JLabel instructionsLabel = new JLabel("");

    JList cards = new JList();


    public PlayerTurnGUI(STGame g){
        gameReference = g;

        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(labelPanel);
        add(cardsPanel);
        add(passButton);

        labelPanel.add(titleLabel);
        labelPanel.add(instructionsLabel);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        instructionsLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        instructionsLabel.setText("\nChoose a card to play [1-" + g.playerCardAmount +"]\n or pass:");

        cardsPanel.add(cards);



        setSize(400, 350);
        setVisible(true);

    }

}

