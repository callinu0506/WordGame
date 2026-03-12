// Jessie Baker, JES2371614
// CIS263AA, LESSON 4
// DATE: 03/10/26

import java.util.Scanner;
import java.util.Random;


// Class to handle player's turns.

public class Turn
{
   // Method to get player's guess, check against random number,
   // update their money, and display winnings.
   public boolean takeTurn(Players player, Hosts host)
   {
      
         Scanner input = new Scanner(System.in);
         int playerGuess;
         boolean corrGuess = false;
         Numbers gameNum = new Numbers();
         int winMoney;
      
         
         // Get player's guess.
         System.out.print(host.fullName() + " says \"");
         System.out.print(player.fullName() + ", enter your guess for my random ");
         System.out.println("number between 0 and 100\"");
         playerGuess = input.nextInt();
         
         // Check guess against randomized number.
         corrGuess = gameNum.compareNumber(playerGuess);
         
         Random random = new Random();
         
         // Random number generated for prize choice.
         // Even calls Money and Odd calls Physical Prize.
         // Add or subtract based on if guess is correct or incorrect and award is Money.
         if (random.nextInt(101) % 2 == 0)
         {
            Money prizeType = new Money();
            winMoney = prizeType.displayWinnings(player, corrGuess);
            player.setMoney(player.getMoney() + winMoney);
            System.out.println(player);   
         }
         else
         {
            Physical prizeType = new Physical();
            winMoney = prizeType.displayWinnings(player, corrGuess);
            player.setMoney(player.getMoney() + winMoney);
            System.out.println(player);
         }
         
         return corrGuess;
      }

}