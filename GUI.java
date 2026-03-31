// Jessie Baker, JES2371614
// CIS263AA, LESSON 7
// DATE: 03/30/26

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class GUI extends JFrame implements ActionListener
{
   // Create variables
   final int WIDTH = 800;
   final int HEIGHT = 800;
   private static Players[] currentPlayers = new Players[3];
   private static Hosts host = new Hosts("", "");
   private static Turn turn = new Turn();
   private int playerCount = 1;
   private static StringBuilder currPlayers = new StringBuilder();
   private static Phrases phrase = new Phrases();
   
   // Create labels
   JLabel playerNames = new JLabel("Player names:");
   JLabel playerList = new JLabel();
   JLabel currHostName = new JLabel();
   JLabel currPhraseDisplay = new JLabel();
   
   // Create buttons
   JButton addPlayer = new JButton("Add Player");
   JButton addHost = new JButton("Add Host");
   JButton gameStart = new JButton("Start Game");
   JButton newPhrase = new JButton("Set new phrase");
   JButton changeHost = new JButton("Change Host");
      
   
   public GUI()
   {
      // Create JFrame and add components
      super("Word Game");
      setSize(WIDTH, HEIGHT);
      setLayout(new FlowLayout());
      add(playerNames);
      add(playerList);
      add(addPlayer);
      add(currHostName);
      add(addHost);
      add(currPhraseDisplay);
      add(gameStart);
      add(changeHost);
      add(newPhrase);
      setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
      addPlayer.addActionListener(this);
      addHost.addActionListener(this);
      gameStart.addActionListener(this);
      newPhrase.addActionListener(this);
      changeHost.addActionListener(this);
   }
   // Override to listen for button clicks and send to correct method
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == addPlayer)
      {
         addPlayerButton();
      }
      else if(e.getSource() == addHost)
      {
         addHostButton();
      }
      else if(e.getSource() == gameStart)
      {
         if(addHost.isEnabled())
         {
            JOptionPane.showMessageDialog(null, "Cannot start game without a host."
               + "\nPlease add host.");
         }
         else if(playerCount == 1)
         {
            JOptionPane.showMessageDialog(null, "Cannot start game without players."
               + "\nPlease add players.");
         }
         else
         {
            gameStartButton();
         }
      }
      else if(e.getSource() == newPhrase)
      {
         newPhrase();
      }
      else if(e.getSource() == changeHost)
      {
         changeHost();
      }
   }
   public void addPlayerButton()
   {
      String firstName = JOptionPane.showInputDialog(null, "Player #" + (playerCount) + ", What is your first name?");
      
      String lastName = JOptionPane.showInputDialog(null, "Would you like to enter a last name? Leave blank if not.");
      
         if (lastName.isEmpty()) 
         {
            currentPlayers[playerCount - 1] = new Players(firstName);
         }
         else
         {
            currentPlayers[playerCount - 1] = new Players(firstName, lastName);
         }
         // Update label to show each player as they are added.
         updatePlayerList();
         ++playerCount;
         
         // Statement to limit players to 3
         if(playerCount == 4)
         {
            addPlayer.setText("Max 3 players");
            addPlayer.setEnabled(false);
         }
   }
   
   public void addHostButton()
   {
      changeHost();
      newPhrase();
      addHost.setEnabled(false);   
   }
   
   public void gameStartButton()
   {
      boolean corrGuess = false;
      while (!corrGuess) 
      {
         for (int j = 0; j < playerCount - 1; ++j)
         {
            corrGuess = turn.takeTurn(currentPlayers[j], host);
            updateCurrPhrase();
            if (corrGuess)
            {
               break;
            }
         }
      }
      corrGuess = false;
         
      JOptionPane.showMessageDialog(null, "You solved the puzzle and won the game!");
      int newGame = JOptionPane.showConfirmDialog(null, "Play another game? (yes or no)", "Play again?",
         JOptionPane.YES_NO_OPTION);
      
      if(newGame == JOptionPane.YES_OPTION)
      {
         JOptionPane.showMessageDialog(null, "Please set a new phrase.");
      }   
      else
      {
         System.exit(0);
      }
      
   }
   
   // Method uses stringbuilder to add players to the player list label.
   public void updatePlayerList()
   {
      currPlayers.append(currentPlayers[playerCount - 1].fullName());
      playerList.setText(currPlayers.toString());
   }
   
   public void updateCurrPhrase()
   {
      String currPhrase = phrase.getPhrase();
      currPhraseDisplay.setText(currPhrase);
   }
   
   public void newPhrase()
   {
      host.createPhrase();
      updateCurrPhrase();
   }
   
   public void changeHost()
   {
      String hostName;
      hostName = JOptionPane.showInputDialog(null, "Enter host's first and last name?");
      String first = "";
      String last = "";
      int i = 0;
      char c;
      while (i < hostName.length())
      {
         if(hostName.charAt(i) == ' ')
         {
            first = hostName.substring(0, i);
            last = hostName.substring(i + 1, hostName.length());
            i = hostName.length();
         }
         ++i;
      }
      host.setName(first, last);
      currHostName.setText(hostName.toString());
   }
}