//Jessie Baker, JES2371614
//CIS263AA, LESSON 2
// DATE: 02/23/26

import java.util.Scanner;

public class GamePlay
{
   public static void main(String[] args)
   {
      // Create variables.
      Scanner input = new Scanner(System.in);
      String firstName;
      String lastName;
      int playerGuess;
      Numbers numGen = new Numbers();
      Person player = new Person();
      boolean corrGuess = false;
      
      // Obtain player name and set play first and last name.
      System.out.print("Enter player's first name: ");
      firstName = input.nextLine();
      
      System.out.print("Enter player's last name or leave blank and hit enter: ");
      lastName = input.nextLine();
      
      if (lastName.isEmpty()) 
      {
         player.setName(firstName);
      }
      else
      {
         player.setName(firstName, lastName);
      }
      
      // Generate random number for game.
      numGen.generateNumber();
      
      // Get player's initial guess.
      System.out.print(player.fullName() + " guess a number between 0 and 100: ");
         playerGuess = input.nextInt();
      
      // Loop to compare guess to random number until match found.
      while (!corrGuess)
      {
         corrGuess = numGen.compareNumber(playerGuess);
         if (!corrGuess)
         {
            System.out.print(player.fullName() + " try another guess: ");
            playerGuess = input.nextInt();
         }
      }
      
   }   
}