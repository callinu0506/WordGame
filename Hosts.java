// Jessie Baker, JES2371614
// CIS263AA, LESSON 5
// DATE: 03/18/26

import java.util.Scanner;

// Create Hosts to extend person and get phrase.
public class Hosts extends Person
{
   private Phrases phrase;
   
   Hosts()
   {
      super();
   }
   
   Hosts(String firstName)
   {
      super(firstName);
   }
   
   Hosts(String firstName, String lastName)
   {
      super(firstName, lastName);
   }
   
    // Method to generate phrase.
   public void createPhrase()
   {
      phrase = new Phrases();
      String hostPhrase;
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter the phrase for players to guess:");
      hostPhrase = input.nextLine();
      phrase.setPlayingPhrase(hostPhrase);
   }
   
     
}