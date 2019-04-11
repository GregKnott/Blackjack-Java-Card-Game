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
public class PlayGame 
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        
        new Blackjack().play();
        
        System.out.print("Play Again? Y/N: ");
        String choice = scan.next();
        while (choice.equalsIgnoreCase("y"))
        {
            System.out.println();
            new Blackjack().play();
            System.out.print("Play Again? Y/N: ");
            choice = scan.next();
        }
        System.out.println("Thanks for playing!");
        
    }
}
