
public class Blackjack{
	// This method should:
	// - Ask the user how many people want to play (up to 3, not including the
	// dealer).
	// - Create an array of players. (ask user for player's name) and the dealer
	// - Create a Blackjack window.
	// - Play rounds until the players want to quit the game.
	// - Close the window.
	public static int numPlayers;
	public static int bet = 1; // Amount user bets on a game.
	public static int money; // Amount of money the user has.
	
	public static void main(String[] args) {
		// complete this method
		
		boolean userWins; // Did the user win the game?
		String name = null; //player name
		

		System.out.println("Welcome to the game of blackjack.");

		System.out.println("How many players are there? (Up to 3 players, not including the Dealer)");
		numPlayers = IO.readInt();
		while(numPlayers < 1 || numPlayers > 3){
			System.out.println("How many players are there? (Up to 3 players, not including the Dealer)");
			numPlayers = IO.readInt();
		}

		money = 100; // player starts with $100

		for(int num = 1; num<=numPlayers; num++){
			System.out.println("Enter the name of player " + num + ".");
			name = IO.readString();
			name = name.toUpperCase();
			money = 100;
			while(bet > 0 || bet < money){
	
				System.out.println( name + " has $" + money + ".");
				System.out.println("How many dollars would you like to bet?  (Enter 0 to leave the table)");
				bet = IO.readInt();
				if (bet < 0 || bet > money)
					System.out.println("Your bet must be between 0 and "+ money + '.');
				if (bet == 0){
					break;
				}
				userWins = playBlackjack();
				if (userWins == true){
					money = money + bet;
				}else{
					money = money - bet;
				}
				if (money <= 0) {
					System.out.println(name + " is broke.");
					money = 0;
					break;
				}
			}
		}
		System.out.println(name + " leaves the table with $" + money + '.');
	} // end main()

