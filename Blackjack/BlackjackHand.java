
public class BlackjackHand extends Hand{

	public int getBlackjackValue(){
		
		int handVal = 0;
		boolean isAce = false;
		int numCards = getNumberOfCards();
		
		for(int i = 0; i<numCards; i++){
			Card card;      // The i-th card; 
			int cardVal;    // The blackjack value of the i-th card.
			card = getCard(i);
			cardVal = card.getFace();   // The normal value, 1 to 13.
			if(cardVal>10){
				cardVal = 10;	//Jack, Queen, or King
			}
			if(cardVal==1){
				isAce = true;	//There's at least one ace
			}	
			handVal = handVal + cardVal;
		}
		//val is the value of the hand, counting any ace as 1.
        // If there is an ace, and if changing its value from 1 to 
        // 11 would leave the score less than or equal to 21,
        // then do so by adding the extra 10 points to val. 
		if(isAce == true && handVal + 10 <= 21){
			handVal = handVal + 10;
		}
		return handVal;
	}

	
}
