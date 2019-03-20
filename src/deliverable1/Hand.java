/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1;

import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class Hand extends GroupOfCards{
    
    private ArrayList<Card> cards = new ArrayList();
    
    public Hand(int givenSize) {
        super(givenSize);
        
        for (int i = 0; i < givenSize; i++)
        {
            cards.add(new BlackJackCard());
        }
        
    }
    
    public void addCard()
    {
        cards.add(new BlackJackCard());
    }
    
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public int getTotal()
    {
        int total = 0;
        for(Card c: cards){
            total += c.getValue().getIntValue();
        }
        return total;
    }
    
    public Card getLast()
    {
        return cards.get(cards.size() - 1);
    }
    
    public String toString()
    {
        String cardList = "";
        for (int i = 0; i < cards.size(); i++)
        {
            if (i == cards.size() -1)
                cardList += cards.get(i);
            else
                cardList += cards.get(i) + ", ";
        }
        
        return cardList + ", with a card total of " + getTotal();
    }
    
}
