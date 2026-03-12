// Jessie Baker, JES2371614
// CIS263AA, LESSON 4
// DATE: 03/10/26

import java.util.Random;


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
            System.out.print(currPlayer.getFirst() + ", that is correct! ");
            System.out.print("You won ");
            System.out.println("a " + physicalPrizes[getRandomPrize()] + "!");   
         }
         else
         {
            System.out.print(currPlayer.getFirst() + ", sorry, that is incorrect! ");
            System.out.print("If you had gotten it correct, you COULD HAVE WON ");
            System.out.println("a " + physicalPrizes[getRandomPrize()] + "!");
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