//Jessie Baker, JES2371614
//CIS263AA, LESSON 3
// DATE: 03/03/26

import java.util.Random;

// Create Numbers class to hold random generated number.
public class Numbers
{
   private static int randomNum;
   
   // Method to set number.
   public void setNumber(int ranNum)
   {
      randomNum = ranNum;
   }
   
   // Method to get number.
   public int getRandomNum()
   {
      return randomNum;
   }
   
   // Method to generate random number 0 - 100.
   public void generateNumber()
   {
      Random randNum = new Random();
      randomNum = randNum.nextInt(101);
   }
   
   // Method to compare player guess to random number and see if it is correct, too high, or too low.
   public boolean compareNumber(int guess)
   {
      boolean playerGuess = false;
      
      if (randomNum == guess)
      {
         System.out.println("Congratulations, you guessed the number!");
         playerGuess = true;   
      }
      else if (guess > randomNum)
      {
         System.out.println("I'm sorry.  That guess was too high.");
         playerGuess = false;
      }
      else if (guess < randomNum)
      {
         System.out.println("I'm sorry, That guess was too low.");
         playerGuess = false;
      }
      return playerGuess;
   } 
}