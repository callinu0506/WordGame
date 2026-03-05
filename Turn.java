// Jessie Baker, JES2371614
// CIS263AA, LESSON 3
// DATE: 03/04/26

import java.util.Scanner;

// Class to handle player's turns.

public class Turn
{
   // Method to get player's guess, check against random number,
   // update their money, and display balance.
   public boolean takeTurn(Players player, Hosts host)
   {
      
         Scanner input = new Scanner(System.in);
         int playerGuess;
         boolean corrGuess = false;
         Numbers gameNum = new Numbers();
         int lostMoney = 200;
         int winMoney = 1000;
      
         
         // Get player's guess.
         System.out.print(host.fullName() + " says \"");
         System.out.print(player.fullName() + ", enter your guess for my random ");
         System.out.println("number between 0 and 100\"");
         playerGuess = input.nextInt();
         
         // Check guess against randomized number.
         corrGuess = gameNum.compareNumber(playerGuess);
         
         // Add or subtract based on if guess is correct or incorrect.
         if (corrGuess)
         {
            player.setMoney(player.getMoney() + winMoney);
            System.out.println("You win $" + winMoney + ".00");
            System.out.println(player);   
         }
         else
         {
            player.setMoney(player.getMoney() - lostMoney);
            System.out.println("You lost $" + lostMoney + ".00");
            System.out.println(player);
         }
         
         return corrGuess;
      }

}