// Jessie Baker, JES2371614
// CIS263AA, LESSON 4
// DATE: 03/10/26

// Class that implements award with display winnings method.
public class Money implements Award
{
   public int displayWinnings(Players currPlayer, boolean corrGuess)
   {
      int prize = 0;
      
      // Determines if correct or incorrect, displays message.
      // Returns positive number for correct, negative for incorrect.
      if (corrGuess)
         {
            System.out.print(currPlayer.getFirst() + ", that is correct! ");
            System.out.println("You won $1,000.00");
            prize = 1000;   
         }
         else
         {
            System.out.print(currPlayer.getFirst() + ", sorry, that is incorrect! ");
            System.out.println("You lost $200.00");
            prize = -200;
         }
      return prize;
   }
}
