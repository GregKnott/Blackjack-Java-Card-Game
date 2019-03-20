/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable2;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class Blackjack extends Game
{
    Scanner scan = new Scanner(System.in);
    int choice = 0;
    private double bet;
    private double winnings;
    public int total = 0;
    public int counter = 0;
    public boolean userBusted = false;
    public boolean dealerBusted = false;
    
    public Hand initHand = new Hand(2);
    public Hand dealerHand = new Hand(1);
    
    public Blackjack() {
        super("Blackjack");
    }
    
    public void declareWinner()
    {
        //if the player wins the bet is doubled and given back
        System.out.println();
        if (userBusted == false && dealerBusted == true) //Used after the dealer busts
        {
            winnings += getBet();
            System.out.println("You won $" + winnings);
        }
        
        else if (userBusted == false && dealerBusted == false && initHand.getTotal() > dealerHand.getTotal())
        {
            winnings += getBet();
            System.out.println("You won $" + winnings);
        }
        
        else if (userBusted == false && dealerBusted == false && initHand.getTotal() < dealerHand.getTotal())
        {
            System.out.println("You lost");
        }
        
    }
    
    public void play()
    {
        System.out.println("New Game of Blackjack");
        System.out.print("Place your bet: $");
        setBet(scan.nextDouble());
        System.out.println("Your cards are " + initHand.toString());
        
        System.out.println("The dealer was dealt " + dealerHand.toString());
        choiceMenu();
    }
    
    
    public void choiceMenu()
    {
        
        if(counter >= 1)
        {
            System.out.println("1 = [Hit], 2 = [Split], 3 = [Show Cards] 4 = [Stand]");
            choice = scan.nextInt();
            System.out.println();
            switch(choice)
            {
                case 1: 
                    hit(initHand);
                    choice = 0;
                    break;
                case 2: 
                    split();
                    choice = 0;
                    break;
                case 3:
                    System.out.println("Your cards are " + initHand.toString());
                    System.out.println("The dealer's card is " + dealerHand.toString());
                    choice = 0;
                    break;
                case 4: //Stand means stay with your cards
                    stand();
                    choice = 0;
                    break;
            }
        }
        else{
            System.out.println("1 = [Hit], 2 = [Double Down], 3 = [Split], 4 = [Show Cards] 5 = [Stand]");
            choice = scan.nextInt();
            System.out.println();
        switch(choice)
            {
                case 1: 
                    hit(initHand);
                    choice = 0;
                    break;
                case 2:
                    doubleDown();
                    choice = 0;
                    break;
                case 3: 
                    split();
                    choice = 0;
                    break;
                case 4:
                    System.out.println("Your cards are " + initHand.toString());
                    System.out.println("The dealer's card is " + dealerHand.toString());
                    choiceMenu();
                    choice = 0;
                    break;
                case 5: //Stand means stay with your cards
                    stand();
                    choice = 0;
                    break;
            }
        }
    }
    
    public void hit (Hand givenHand)
    {
        //Add new card to deck
        givenHand.addCard();
        System.out.println(givenHand.getLast() + " was dealt");
        System.out.println("The card total is: " + givenHand.getTotal());
        
        if (initHand.getTotal() > 21)
        {
            System.out.println("You Busted!");
            userBusted = true;
            stand();
        }
        else if (initHand.getTotal() == 21)
        {
            System.out.println("Perfect Hand!");
            userBusted = false;
            stand();
        }
        else if (initHand.getTotal() < 21)
            choiceMenu();
            
        
        
        
    }
    
    public void doubleDown()
    {
        //If they have reached a score of nine, ten or eleven with their first two cards, they can double their bet. However if they do so, they will be dealt only one more card.
        if (initHand.getTotal() == 9 || initHand.getTotal() == 10 || initHand.getTotal() == 11)
        {
            counter++;
            setBet(bet * 2);
            hit(initHand);
        }
        else
        {
            System.out.println("You need to have a card total of 9,10 or 11 to select that option!");
            choiceMenu();
        }
    
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
    
    public double getWinnings()
    {
        return winnings;
    }
    
    //This starts on the dealer's turn
    public void stand ()
    {
        System.out.println();
        System.out.println("Dealer's Turn");
        if(userBusted == true)
        {
            declareWinner();
        }
        else {
            
            dealerHand.addCard();
            System.out.println("The dealer's cards are " + dealerHand.toString());
            
            //if the dealer's total is 17 or over he must stand
            if (dealerHand.getTotal() >= 17)
            {
                declareWinner();
            }
            else if (dealerHand.getTotal() == 21)
            {
                System.out.println("The dealer has a perfect hand!");
            }
            else 
            {
                while (dealerHand.getTotal() < 17)
                {
                    System.out.println("The dealer hit");
                    dealerHand.addCard();
                    System.out.println(dealerHand.getLast() + " was dealt");
                    System.out.println("The dealer's cards are " + dealerHand.toString());
                  if (dealerHand.getTotal() >= 17)
                {
                    break;
                }
                else if (dealerHand.getTotal() == 21)
                {
                    System.out.println("The dealer has a perfect hand!");
                    break;
                }
                }
                System.out.println("The dealer stays with " + dealerHand.getTotal());
                declareWinner();
            }
            
//            if (dealerBusted == true)
//            {
//                
//            }
        }
        
        
    }
    
    
}
