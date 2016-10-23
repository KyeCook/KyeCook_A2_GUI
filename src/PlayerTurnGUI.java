import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
Code in current state is not in working order. To get into working order further implementation within STGame is needed
 */

public class PlayerTurnGUI extends JFrame implements ActionListener{
    boolean toPass;


    STGame gameReference;

    JButton passButton = new JButton("Pass");
    JButton playCardsButton = new JButton("Play");

    JPanel labelPanel = new JPanel();


    JLabel titleLabel = new JLabel("Your Turn");
    JLabel instructionsLabel = new JLabel("");



    public PlayerTurnGUI(STGame g){
        gameReference = g;

        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(labelPanel);
        add(passButton);
        add(playCardsButton);

        labelPanel.add(titleLabel);
        labelPanel.add(instructionsLabel);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        instructionsLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        instructionsLabel.setText("\nChoose a card to play [1-" + g.playerCardAmount +"]\n or pass:");


        passButton.addActionListener(this);
        playCardsButton.addActionListener(this);

        setSize(400, 350);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == passButton){
            toPass = true;
        }
        else if(source == playCardsButton){
            toPass = false;
        }

    }

}

