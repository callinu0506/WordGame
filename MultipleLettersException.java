// Jessie Baker, JES2371614
// CIS263AA, LESSON 5
// DATE: 03/18/26

// Extend exception class for errors when more than one letter entered.
public class MultipleLettersException extends Exception
{

   public MultipleLettersException()
   {
      super("More than one letter was entered.");
   }
   
   @Override
   public String getMessage()
   {
      return super.getMessage();
   }
}
