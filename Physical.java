// Jessie Baker, JES2371614
// CIS263AA, LESSON 10
// DATE: 04/21/26

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


// Class that implements award with display winnings method.
public class Physical implements Award
{
   // Array with physical prizes.
   private String[] physicalPrizes = {
      "Washer and Dryer", "Nintendo Switch", "Bluetooth Speaker",
      "Surfboard", "Ninja Airfryer"};
   
   public int displayWinnings(Players currPlayer, boolean corrGuess)
   {
      // Add images for physical prizes
      ImageIcon washer = new ImageIcon("machine.jpg");
      ImageIcon ninSwitch = new ImageIcon("switch.jpg");
      ImageIcon speaker = new ImageIcon("speaker.jpg");
      ImageIcon surfboard = new ImageIcon("surfboard.jpg");
      ImageIcon airfryer = new ImageIcon("airfryer.jpg");
      
      // Determines if correct or incorrect and displays prize.
      // Always returns 0;
      int i = getRandomPrize();
      
      if (corrGuess)
      {
         GUI.updateGameMessages(currPlayer.getFirst().toString() + ", yes, that letter is in the phrase!"
            +  "\nYou won a " + physicalPrizes[i].toString() + "!\n");  
      }
      else
      {
         GUI.updateGameMessages(currPlayer.getFirst().toString() + ", sorry, that letter is not in the phrase!"
            + "\nIf you had gotten it correct, you COULD HAVE WON a"
            + "\n" + physicalPrizes[i].toString() + "!\n");       
      }
      if (i == 0)
      {
         JOptionPane.showMessageDialog(null, null, "Washer and Dryer", 
            JOptionPane.INFORMATION_MESSAGE, washer);
      } 
      else if (i == 1)
      {
         JOptionPane.showMessageDialog(null, null, "Nintendo Switch", 
            JOptionPane.INFORMATION_MESSAGE, ninSwitch);
      }
      else if (i == 2)
      {
         JOptionPane.showMessageDialog(null, null, "Bluetooth Speaker", 
            JOptionPane.INFORMATION_MESSAGE, speaker);
      }  
      else if (i == 3)
      {
         JOptionPane.showMessageDialog(null, null, "Surfboard", 
            JOptionPane.INFORMATION_MESSAGE, surfboard);
      }
      else if (i == 4)
      {
         JOptionPane.showMessageDialog(null, null, "Ninja Airfryer", 
            JOptionPane.INFORMATION_MESSAGE, airfryer);
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