import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KyeCook_Assign2_GUI extends JFrame implements ActionListener{

    JButton newGameButton = new JButton("New Game");
    JButton exitGameButton = new JButton("Exit Game");

    JPanel buttonPanel = new JPanel();
    JPanel logoPanel = new JPanel();

    JLabel titleLabel = new JLabel("Mineral Supertrumps!");

    public KyeCook_Assign2_GUI()
    {
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(logoPanel);
        add(buttonPanel);

        logoPanel.add(titleLabel);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 25));

        buttonPanel.add(newGameButton);
        buttonPanel.add(exitGameButton);

        newGameButton.addActionListener(this);
        exitGameButton.addActionListener(this);
        setSize(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == newGameButton){
            STGame game;
            game = startNewGame();
            game.playGame();

        }
        else {
            System.exit(0);
        }

    }

    private static int getNumPlayers() {
        int numberOfPlayers = 0;

        while(numberOfPlayers<2 || numberOfPlayers >5){

            try {
                numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter in number of preferred players"));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Incorrect input type. Please make sure valid integer is inputted");
            }
        }

        JOptionPane.showMessageDialog(null, numberOfPlayers);
        return numberOfPlayers;
    }

    public static void main(String[] args)
    {
        KyeCook_Assign2_GUI frame = new KyeCook_Assign2_GUI();
    }

    private static STGame startNewGame(){
        int numPlayers = getNumPlayers();
        STGame game = new STGame(numPlayers);
        game.selectDealer();
        game.dealCards();
        game.selectHumanPlayer();

        STPlayer humanPlayer = game.getHumanPlayer();


        if(numPlayers == 2){
            game.selectBotPlayer1();

            STPlayer botPlayer1 = game.getBotPlayer1();

        }
        else if(numPlayers == 3){
            game.selectBotPlayer1();
            game.selectBotPlayer2();

            STPlayer botPlayer1 = game.getBotPlayer1();
            STPlayer botPlayer2 = game.getBotPlayer2();

        }
        else if(numPlayers == 4){
            game.selectBotPlayer1();
            game.selectBotPlayer2();
            game.selectBotPlayer3();

            STPlayer botPlayer1 = game.getBotPlayer1();
            STPlayer botPlayer2 = game.getBotPlayer2();
            STPlayer botPlayer3 = game.getBotPlayer3();

        }
        else if(numPlayers == 5){
            game.selectBotPlayer1();
            game.selectBotPlayer2();
            game.selectBotPlayer3();
            game.selectBotPlayer4();

            STPlayer botPlayer1 = game.getBotPlayer1();
            STPlayer botPlayer2 = game.getBotPlayer2();
            STPlayer botPlayer3 = game.getBotPlayer3();
            STPlayer botPlayer4 = game.getBotPlayer4();

        }

        return game;

    }

}
