import java.util.ArrayList;

/**
 * Created by Kye Cook on 29/09/2016.
 */

/*
Sets up player class to allow player data to be stored in seperate class allowing for object orientated coding
 */
public class STPlayer {
    private ArrayList<STCard> cards;
    private String playerId;

    public STPlayer(String playerId){
        this.playerId = playerId;
    }

    public void setCards(ArrayList<STCard> cards) {
        this.cards = cards;
    }

    public String toString(){
        return playerId + "\n\tYour Deck is: " + cards;
    }

    public ArrayList<STCard> playerDeck(){
        return cards;
    }

    public String getPlayerId() {
        return playerId;
    }
}
