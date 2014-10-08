// This class represents one blackjack player (or the dealer)
public class Player
{
	
	// define fields here
    private Card[] cards = new Card[10000];         // the cards
    private int N = 0;                                  // number of cards
    private String name;      								// player's name
    private boolean isDealer;                           //dealer check
	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
    
    public Card peak()         { return cards[0];   }    // return first card
    public void dealTo(Card c) { cards[N++] = c;    }    // insert card
    public void reset()        { N = 0;             }    // discard all cards
    
	public Player(String playerName, boolean isDealer)
	{
        this.name = playerName;
        this.isDealer = isDealer;
    }

	// This method retrieves the player's name.
	public String getName()
	{
		return null; // replace this line with your code
	}

	/**
	This method retrieves the player's hand of cards.
	public String getHand()
	{   
		String s = name + "  (" + Hand() + ")  ";
		for (int i = 0; i < N; i++)
			s += cards[i] + " ";
		return s;
	}
	**/
	
	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{
		// complete this method
	}

	// This method executes gameplay for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{
		// complete this method
	}

	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.
	public void finishRound(int dealerScore, BlackjackWindow window)
	{
		// complete this method
	}
	


}

