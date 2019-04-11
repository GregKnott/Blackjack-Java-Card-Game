/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package deliverable3;


/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * @modifier Greg Knott
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     */
    public enum Suit {CLUBS, SPADES, DIAMONDS, HEARTS};
        public enum Value {
            ACE (1), 
            TWO (2), 
            THREE (3), 
            FOUR (4), 
            FIVE (5), 
            SIX (6), 
            SEVEN (7), 
            EIGHT (8), 
            NINE (9), 
            JACK (10), 
            QUEEN (10), 
            KING (10);

            private final int intValue;

            public double getIntValue() { return intValue; }

            private Value(int val) {
                intValue = val;
            }
        }

         //Jack, Queen, King worth 10, ace is worth 1 or 11
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
        
        public int randomSuit()
        {
            return (int) (Math.random() * Value.values().length);
        }
        
    @Override
    public abstract String toString();
    
}
