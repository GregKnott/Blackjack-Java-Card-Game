/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class Blackjack extends Game
{
    Scanner scan = new Scanner(System.in);
    int choice = 0;
    private double bet = 1;
    double betTemp;
    private double winnings = 0;
    public int total = 0;
    public int counter = 0;
    public boolean userBusted = false;
    public boolean dealerBusted = false;
    public boolean winnerDeclared = false;
    
    public Hand userHand = new Hand(2);
    public Hand dealerHand = new Hand(1);
    
    public Blackjack() {
        super("Blackjack");
    }
    
    public void play()
    {
        userHand.shuffle();
        dealerHand.shuffle();
        System.out.println("New Game of Blackjack");
        
        do{
        System.out.print("Place your bet: $");
        betTemp = scan.nextDouble();
       
        if (canBet(betTemp)){
        setBet(betTemp);
        }
        else{
            System.out.println("ERROR: Bet needs to be higher than zero");
        }
        
        }while (!canBet(betTemp));
        
        System.out.println("Your cards are " + userHand.toString());
        
        System.out.println("The dealer was dealt " + dealerHand.toString());
        
        do{
        System.out.println("1 = [Hit], 2 = [Double Down], 3 = [Split], 4 = [Show Cards] 5 = [Stand]");
        choice = scan.nextInt();
        if(validChoice(choice)){
            choiceMenu(choice, userHand);
            break;
        }
        }while (!validChoice(choice));
        
        
        while (!winnerDeclared){
            if (userHand.getTotal() > 21)
            {
                System.out.println("You Busted!");
                userBusted = true;
                declareWinner();
                winnerDeclared = true;
            }
            else if (userHand.getTotal() == 21)
            {
                System.out.println("Perfect Hand!");
                userBusted = false;
                stand();
            }
            else if (userHand.getTotal() < 21){
                do{
            System.out.println("1 = [Hit], 2 = [Double Down], 3 = [Split], 4 = [Show Cards] 5 = [Stand]");
            choice = scan.nextInt();
            if(validChoice(choice)){
                choiceMenu(choice, userHand);
                break;
            }
            }while (!validChoice(choice));
            }
        }
    }
    
    public boolean validChoice(int choice)
    {
        boolean valid = false;
        switch(choice)
            {
                case 1: 
                    if (canHit(userHand)){
                    valid = true;

                    }
                    else {
                        valid = false;
                        System.out.println("Your Card Total Is Too High!");
                    }
                break;
                case 2:
                    if (canDoubleDown(userHand)){
                    valid = true;
                    }
                    else{
                        valid = false;
                        System.out.println("You need to have a card total of 9, 10 or 11 to select that option!");
                    }
                break;
                case 3: 
                    if(canSplit(userHand)){
                    choice = 0;
                    }
                    else{
                        System.out.println("You dont have the right amount of cards");
                    }
                break;
                case 4://no arguments to stop this from happening
                    valid = true;
                break;
                case 5:
                    valid = true;
                break;
                default: 
                    valid = false;
                break;
            }
        return valid;
    }
    
    
    public void choiceMenu(int choice, Hand givenHand)
    {
        System.out.println();
        switch(choice)
            {
                case 1: 
                    hit(givenHand);
                    break;
                case 2:
                    doubleDown(givenHand);
                    break;
                case 3: 
                    split(givenHand);
                    break;
                case 4:
                    System.out.println("Your cards are " + userHand.toString());
                    System.out.println("The dealer's card is " + dealerHand.toString());
                    break;
                case 5: //Stand means stay with your cards
                    stand();
                    choice = 0;
                    break;
            }
    }
    
    public boolean canHit(Hand givenHand)
    {
        boolean hit = false;
        
        if (givenHand.getTotal() >= 21){
            hit = false;
        }
        else
        {
            hit = true;
        }
            
       return hit;
    }
    
    public void hit (Hand givenHand)
    {
        //Add new card to deck
        givenHand.addRandomCard();
        System.out.println(givenHand.getLast() + " was dealt");
        System.out.println("The card total is: " + givenHand.getTotal());
    }
    
    public boolean canDoubleDown(Hand givenHand)
    {
        boolean dd = false;
        //If they have reached a score of nine, ten or eleven with their first two cards, they can double their bet. However if they do so, they will be dealt only one more card.
        if (givenHand.getTotal() == 9 || givenHand.getTotal() == 10 || givenHand.getTotal() == 11)
        {
            dd = true;
        }
        else
        {
            dd = false;
        }
        return dd;
    }
    
    public void doubleDown(Hand givenHand)
    {
        counter++;
        setBet(bet * 2);
        givenHand.addRandomCard();
    }
    
    public boolean canSplit(Hand givenHand)
    {
        boolean split = false;
        if (givenHand.getSize() == 2)
        {
            split = true;
        }
        else{
            split = false;
        }
        return split;
    }
    
    public void split(Hand givenHand)
    {
        //each of the cards are used to start with a separate bet
        Hand splitHand1 = new Hand();
        splitHand1.addCard(givenHand.showCards().get(0));
        
        Hand splitHand2 = new Hand();
        splitHand2.addCard(givenHand.showCards().get(1));
    }
    
    public boolean canBet(double givenBet)
    {
        if (givenBet > 0)
            return true;
        else 
            return false;
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
            dealerHand.addRandomCard();
            System.out.println("The dealer's cards are " + dealerHand.toString());
            
            //If the dealer's total is 17 or over they must stand
            if (dealerHand.getTotal() > 16)
            {
               
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
                    dealerHand.addRandomCard();
                    System.out.println(dealerHand.getLast() + " was dealt");
                    System.out.println("The dealer's cards are " + dealerHand.toString());
                  if (dealerHand.getTotal() >= 17)
                {
                    System.out.println("The dealer stays with " + dealerHand.getTotal());
                    break;
                }
                else if (dealerHand.getTotal() == 21)
                {
                    System.out.println("The dealer has a perfect hand!");
                    break;
                }
                }
                if(dealerHand.getTotal() > 21)
                {
                    dealerBusted = true;
                }
                else{
                System.out.println("The dealer stays with " + dealerHand.getTotal());
                }
            }
        
        declareWinner();
        winnerDeclared = true;
    }
    
    public void declareWinner()
    {
        //if the player wins the bet is doubled and given back
        System.out.println();
        
        if (userBusted == false && dealerBusted == false)
        {
           if (userHand.getTotal() > dealerHand.getTotal())
            {
                System.out.println("You won $" + (getBet()*2));
            }
           
           else if (userHand.getTotal() < dealerHand.getTotal())
            {
                System.out.println("You lost");
            }
            
           else if (userHand.getTotal() == dealerHand.getTotal())
            {
                System.out.println("You won your bet back: $" + getBet());
            }
        
        }
        else if (userBusted == true && dealerBusted == true)
        {
            System.out.println("You lost");
            
        }
      
        else if (userBusted == false && dealerBusted == true)
        {
            System.out.println("You won $" + (getBet()*2));
        }
        
        else if (userBusted == true && dealerBusted == false)
        {
            System.out.println("You lost");
        }
        
    }
}
