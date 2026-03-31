// Jessie Baker, JES2371614
// CIS263AA, LESSON 7
// DATE: 03/30/26

import java.util.Random;
import javax.swing.JOptionPane;


// Class that implements award with display winnings method.
public class Physical implements Award
{
   // Array with physical prizes.
   private String[] physicalPrizes = {
      "Washer and Dryer", "Nintendo Switch", "Bluetooth Speaker",
      "Surfboard", "Ninja Airfryer"};
   
   public int displayWinnings(Players currPlayer, boolean corrGuess)
   {
      // Determines if correct or incorrect and displays prize.
      // Always returns 0;
      if (corrGuess)
         {
            JOptionPane.showMessageDialog(null, currPlayer.getFirst() + ", yes, that letter is in the phrase!"
               +  "\nYou won a " + physicalPrizes[getRandomPrize()] + "!");   
         }
         else
         {
            JOptionPane.showMessageDialog(null, currPlayer.getFirst() + ", sorry, that letter is not in the phrase!"
               + "\nIf you had gotten it correct, you COULD HAVE WON a"
               + "\n" + physicalPrizes[getRandomPrize()] + "!");
               
         }
      return 0;
      
   }
   
   // Method to generate a random number to use as index for prize selection.
   public int getRandomPrize()
   {
      Random randNum = new Random();
      return randNum.nextInt(physicalPrizes.length);
   }
}