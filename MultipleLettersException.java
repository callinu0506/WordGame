// Jessie Baker, JES2371614
// CIS263AA, LESSON 10
// DATE: 04/21/26

import javax.swing.JOptionPane;

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
