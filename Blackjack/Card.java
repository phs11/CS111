
public class Card {

	// This class represents one playing card.
	
		// Card suits (provided for your convenience - use is optional)
		public static final int SPADES   = 0;
		public static final int HEARTS   = 1;
		public static final int CLUBS    = 2;
		public static final int DIAMONDS = 3;

		// Card faces (provided for your convenience - use is optional)
		public static final int ACE      = 1;
		public static final int TWO      = 2;
		public static final int THREE    = 3;
		public static final int FOUR     = 4;
		public static final int FIVE     = 5;
		public static final int SIX      = 6;
		public static final int SEVEN    = 7;
		public static final int EIGHT    = 8;
		public static final int NINE     = 9;
		public static final int TEN      = 10;
		public static final int JACK     = 11;
		public static final int QUEEN    = 12;
		public static final int KING     = 13;

		
		// define fields here
		public int suit;
		public int face;
		
		// This constructor builds a card with the given suit and face, turned face down.
		public Card(int cardSuit, int cardFace)
		{
			suit = cardSuit;
			face = cardFace;
		}

		// This method retrieves the suit (spades, hearts, etc.) of this card.
		public int getSuit()
		{
			return suit; 
		}
		
		// This method retrieves the face (ace through king) of this card.
		public int getFace()
		{
			return face; 
		}
		
		// This method retrieves the numerical value of this card
		// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
		public int getValue()
		{
			if (face <= 10)
				return face;
			else 
				return 10;
		}
		 public String getSuitAsString() {
	            // Return a String representing the card's suit.
	            // (If the card's suit is invalid, "??" is returned.)
	        switch ( suit ) {
	           case SPADES:   return "Spades";
	           case HEARTS:   return "Hearts";
	           case DIAMONDS: return "Diamonds";
	           case CLUBS:    return "Clubs";
	           default:       return "??";
	        }
	    }
	    
	    public String getFaceAsString() {
	            // Return a String representing the card's value.
	            // If the card's value is invalid, "??" is returned.
	        switch (face) {
	           case 1:   return "Ace";
	           case 2:   return "2";
	           case 3:   return "3";
	           case 4:   return "4";
	           case 5:   return "5";
	           case 6:   return "6";
	           case 7:   return "7";
	           case 8:   return "8";
	           case 9:   return "9";
	           case 10:  return "10";
	           case 11:  return "Jack";
	           case 12:  return "Queen";
	           case 13:  return "King";
	           default:  return "??";
	        }
	    }
	    
	    public String toString() {
	           // Return a String representation of this card, such as
	           // "10 of Hearts" or "Queen of Spades".
	        return getFaceAsString() + " of " + getSuitAsString();
	    }


}

