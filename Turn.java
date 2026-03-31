// Jessie Baker, JES2371614
// CIS263AA, LESSON 7
// DATE: 03/30/26

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;


// Class to handle player's turns.

public class Turn
{
   // Method to get player's guess, check if letters are in phrase,
   // update their money, and display winnings.
   public boolean takeTurn(Players player, Hosts host) 
   {
      
         String playerGuess;
         boolean corrGuess = false;
         boolean blankNotFound = false;
         Phrases gameLetter = new Phrases();
         int winMoney;
      
         gameLetter.showPhrase();
         
         // Get player's guess.
         playerGuess = JOptionPane.showInputDialog(null, host.fullName() + " says \""
            + player.fullName() + ", enter your guess for a letter in my phrase\"");
         
         // Check guess against host's phrase.
         // Throw exception for more than one letter or other character.
         try
         {
            corrGuess = gameLetter.findLetters(playerGuess);
         
            Random random = new Random();
         
            // Random number generated for prize choice.
            // Even calls Money and Odd calls Physical Prize.
            // Add or subtract based on if guess is correct or incorrect and award is Money.
            if (random.nextInt(101) % 2 == 0)
            {
               Money prizeType = new Money();
               winMoney = prizeType.displayWinnings(player, corrGuess);
               player.setMoney(player.getMoney() + winMoney);
               JOptionPane.showMessageDialog(null, player);   
            }
            else
            {
               Physical prizeType = new Physical();
               winMoney = prizeType.displayWinnings(player, corrGuess);
               player.setMoney(player.getMoney() + winMoney);
               JOptionPane.showMessageDialog(null, player);
            }
         }
         catch (MultipleLettersException mle)
         {
            System.out.println(mle.getMessage());
         }
         catch (Exception e)
         { 
            System.out.println(e.getMessage());
         }
         
         blankNotFound = gameLetter.finalCheck();
         return blankNotFound;
      }

}