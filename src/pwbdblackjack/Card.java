

package pwbdblackjack;

/**
 *
 * @author Adhitama Patrick Ferdinand, Brian Liman, Weiye Chen, Daisong Shi
 * 
 */
public class Card {
        
        //name and value for different cards
    
        private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value){
		this.suit = suit;
		this.value = value;
	}
	
	public String toString(){
		return this.suit.toString() + "-" + this.value.toString();
	}
	
	public Value getValue(){
		return this.value;
	} 
}
