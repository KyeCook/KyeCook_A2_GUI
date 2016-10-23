import javax.swing.*;
import java.util.*;

/**
 * Created by Kye Cook on 29/09/2016.
 */

/*
Game class that features all code required for actual gameplay
 */
public class STGame {

//    PlayerTurnGUI gui;

    /*
    Constant determines amount of cards dealt to each player
     */
    private static final int NUM_CARDS_TO_DEAL = 8;
    /*
    Declaration of variables used within code
     */

    public int playerCardAmount;
    private int numPlayers;
    private int dealerId;
    private STPlayer[] players;
    private STDeck deck;
    private int humanPlayerId;
    private int cardInPlay = 0;


    /*
    Declaration of bot ids and list of bot ids
     */
    private int botPlayerId1;
    private int botPlayerId2;
    private int botPlayerId3;
    private int botPlayerId4;

    private List bots = new ArrayList(4);

    /*
    Instantiates game
     */
    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;
        deck = new STDeck();

//        gui = new PlayerTurnGUI(this);
    }

    /*
    ID for randomly determined player shuffler
     */
    public void selectDealer() {
        dealerId = new Random().nextInt(numPlayers + 1);
    }

    /*
    Get and select statements to allow human player id to be used within other classes
     */
    public void selectHumanPlayer(){
        humanPlayerId = 0;
    }
    public STPlayer getHumanPlayer(){
        return players[humanPlayerId];
    }


    /*
    Statements to allow the main function of program (wearentfuckingusingthisagain.KyeCook__Assign1__DOS) to select the ids
     */
    public void selectBotPlayer1(){
        this.botPlayerId1 = 1;
    }
    public void selectBotPlayer2(){
        this.botPlayerId2 = 2;
    }
    public void selectBotPlayer3(){
        this.botPlayerId3 = 3;
    }
    public void selectBotPlayer4(){
        this.botPlayerId4 = 4;
    }

    /*
    Get statement for bot players to allow values to be implemented within other classes
     */
    public STPlayer getBotPlayer1(){
        return players[botPlayerId1];
    }
    public STPlayer getBotPlayer2(){
        return players[botPlayerId2];
    }
    public STPlayer getBotPlayer3(){
        return players[botPlayerId3];
    }
    public STPlayer getBotPlayer4(){
        return players[botPlayerId4];
    }

    /*
    Code to run actual game functionality. All core game functionality lies within this function, predominantly
    featuring calls to player turns
     */
    public void playGame() {
        boolean gameIsActive = true;
        int convertObjectToInteger;



        bots.add(botPlayerId1);
        bots.add(botPlayerId2);
        bots.add(botPlayerId3);
        bots.add(botPlayerId4);


        while (gameIsActive){

            for(int indexPlayer = 0; indexPlayer < players.length; indexPlayer ++) {
                /*
                This sets the winning condition of the game
                 */
                if(players[indexPlayer].playerDeck().size() == 0){
                    System.out.println("Player : " + indexPlayer + " has Won SuperTrumps!");
                    gameIsActive = false;
                    break;
                }
                /*
                This starts the players turn
                 */
                else if(indexPlayer == humanPlayerId){
//                    System.out.println("----- Your Turn -----\n");
                    showPlayerTurn();
                }
                /*
                This ensures that each bot has their own turn and is dependant on the amount of bots present within game
                 */

                else{
                    convertObjectToInteger = Integer.parseInt(bots.get(indexPlayer - 1).toString());

//                    System.out.println("----- Bots Turn -----\n");
                    showBotTurn(convertObjectToInteger);

                }
            }
        }
    }

    /*
    Players turn : Code that occurs when players turn is initiated. Allows player to see their current hand as well as
    play cards and or pass the round.
     */
    public void showPlayerTurn() {
        int selectedOption = 0;
        int selectedMenuOption;


        playerCardAmount = players[humanPlayerId].playerDeck().size();

//        gui.repaint();
//        gui.setVisible(true);
//        gui.requestFocus();



        /*
        Try Statement prevents users from entering in non-numeric inputs into scanner
         */

//        if(gui.toPass){
//            System.out.println("Turn Passed");
//            ArrayList<STCard>  drawnCard = deck.dealCards(1);
//            players[humanPlayerId].playerDeck().addAll(drawnCard);
//
//            System.out.println(players[humanPlayerId].playerDeck());
//
//        }
//        else {

        /*
        Code Below Sets buttons to custom String
         */
        UIManager.put("OptionPane.noButtonText", "Pass Turn");
        UIManager.put("OptionPane.yesButtonText", "Play Card");
        UIManager.put("OptionPane.cancelButtonText", "Quit Game");

        selectedMenuOption = JOptionPane.showConfirmDialog(null, "Press Play if you wish place a card. Pass to " +
                "pass the turn. And Quit will exit you from the game\n\t Current Card in play is : " + cardInPlay
                + "\t\nYour Deck is : " + players[humanPlayerId].playerDeck());

        if(selectedMenuOption == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Turn Passed");
            ArrayList<STCard>  drawnCard = deck.dealCards(1);
            players[humanPlayerId].playerDeck().addAll(drawnCard);
        }
        else if(selectedMenuOption == JOptionPane.CANCEL_OPTION){
            System.exit(0);
        }
        else {
            try {
                selectedOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the card you wish to play\n" +
                        players[humanPlayerId].playerDeck()));

                while (selectedOption < 0 || selectedOption > playerCardAmount) {
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the card you wish to play\n" +
                            players[humanPlayerId].playerDeck()));
                }
                if (selectedOption < cardInPlay) {
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the card you wish to play\n" +
                            players[humanPlayerId].playerDeck()));
                }
                else if(selectedOption == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                    }
                else {
                    System.out.println(players[humanPlayerId].playerDeck().get(selectedOption - 1) + "  is played");

                    cardInPlay = players[humanPlayerId].playerDeck().get(selectedOption - 1).getId();

                    players[humanPlayerId].playerDeck().remove(selectedOption - 1);


                    System.out.println(players[humanPlayerId].playerDeck());

                }


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Incorrect input type. Please make sure valid integer is inputted");
            }
        }

        JOptionPane.showMessageDialog(null, "\nCard to Beat :" + cardInPlay + '\n');

    }




    /*
    Bot players turn. Runs code bot will perform during its turn
     */
    private void showBotTurn(int botPlayerId) {
        List botCards = new ArrayList();

        JOptionPane.showMessageDialog(null, "---------------- Bots Turn ----------------\n\n This is bot no :" +
                botPlayerId + '\n' + '\n' );


        for(STCard card : players[botPlayerId].playerDeck()){

            if(card.getId() > cardInPlay){

                /*
                Creates a temporary arraylist too allow for both looping through and modification of Bot Cards.
                 Eradicates concurrent modification errors.
                 */
                botCards.add(card);

                /*
                Sets card to beat to card played by bot
                 */
                cardInPlay = card.getId();

            }

        }

        /*
        Sets Card to be played and removed by bot
         */
        players[botPlayerId].playerDeck().remove(botCards.size());
//
        JOptionPane.showMessageDialog(null, "\nCard to Beat :" + cardInPlay + '\n');
    }

    /*
    Randomly 'shuffles' and 'deals' cards to players
     */

    public void dealCards() {
        /*
        Instantiates players arraylist
         */
        players = new STPlayer[numPlayers];
        for (int i = 0; i <numPlayers; ++i){
            players[i] = new STPlayer("Player " + i);

        }

        /*
        Actually shuffles and deals cards to players within player arraylist
         */
        for(STPlayer player : players){
            ArrayList<STCard>  cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);

        }
    }
}
