import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kye Cook on 29/09/2016.
 */
public class STDeck {
    private static final int NUM_CARDS_INITIALLY = 54;
    private ArrayList<STCard> cards;

/*
Sets up Deck class to allow player data to be stored in seperate class allowing for object orientated coding
 */

    public STDeck() {
       cards = new ArrayList<STCard>();

        for (int i = 0; i < NUM_CARDS_INITIALLY; i++) {
             cards.add(new STCard(i));
        }
    }

    public ArrayList<STCard> dealCards(int nCards) {
        ArrayList<STCard> result = new ArrayList<STCard>();

        for(int i = 0; i < nCards; ++i){
            int index = new Random().nextInt(cards.size());
            STCard card = cards.remove(index);
            result.add(card);

//            System.out.println("\nCard=" + card);
        }
        return result;
    }
}
