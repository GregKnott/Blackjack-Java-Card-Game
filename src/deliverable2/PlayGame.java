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
public class PlayGame 
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        Blackjack game1 = new Blackjack();
        game1.play();
        
        
        
        System.out.print("Play Again? Y/N: ");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("y"))
        {
            System.out.println();
            game1.play();
        }
        else{
            System.out.println("Thanks for playing!");
        }
    }
}
