// Jessie Baker, JES2371614
// CIS263AA, LESSON 8
// DATE: 04/04/26

import javax.swing.JOptionPane;

// Interface with abstract method to display winnings.

public interface Award
{
   public abstract int displayWinnings(Players currPlayer, boolean won);
}