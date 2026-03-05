//Jessie Baker, JES2371614
//CIS263AA, LESSON 3
// DATE: 03/03/26

import java.util.Scanner;

public class GamePlay
{
   // Create static variables.
   private static Players player;
   private static Hosts host;
   private static Turn turn;
   
   public static void main(String[] args)
   {
      // Create variables.
      Scanner input = new Scanner(System.in);
      String firstName;
      String lastName;
      String newGame = "y";
      boolean corrGuess = false;
      host = new Hosts("Steve", "Harvey");
      turn = new Turn();
      
      // Obtain player name and set play first and last name.
      System.out.println("What is your first name?");
      firstName = input.nextLine();
      
      System.out.println("Would you like to enter a last name? Leave blank if not.");
      lastName = input.nextLine();
      
      if (lastName.isEmpty()) 
      {
         player = new Players(firstName);
      }
      else
      {
         player = new Players(firstName, lastName);
      }
      
      // Loop to control game play.
      // Will start game and give option to play again.
      do 
      {
         host.randomizeNum();
         
         do 
         {
            corrGuess = turn.takeTurn(player, host);
         } while (!corrGuess);
         
         System.out.println("Play another game? (y or no)");
         newGame = input.nextLine();
         
       } while (newGame.contains("y"));
       
   }   
     
}