

package pwbdblackjack;

import java.util.Scanner;
/**
 *
 * @author Adhitama Patrick Ferdinand, Brian Liman, Weiye Chen, Daisong Shi
 * 
 */
public class PWBDBlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Welcome to Blackjacak!");
        
        //PlayingDeck will be the deck for the dealer holds
        Deck PlayingDeck = new Deck();
        PlayingDeck.createFullDeck();
        PlayingDeck.shuffle();
        
        //DealerCards will be the cars the dealer has in their hand
        Deck DealerCards = new Deck();

        //PlayerCards will be the cards the player from dealer
        Deck PlayerCards = new Deck();
        
        //PlayerMoney is the points they have
        double PlayerMoney = 100.0;
        
        //Scanner for how much points the Player enter
        Scanner PlayerInput = new Scanner(System.in);
        
        //Start the game,Player must have money > 0 to play
        while(PlayerMoney > 0){
            System.out.println("You have $" + PlayerMoney + 
                    ", how much you want to bet");
            
            //system get the bet from Player's enter
            double PlayerBet = PlayerInput.nextDouble();
            
            boolean end = false;
            if (PlayerBet > PlayerMoney){
                System.out.println("You can;t enter the bit greater than you have");
                break;
            }
            
                System.out.println("Dealing...");
                //Player and Dealer both get two cards
                PlayerCards.draw(PlayingDeck);
                PlayerCards.draw(PlayingDeck);
                
                DealerCards.draw(PlayingDeck);
                DealerCards.draw(PlayingDeck);
                
                //use while loop for drawing new cards
                while(true){
                    
                    //Display Player and Dealer cards
                    System.out.println("Your Hand:" + PlayerCards.toString());
                    System.out.println("Dealer Hand: " + DealerCards.getCard(0).toString()
                            + " and [hidden]");
                    
                    //Display value of Player's cards
                    System.out.println("Your hand is currently valued at: "
                            + PlayerCards.cardsValue());
                    
                    //Ask Player what they wants to do next
                    System.out.println("Would you like to (1)Hit or (2)Stand");
				int response = PlayerInput.nextInt();	
				//when hit
				if(response == 1){
					PlayerCards.draw(PlayingDeck);
					System.out.println("You draw a:" + PlayerCards.getCard(PlayerCards.deckSize()-1).toString());
					//Bust if value go over 21
					if(PlayerCards.cardsValue() > 21){
						System.out.println("Bust. Currently valued at: " + PlayerCards.cardsValue());
						PlayerMoney -= PlayerBet;
						end = true;
						break;
					}
				}
                                //when stand
                                if(response == 2){
                                    break;
                                }
                }
                
                //Display Dealer's hidden card
                System.out.println("Dealer Cards:" + DealerCards.toString());
                
                //Check if Dealer has more value than Player
                if((DealerCards.cardsValue() > PlayerCards.cardsValue())&& end == false){
				System.out.println("Dealer beats you " + DealerCards.cardsValue() 
                                        + " to " + PlayerCards.cardsValue());
				PlayerMoney -= PlayerBet;
				end = true;
			}
                
                //Dealer hits at 16 stands at 17
                while((DealerCards.cardsValue() < 17) && end == false){
				DealerCards.draw(PlayingDeck);
				System.out.println("Dealer draws: " + DealerCards.getCard(DealerCards.deckSize()-1).toString());
			}
                
                //Display value of Dealer
                System.out.println("Dealers hand value: " + DealerCards.cardsValue());
			//Check if dealer busted
			if((DealerCards.cardsValue()>21)&& end == false){
				System.out.println("Dealer Busts. You win!");
				PlayerMoney += PlayerBet;
				end = true;
                        }
                        
                //Check if push
                if((DealerCards.cardsValue() == PlayerCards.cardsValue()) && end == false){
				System.out.println("Push.");
				end = true;
                }
                
                //Check if player wins
                if((PlayerCards.cardsValue() > DealerCards.cardsValue()) && end == false){
				System.out.println("You win the hand.");
				PlayerMoney += PlayerBet;
				end = true;
			}else if (end == false) {
                            //Dealer wins
                            System.out.println("Dealer wins.");
				PlayerMoney -= PlayerBet;
                        }             
                //End of hand - put cards back in deck
			PlayerCards.moveAllToDeck(PlayingDeck);
			DealerCards.moveAllToDeck(PlayingDeck);
			System.out.println("End of Hand.");
        }
       
                //Game is over
		System.out.println("Game over! You lost all your money. :(");
		
		//Close Scanner
		PlayerInput.close();
                    
    }    
   
    
    public static boolean checkPlayerHand(double PlayerBet, double PlayerMoney)
    {
        boolean PlayerHand = false;
        if(PlayerBet>0 && PlayerMoney>0 && PlayerBet <= PlayerMoney){
            PlayerHand = true;
        }
   return PlayerHand;
    }
    
    
    public static boolean checkHandValue(double PlayerValue, double AiValue)
    {
       boolean HandValue = false;
       if(PlayerValue<=21 && AiValue<21 && PlayerValue>AiValue){
            HandValue = true;
       }
       return HandValue;
    }
    
    
    
}    


  
