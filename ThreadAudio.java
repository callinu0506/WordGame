// JES2371614 - Jessie Baker
// CIS263AA
// 04/21/2026

import java.lang.Runnable;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ThreadAudio implements Runnable
{
   @Override
   public void run()
   {
      try 
      {
         File introAudio = new File("intro.wav");
         AudioInputStream introStream = AudioSystem.getAudioInputStream(introAudio);
         
         Clip intro = AudioSystem.getClip();
         intro.open(introStream);
         intro.start();
         
      }
      catch (Exception e)
      {
         System.out.println("Invalid audio file.");
      }
   }
}