// Jessie Baker, JES2371614
// CIS263AA, LESSON 8
// DATE: 04/04/26

import java.util.Scanner;
import javax.swing.JOptionPane;

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
      hostPhrase = JOptionPane.showInputDialog(null, "Enter the phrase for the players to guess:");
      phrase.setPlayingPhrase(hostPhrase);
   }
   
     
}