	static boolean playBlackjack() {
		//return true if player wins, false if dealer wins

		Deck deck;					//new deck every game
		BlackjackHand dealerHand;	//hand of dealer
		BlackjackHand userHand; 	//hand of player
		BlackjackHand secondHand;	//second hand used when split

		deck = new Deck();
		dealerHand = new BlackjackHand();
		userHand = new BlackjackHand();
		secondHand = new BlackjackHand();

		/* Shuffle the deck, then deal two cards to each player. */

		deck.shuffle();
		dealerHand.addCard(deck.deal());
		dealerHand.addCard(deck.deal());
		userHand.addCard(deck.deal());
		userHand.addCard(deck.deal());
		secondHand.addCard(userHand.getCard(0));

		/*
		 * Check if one of the players has Blackjack (two cards totaling to 21).
		 * The player with Blackjack wins the game. Dealer wins ties.
		 */

		if (dealerHand.getBlackjackValue() == 21) {
			System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
			System.out.println("Player has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
			System.out.println("Dealer has Blackjack.  Dealer wins.");
			return false;
		}

		if (userHand.getBlackjackValue() == 21) {
			System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
			System.out.println("Player has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
			System.out.println("You have Blackjack.  You win.");
			return true;
		}

		/*
		 * If neither player has Blackjack, play the game. First the user gets a
		 * chance to draw cards (i.e., to "Hit"). The while loop ends when the
		 * user chooses to "Stand". If the user goes over 21, the user loses
		 * immediately.
		 */

		while (true) {

			/* Display user's cards, and let user decide to Hit or Stand. */
			
//This can only be done with a two card hand, before another card has been drawn. Doubling down allows you to double your bet 
//and receive one, and only one, additional card to the hand.   ---double down
			
			//SPLITTING PAIRS - If the first two cards a player is dealt are a pair, he may split them into two separate hands, bet the same
			//amount on each and then play them separately. Aces receive only one additional card. After splitting, A-10 counts as 21 and not as blackjack.
			System.out.println("Your cards are:");
			for (int i = 0; i < userHand.getNumberOfCards(); i++) {
				System.out.println("    " + userHand.getCard(i));
			}
			
			if(userHand.getCardFace(0) == userHand.getCardFace(1)){
				boolean split = false;
				System.out.println("You have two Cards of the same Face, Would you like to split? (Enter yes or no)");
				split = IO.readBoolean();
				if(split == true){
					if(bet * 2 < money){
						bet = bet * 2;
					}else{
					System.out.println("Can't match bet, you lose this round.");
					return false;
					}
					System.out.println("Player split, bet increased to " + bet + ".");
				
					userHand.removeCard(1);		//splitting, remove the second card and make new hand
					
					Card newCard = deck.deal();			//first hand
					userHand.addCard(newCard);
					System.out.println("The dealer dealt a card to your first hand and gave you: " + newCard);
					System.out.println("Your cards for the first hand are:");
					for (int i = 0; i < userHand.getNumberOfCards(); i++) {
						System.out.println("    " + userHand.getCard(i));
					}
					
					
					if(userHand.getBlackjackValue() < 11){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player can not bust and should hit or Double down.]");
					}else if(userHand.getBlackjackValue() == 11){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should double down, 16/52 chance to recieve blackjack.]");
					}else if(userHand.getBlackjackValue()==12){	
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 16/52 of the time.]");
					}else if(userHand.getBlackjackValue()==13){	
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 20/52 of the time.]");
					}else if(userHand.getBlackjackValue()==14){	
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 24/52 of the time.]");
					}else if(userHand.getBlackjackValue()==15){	
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 28/52 of the time.]");
					}else if(userHand.getBlackjackValue()==16){	
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 32/52 of the time.]");
					}else if(userHand.getBlackjackValue()==17){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 36/52 of the time.]");
					}else if(userHand.getBlackjackValue()==18){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 40/52 of the time.]");
					}else if(userHand.getBlackjackValue()==19){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 44/52 of the time.]");
					}else if(userHand.getBlackjackValue()==20){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 48/52 of the time.]");	
					}else if(userHand.getBlackjackValue() == 21){
						System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player has blackjack.]");
						break;
					}
					System.out.println("Dealer is showing the " + dealerHand.getCard(0));
					System.out.println("Hit (Enter H) Stand (Enter S)");
					char hORs = IO.readChar(); 
					hORs = Character.toUpperCase(hORs);
					while(hORs != 'H' && hORs != 'S' && hORs != 'D'){
						System.out.println("Please respond H or S:  ");
						hORs = IO.readChar();
						hORs = Character.toUpperCase(hORs);
					}
					if (hORs == 'S') {
						System.out.println("Player stands.");
							// Loop ends when the player is done taking cards.
					} else if(hORs == 'H'){ 	//else player hits ('H')	
						newCard = deck.deal();
						userHand.addCard(newCard);
						System.out.println("Player hits.");
						System.out.println("The dealer gave you: " + newCard);
						System.out.println("Your total is now " + userHand.getBlackjackValue());
						if (userHand.getBlackjackValue() > 21) {
							System.out.println("You busted by going over 21.  You lose.");
							System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
							return false;
						}
						if(userHand.getBlackjackValue() == 21){
							break;
						}

					}
					
					secondHand.addCard(newCard);			//second hand
					System.out.println("The dealer dealt a card to your second hand and gave you: " + newCard);
					System.out.println("Your cards for the second Hand are:");
					for (int i = 0; i < secondHand.getNumberOfCards(); i++) {
						System.out.println("    " + secondHand.getCard(i));
					}
					
					if(secondHand.getBlackjackValue() < 11){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player can not bust and should hit or Double down.]");
					}else if(secondHand.getBlackjackValue() == 11){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should double down, 16/52 chance to recieve blackjack.]");
					}else if(secondHand.getBlackjackValue()==12){	
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 16/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==13){	
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 20/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==14){	
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 24/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==15){	
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 28/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==16){	
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 32/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==17){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 36/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==18){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 40/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==19){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 44/52 of the time.]");
					}else if(secondHand.getBlackjackValue()==20){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 48/52 of the time.]");	
					}else if(secondHand.getBlackjackValue() == 21){
						System.out.println("Your total is " + secondHand.getBlackjackValue() + "   [Player has blackjack.]");
						break;
					}
					System.out.println("Dealer is showing the " + dealerHand.getCard(0));
					System.out.println("Hit (Enter H) Stand (Enter S)");
					hORs = IO.readChar(); 
					hORs = Character.toUpperCase(hORs);
					while(hORs != 'H' && hORs != 'S' && hORs != 'D'){
						System.out.println("Please respond H or S:  ");
						hORs = IO.readChar();
						hORs = Character.toUpperCase(hORs);
					}
					if (hORs == 'S') {
						System.out.println("Player stands.");
						break;	// Loop ends when the player is done taking cards.
					} else if(hORs == 'H'){ 	//else player hits ('H')	
						newCard = deck.deal();
						secondHand.addCard(newCard);
						System.out.println("Player hits.");
						System.out.println("The dealer gave you: " + newCard);
						System.out.println("Your total is now " + secondHand.getBlackjackValue());
						if (secondHand.getBlackjackValue() > 21) {
							System.out.println("You busted by going over 21.  You lose.");
							System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
							return false;
						}
						if(secondHand.getBlackjackValue() == 21){
							break;
						}

					}
					
					
					System.out.println("Dealer's cards are");
					System.out.println("    " + dealerHand.getCard(0));
					System.out.println("    " + dealerHand.getCard(1));
					while (dealerHand.getBlackjackValue() <= 16) {
						newCard = deck.deal();
						System.out.println("Dealer hits and gets the " + newCard + ".");
						dealerHand.addCard(newCard);
						if (dealerHand.getBlackjackValue() > 21) {
							System.out.println("Dealer busted by going over 21.  You win.");
							return true;
						}
					}
					System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

					if ((dealerHand.getBlackjackValue() == userHand.getBlackjackValue() && dealerHand.getBlackjackValue() > secondHand.getBlackjackValue()) 
							|| (dealerHand.getBlackjackValue() == secondHand.getBlackjackValue() && dealerHand.getBlackjackValue() > userHand.getBlackjackValue())){
						System.out.println("Dealer wins on a tie.  You lose.");
						return false;
					} else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue() && dealerHand.getBlackjackValue() > secondHand.getBlackjackValue()) {
						System.out.println("Dealer wins, " + dealerHand.getBlackjackValue() + " points to " + userHand.getBlackjackValue() + " / " + secondHand.getBlackjackValue() + ".");
						return false;
					} else if(dealerHand.getBlackjackValue() < userHand.getBlackjackValue()) {
						System.out.println("You win, " + userHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
						return true;
					}else if(dealerHand.getBlackjackValue() < secondHand.getBlackjackValue()){
						System.out.println("You win, " + secondHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
						return true;
					}
				}
			}
				
			
			if(userHand.getBlackjackValue() < 11){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player can not bust and should hit or Double down.]");
			}else if(userHand.getBlackjackValue() == 11){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should double down, 16/52 chance to recieve blackjack.]");
			}else if(userHand.getBlackjackValue()==12){	
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 16/52 of the time.]");
			}else if(userHand.getBlackjackValue()==13){	
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 20/52 of the time.]");
			}else if(userHand.getBlackjackValue()==14){	
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 24/52 of the time.]");
			}else if(userHand.getBlackjackValue()==15){	
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 28/52 of the time.]");
			}else if(userHand.getBlackjackValue()==16){	
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should hit, hitting will result in a bust 32/52 of the time.]");
			}else if(userHand.getBlackjackValue()==17){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 36/52 of the time.]");
			}else if(userHand.getBlackjackValue()==18){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 40/52 of the time.]");
			}else if(userHand.getBlackjackValue()==19){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 44/52 of the time.]");
			}else if(userHand.getBlackjackValue()==20){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player should stand, hitting will result in a bust 48/52 of the time.]");	
			}else if(userHand.getBlackjackValue() == 21){
				System.out.println("Your total is " + userHand.getBlackjackValue() + "   [Player has blackjack.]");
			}
			System.out.println("Dealer is showing the " + dealerHand.getCard(0));
			System.out.println("Hit (Enter H) Stand (Enter S) Double Down (Enter D)");
			char hORs = IO.readChar(); 
			hORs = Character.toUpperCase(hORs);
			while(hORs != 'H' && hORs != 'S' && hORs != 'D'){
				System.out.println("Please respond H or S or D:  ");
				hORs = IO.readChar();
				hORs = Character.toUpperCase(hORs);
			}
			
			
			/**
			  If the player Hits, he gets a card. If the player Stands, break the
			  loop ends and then it's the dealer's turn to draw cards
			 */
			while(hORs == 'D'){
				if(hORs == 'D' && userHand.getCard(2) == null ){
					Card newCard = deck.deal();
					userHand.addCard(newCard);
					if(bet * 2 < money){
						bet = bet * 2;
					}else{
					System.out.println("Can't match bet, you lose this round.");
					return false;
					}
					System.out.println("Player Doubled Down, bet increased to " + bet + ".");
					System.out.println("The dealer gave you: " + newCard);
					System.out.println("Your total is now " + userHand.getBlackjackValue());
					if (userHand.getBlackjackValue() > 21) {
						System.out.println("You busted by going over 21.  You lose.");
						System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
						return false;
					}
					if(userHand.getBlackjackValue() == 21){
						break;
					}
					System.out.println("Dealer's cards are");
					System.out.println("    " + dealerHand.getCard(0));
					System.out.println("    " + dealerHand.getCard(1));
					while (dealerHand.getBlackjackValue() <= 16) {
						newCard = deck.deal();
						System.out.println("Dealer hits and gets the " + newCard + ".");
						dealerHand.addCard(newCard);
						if (dealerHand.getBlackjackValue() > 21) {
							System.out.println("Dealer busted by going over 21.  You win.");
							return true;
						}
					}
					System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

					if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
						System.out.println("Dealer wins on a tie.  You lose.");
						return false;
					} else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
						System.out.println("Dealer wins, " + dealerHand.getBlackjackValue() + " points to " + userHand.getBlackjackValue() + ".");
						return false;
					} else {
						System.out.println("You win, " + userHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
						return true;
					}
				}else{
					System.out.println("You can't Double Down.");
					System.out.println("Your cards are:");
					for (int i = 0; i < userHand.getNumberOfCards(); i++) {
						System.out.println("    " + userHand.getCard(i));
					}
					System.out.println("Your total is " + userHand.getBlackjackValue());
					System.out.println("Dealer is showing the " + dealerHand.getCard(0));
					System.out.println("Hit (Enter H) Stand (Enter S) Double Down (Enter D)");
					hORs = IO.readChar(); 
					hORs = Character.toUpperCase(hORs);
					while(hORs != 'H' && hORs != 'S' && hORs != 'D'){
						System.out.println("Please respond H or S or D:  ");
						hORs = IO.readChar();
						hORs = Character.toUpperCase(hORs);
					}
					
				}
			}
				
			while (hORs != 'H' && hORs != 'S' && hORs != 'D');
			if (hORs == 'S') {
				System.out.println("Player stands.");
				break;	// Loop ends when the player is done taking cards.
			} else if(hORs == 'H'){ 	//else player hits ('H')
					
				Card newCard = deck.deal();
				userHand.addCard(newCard);
				System.out.println("Player hits.");
				System.out.println("The dealer gave you: " + newCard);
				System.out.println("Your total is now " + userHand.getBlackjackValue());
				if (userHand.getBlackjackValue() > 21) {
					System.out.println("You busted by going over 21.  You lose.");
					System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
					return false;
				}
				if(userHand.getBlackjackValue() == 21){
					break;
				}

			}
			

		} // end while loop

		/**
		 The user has Stood with 21 or less.
		 It's the dealer's turn to draw. Dealer draws cards until the
		 dealer's total is > 16. If dealer goes over 21, the dealer loses.
		 */


		System.out.println("Dealer's cards are");
		System.out.println("    " + dealerHand.getCard(0));
		System.out.println("    " + dealerHand.getCard(1));
		while (dealerHand.getBlackjackValue() <= 16) {
			Card newCard = deck.deal();
			System.out.println("Dealer hits and gets the " + newCard + ".");
			dealerHand.addCard(newCard);
			if (dealerHand.getBlackjackValue() > 21) {
				System.out.println("Dealer busted by going over 21.  You win.");
				return true;
			}
		}
		System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

		/*
		 * If we get to this point, both players have 21 or less. We can
		 * determine the winner by comparing the values of their hands.
		 */

		if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
			System.out.println("Dealer wins on a tie.  You lose.");
			return false;
		} else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
			System.out.println("Dealer wins, " + dealerHand.getBlackjackValue() + " points to " + userHand.getBlackjackValue() + ".");		
			return false;
		} else {
			System.out.println("You win, " + userHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
			return true;
		}
	}
	
	
