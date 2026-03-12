// Jessie Baker, JES2371614
// CIS263AA, LESSON 4
// DATE: 03/10/26

import java.util.Scanner;

public class GamePlay
{
   // Create static variables.
   private static Players[] currentPlayers;
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
      currentPlayers = new Players[3];
      
      // Loop to obtain players names and set players first and last names.
      for (int i = 0; i < currentPlayers.length; ++i)
      {
         System.out.println("Player #" + (i + 1) + ", What is your first name?");
         firstName = input.nextLine();
      
         System.out.println("Would you like to enter a last name? Leave blank if not.");
         lastName = input.nextLine();
      
         if (lastName.isEmpty()) 
         {
            currentPlayers[i] = new Players(firstName);
         }
         else
         {
            currentPlayers[i] = new Players(firstName, lastName);
         }
      }
      
      // Loop to control game play.
      // Will start game and give option to play again.
      do 
      {
         host.randomizeNum();
         
         while (!corrGuess) 
         {
            for (int j = 0; j < currentPlayers.length; ++j)
            {
               corrGuess = turn.takeTurn(currentPlayers[j], host);
               if (corrGuess)
               {
                  break;
               }
            }
         }
         corrGuess = false;
         
         System.out.println("Play another game? (y or no)");
         newGame = input.nextLine();
         
       } while (newGame.contains("y"));
       
   }   
     
}