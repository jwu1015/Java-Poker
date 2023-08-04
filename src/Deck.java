import java.util.ArrayList;
import java.util.Collections;

/**
 *  An object of type Deck represents a deck of playing cards.  The deck
 *  is a regular poker deck that contains 52 regular cards and that can
 *  also optionally include two Jokers.
 */
public class Deck {

    /**
     * An array of 52 or 54 cards.  A 54-card deck contains two Jokers,
     * in addition to the 52 cards of a regular poker deck.
     */
    private Card[] deck;

    /**
     * Keeps track of the number of cards that have been dealt from
     * the deck so far.
     */
    private int cardsUsed;

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  The shuffle() method can be called to
     * randomize the order.  (Note that "new Deck()" is equivalent
     * to "new Deck(false)".)
     */
    public Deck() {
        // ***(2) Fill in one line to call the other constructor for Deck
    		// Let's have the default be to NOT use Jokers.
    	this(false);
    }

    public Deck(boolean includeJokers) {
        if (includeJokers)
            deck = new Card[54];
        else
            deck = new Card[52];
        int cardCt = 0; // How many cards have been created so far.
        for(int currentSuit = 0; currentSuit <= 3; currentSuit++) {
        		for(int currentValue = 1; currentValue <= 13; currentValue++) {
        			// (1)***fill in lines to create Card objects in each slot of the Card[] named 'deck'
        			deck[cardCt] = new Card(currentValue, currentSuit);
        			cardCt++;
        		}
        }		
        if (includeJokers) {
            deck[52] = new Card(1,Card.JOKER);
            deck[53] = new Card(2,Card.JOKER);
        }
        cardsUsed = 0;
    }

    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        ArrayList<Card> tempList = new ArrayList<>();
    		//***(3) Go through and place the Cards in 'deck' in a random order.
    		// Make sure every place in the Card[] 'deck'
    		// is still filled with Cards, however,
    		// to avoid a NullPointerException
        for(int i=0;i<deck.length;i++){
            tempList.add(deck[i]);
        }
        Collections.shuffle(tempList);
        Card[] tempArr = tempList.toArray(new Card[deck.length]);
        for(int i=0;i<deck.length;i++){
            deck[i]=tempArr[i];
        }
        cardsUsed = 0;
    }

    /**
     * As cards are dealt from the deck, the number of cards left
     * decreases.  This function returns the number of cards that
     * are still left in the deck.  The return value would be
     * 52 or 54 (depending on whether the deck includes Jokers)
     * when the deck is first created or after the deck has been
     * shuffled.  It decreases by 1 each time the dealCard() method
     * is called.
     */
    public int cardsLeft() { 
        return deck.length - cardsUsed;	
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the cardsLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card dealCard() {
    	cardsUsed++;
    	return deck[cardsUsed - 1];
        // Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.
    }

    /**
     * Test whether the deck contains Jokers.
     * @return true, if this is a 54-card deck containing two jokers, or false if
     * this is a 52 card deck that contains no jokers.
     */
    public boolean hasJokers() {
        return (deck.length == 54);
    }
    
    public String toString() {
    		String str = "";
    		for(int i = 0; i < deck.length; i++) {
    			str += deck[i].toString();
    			if(i == deck.length - 1)
    				str += ".";
    			else
    				str += ", ";
    			if(i > 0 && i % 4 == 0)
    				str += "\n";
    		}
    		return str;
    }

} // end class Deck
