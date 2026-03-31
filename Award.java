// Jessie Baker, JES2371614
// CIS263AA, LESSON 7
// DATE: 03/30/26

import javax.swing.JOptionPane;

// Interface with abstract method to display winnings.

public interface Award
{
   public abstract int displayWinnings(Players currPlayer, boolean won);
}