//In the hints system, you provide hints based on the probabilites of outcomes given a "hit" operation. For example: if a player  has a  hand of 12, a hit operation will result in a "bust" in 16/52 of the time. 
//(there are 4 possible faces that can result in a bust - 10,J,Q,K, and there are 4 of each in a standard deck). You could also provide hints based on a table of static probabilities as listed in the Wikipedia article 
//(i.e. you have 12, the dealer has a 10 showing, the table says you should hit.)

	// This method executes an single round of play (for all players). It
	// should:
	// - Create and shuffle a deck of cards.
	// - Start the round (deal cards) for each player, then the dealer.
	// - Allow each player to play, then the dealer.
	// - Finish the round (announce results) for each player.
	

//DOUBLE DOWN - The player is allowed to double the bet on his first two cards and draw one additional card only to improve his 
//hand.  deal only ONE card  ** hint if equal to 10 or 11 suggest double down.
//SPLITTING PAIRS - If the first two cards a player is dealt are a pair, he may split them into two separate hands, bet the same
//amount on each and then play them separately. Aces receive only one additional card. After splitting, A-10 counts as 21 and not as blackjack.
//INSURANCE - If the dealer's up card is an ace, the player may take insurance, a bet not exceeding one-half his original bet.
//If the dealer's down card is a 10 or any face card, the player wins 2 to 1. Any other card means a win for the dealer.
	
	/**
	create and shuffle a deck
	for each player
		start round (deal first two cards)
	for dealer, start round (deal first two cards)
	for each player
		let player play round
	for dealer, play round
	for each player
		finish round (announce results, discard cards)
	for dealer, finish round (discard cards)
	**/
	

		
	}
