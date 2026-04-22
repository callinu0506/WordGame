// Jessie Baker, JES2371614
// CIS263AA, LESSON 10
// DATE: 04/21/26

import javax.swing.JOptionPane;

// Class that implements award with display winnings method.
public class Money implements Award
{
   public int displayWinnings(Players currPlayer, boolean corrGuess)
   {
      int prize = 0;
      
      // Determines if correct or incorrect, displays message.
      // Returns positive number for correct, negative for incorrect.
      if (corrGuess)
         {
            GUI.updateGameMessages(currPlayer.getFirst().toString() + ", yes, letter is in the phrase!"
               + "\nYou won $1,000.00\n");
            prize = 1000;   
         }
         else
         {
            GUI.updateGameMessages(currPlayer.getFirst().toString() + ", sorry, letter is not in the phrase!"
               + "\nYou lost $200.00\n");
            prize = -200;
         }
      return prize;
   }
}
