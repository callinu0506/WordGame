// Jessie Baker, JES2371614
// CIS263AA, LESSON 5
// DATE: 03/18/26

// Create Numbers class to hold phrase and throw an exception.
public class Phrases
{
   private static String gamePhrase;
   private static StringBuilder playingPhrase;
   
   // Method to set game phrase to _.
   public void setPlayingPhrase(String phrase)
   {
      gamePhrase = phrase.toUpperCase();
      playingPhrase = new StringBuilder();
      
      for (int i = 0; i < gamePhrase.length(); ++i)
      {
         char c = gamePhrase.charAt(i);
         
         if(!(Character.isLetter(c) || c == ' '))
         {
            System.out.println("Must enter letters or spaces.");
         }
         else
         {
            if(c == ' ')
            {
               playingPhrase.append(" ");
            }
            else
            {
               playingPhrase.append("_");
            }
         }
       } 
   }
   
   // Method to update playingPhrase if letter exists.
   public boolean findLetters(String guessedLetter) throws MultipleLettersException, Exception
   {
      boolean corrGuess = false;
      char letter = Character.toUpperCase(guessedLetter.charAt(0));
      char char2 = guessedLetter.charAt(0);
      
      // Check if more than one letter used or not a letter entered.
      // Throw exceptions for invalid entries.
      if (guessedLetter.length() != 1)
      {
         throw new MultipleLettersException();
      }
      if (!Character.isLetter(char2))
      {
         throw new Exception("Enter only letters.");
      }
      
      if(gamePhrase.indexOf(letter) == -1)
      {
         corrGuess = false;
      }
      else
      {
         corrGuess = true;
         for (int i = 0; i < gamePhrase.length(); ++i)
         {
            if(gamePhrase.charAt(i) == letter)
            {
               playingPhrase.setCharAt(i, letter);
            }
         }
      }
      
      return corrGuess;
   } 
   public void showPhrase()
   {
      System.out.println(playingPhrase);
   }
   
   // Method to see if all letters have been found.
   public boolean finalCheck()
   {
      boolean blankNotFound = false;
      if(playingPhrase.indexOf("_") == -1)
      {
         blankNotFound = true;
      }  
      return blankNotFound;
   }
}