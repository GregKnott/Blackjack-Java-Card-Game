/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package deliverable1;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     */
    public enum Suit {CLUBS, SPADES, DIAMONDS, HEARTS};
        public enum Value {ACE_ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, JACK, QUEEN, KING, ACE_ELEVEN}; //Jack, Queen, King worth 10, ace is worth 1 or 11
        private final Suit suit;
        private final Value value;
        
        public Card(Suit givenSuit, Value givenValue)
        {
           suit = givenSuit;
           value = givenValue;
        }
	public Value getValue() 
        {
		return this.value;
	}
        
	public Suit getSuit() 
        {
		return this.suit;
        } 
    @Override
    public abstract String toString();
    
}
