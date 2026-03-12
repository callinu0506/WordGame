// Jessie Baker, JES2371614
// CIS263AA, LESSON 4
// DATE: 03/10/26

// Create Hosts to extend person and randomize number.
public class Hosts extends Person
{
   private Numbers genRandom;
   
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
   
    // Method to generate random number for game.
   public void randomizeNum()
   {
      genRandom = new Numbers();
      
      genRandom.generateNumber();
   }
   
   public void setRandomNum(int ranNum)
   {
      genRandom.setNumber(ranNum);
   }
   
   // Method to get number.
   public int getRandomNum()
   {
      return genRandom.getRandomNum();
   }   
}