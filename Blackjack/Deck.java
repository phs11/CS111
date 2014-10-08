
		   		// This constructor builds a deck of 52 cards.
			// This class represents the deck of cards from which cards are dealt to players.
public class Deck{
				// define fields here
			private Card[] deck;
			private int top;
			// This constructor builds a deck of 52 cards.
		public Deck() {
			deck = new Card[52];
			int numCards = 0; // How many cards have been created so far.
			for (int suit = 0; suit <= 3; suit++) {
				for (int face = 1; face <= 13; face++) {
					deck[numCards] = new Card(suit, face);
					numCards++;
				}
			}
			top = 0;
		}
	
		public void shuffle() {
	        for ( int i = 51; i > 0; i-- ) {
	            int rand = (int)(Math.random()*(i+1));
	            Card temp = deck[i];
	            deck[i] = deck[rand];
	            deck[rand] = temp;
	        }
			top = 0;
		}
		
	    public int cardsLeft(){
	        return 52 - top;
	    }
	    
		// This method takes the top card off the deck and returns it.
		public Card deal()
		{
	        if (top == 52)
	            shuffle();
	         top++;
	         return deck[top - 1];
		}
		
		public boolean isEmpty()
		{
			boolean empty = false;
			if(52-top == 0){
				empty = true;
			}else{
				empty = false;
			}
			return empty;
		}
	

	/**	
		public Card[] createCardArray(){
            
	        int[] faces = {Card.ACE, Card.TWO, Card.THREE, Card.FOUR, Card.FIVE, Card.SIX,
	                        Card.SEVEN, Card.EIGHT, Card.NINE, Card.TEN, Card.JACK, Card.QUEEN, Card.KING};
	       
	        deck = new Card[52];
	        for(int i = 0; i<faces.length; i++){
	       
	               
	                        for(int j = 0; j < faces.length; j++){
	                                deck[i] = new Card(Card.SPADES, faces[j]);    
	                                i++;
	                        }
	                        for(int k = 0; k < 13; k++){
	                                deck[i]= new Card(Card.DIAMONDS,faces[k]);
	                                i++;
	                        }
	                        for(int l = 0; l < 13; l++){
	                                deck[i]= new Card(Card.CLUBS, faces[l]);
	                                i++;
	                        }
	                        for(int m = 0; m < 13; m++){
	                                deck[i]= new Card(Card.HEARTS, faces[m]);
	                                i++;
	                        }
	                                continue;
	                        }
	                return deck;
	}


		
	       
	        public String toString(int suit, int face){
	               
	                String suitResult = " ";
	                String faceResult = " ";
	               
	                        if(suit==0){
	                        	suitResult = "SPADES";
	                        }
	                        else if(suit==1){
	                        	suitResult = "HEARTS";
	                        }
	                        else if(suit==2){
	                        	suitResult = "CLUBS";
	                        }
	                        else if(suit==3){
	                        	suitResult = "DIAMONDS";
	                        }
	                        
	                        if(face==1){
	                        	faceResult = "ACE";
	                        }
	                        else if(face==2){
	                        	faceResult = "TWO";    
	                        }
	                        else if(face==3){
	                        	faceResult = "THREE";
	                        }
	                        else if(face==4){
	                        	faceResult = "FOUR";
	                        }
	                        else if(face==5){
	                        	faceResult = "FIVE";
	                        }
	                        else if(face==6){
	                        	faceResult = "SIX";
	                        }
	                        else if(face==7){
	                        	faceResult = "SEVEN";
	                        }
	                        else if(face==8){
	                        	faceResult = "EIGHT";
	                        }
	                        else if(face==9){
	                        	faceResult = "NINE";
	                        }
	                        else if(face==10){
	                        	faceResult = "TEN";
	                        }
	                        else if(face==11){
	                        	faceResult = "JACK";
	                        }
	                        else if(face==12){
	                        	faceResult = "QUEEN";
	                        }
	                        else if(face==13){
	                        	faceResult = "KING";
	                        }
	               
	                return faceResult + " of " + suitResult;
	        }
**/
		
	}
		

	    

//Create a simple game engine that “deals” cards to 2 players. Continue to deal until either player busts, or when each player 
//has requested a “stand”. You will need to show the player’s cards and ask if the user wants to hit or stand. You should not ask
//if the user has already busted. Determine the outcome of the game and print who won. Expand this game to N players.

//hit or stand use IO -- hit deal another card
//busted - if statement evaluate card value to over 21
//if have ace and reassign ace to one would change value
//greater than dealer without busting = win or if = 21
//make dealer stay if over 16
//use math.rand to shuffle deck
