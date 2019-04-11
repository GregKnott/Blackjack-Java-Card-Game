/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;


/**
 *
 * @author Greg
 */
public class BlackJackCard extends Card{
    
    public BlackJackCard() {
        super(Card.Suit.values()[ (int) (Math.random() * Suit.values().length)], 
                Card.Value.values()[ (int) (Math.random() * Value.values().length)]);
    } 
    
    public BlackJackCard( String s, String v)
    {
        super(Suit.valueOf(s.toUpperCase()),Value.valueOf(v.toUpperCase()));
    }
    
    public BlackJackCard(String v)
    {
        super(Card.Suit.values()[ (int) (Math.random() * Suit.values().length)],Value.valueOf(v.toUpperCase()));
    }

    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
    
}
