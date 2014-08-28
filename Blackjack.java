/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author rtarantino
 */

import java.util.Scanner;
import java.util.Random;

public class Blackjack {

  
    public static void main(String[] args) {
       Scanner reader = new Scanner(System.in);
       Random generator = new Random();
       
       int intPCard1, intPCard2, //The players cards
           intDCard1, intDCard2, //The dealers cards
           intDollars,           // The amount of dollars started with
           intCount,             //The count
           intMaxDollars,        // The highest amount of dollars earned
           intCountMax;          // Count when the maxiumum is achieved 
       
       //Asks the user how many dollars they start with
       System.out.print("How many dollars would you like to start with? ");
       intDollars = reader.nextInt();
       
       //Initilizes the variables
       intMaxDollars = intDollars;
       intCountMax = 0;
       intCount = 0;
       
       //Loop until money is gone
       while(intDollars > 0){
           intCount++;
           
           //Deals the cards
           intPCard1 = generator.nextInt(4) +1;
           intPCard2 = generator.nextInt(4) +1;
           intDCard1 = generator.nextInt(4) +1;
           intDCard2 = generator.nextInt(4) +1;
           
           //Determines winner and distributes winnings
           if((intPCard1 + intPCard2) > (intDCard1 +intDCard2))
               intDollars += 2;
           else
               intDollars -= 1;
           
           if(intDollars > intMaxDollars){
               intMaxDollars = intDollars;
               intCountMax = intCount;
           }
       }
       //Displays results
       System.out.println("You are broke after " + intCount + " hands. "
               + "You should have quit after " + intCountMax + " hands when "
               + "you had $" + intMaxDollars + ".");  
    }
}
