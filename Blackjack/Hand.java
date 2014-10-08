import java.util.Vector;

// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
	private Vector hand;// define fields here

	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{
		hand = new Vector();// complete this method
	}
	
	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		return hand.size(); // replace this line with your code
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		if(index >= 0 && index < hand.size()){
	         return (Card)hand.elementAt(index);
		}else{
	         return null;
		}// replace this line with your code
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{
		if(newcard != null){
	         hand.addElement(newcard);
		}
		// complete this method
	}

	// This method computes the score of this hand.
	public int getScore()
	{
		return 0;

	}

	// This methods discards all cards in this hand.
	public void discardAll()
	{
		hand.removeAllElements();// complete this method

	}
	
	public int getCardFace(int index)
	{
		if(index >= 0 && index < hand.size()){
	         return ((Card) hand.elementAt(index)).getFace();
		}else{
	         return -1;
		}// replace this line with your code
	}
	
	   
	   public void removeCard(int pos){
	         // the card in that position is removed.
	      if (pos >= 0 && pos < hand.size())
	         hand.removeElementAt(pos);
	   }

}

