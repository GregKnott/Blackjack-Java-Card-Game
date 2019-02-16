/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1;

/**
 *
 * @author Greg
 */
public class Blackjack extends Game
{
    private double bet;
    public Blackjack() {
        super("Blackjack");
    }
    
    public void declareWinner()
    {
        
    }
    
    public void play()
    {
        GroupOfCards initHand = new GroupOfCards(2);
        System.out.println("New Game of Blackjack");
        //System.out.println(display two cards that are dealt here);
        //System.out.println("1 = [Hit], 2 = [Double Down], 3 = [Split], 4 = [Show Cards]");
    }
    
    public void hit ()
    {
        //Add new card to deck
    }
    
    public void doubleDown()
    {
        //If they have reached a score of nine, ten or eleven with their first two cards, they can double their bet. However if they do so, they will be dealt only one more card.
    }
    
    public void split()
    {
        //each of the cards are used to start with a separate bet
    }
    
    public void setBet (double givenBet)
    {
        bet = givenBet;
    }
    
    public double getBet ()
    {
        return bet;
    }
}
