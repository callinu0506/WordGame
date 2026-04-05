// Jessie Baker, JES2371614
// CIS263AA, LESSON 8
// DATE: 04/04/26

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.TextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


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
   
   // Create Panels
   JPanel container = new JPanel();
   JPanel panel1 = new JPanel(new GridBagLayout());
   JPanel panel2 = new JPanel(new GridBagLayout());
   JPanel panel3 = new JPanel(new GridBagLayout());
   GridBagConstraints gbc = new GridBagConstraints();
   
   // Create labels
   JLabel playerNames = new JLabel("Player names:");
   JLabel playerList = new JLabel();
   JLabel currHostName = new JLabel();
   JLabel currPhraseDisplay = new JLabel();
   JLabel phraseToGuess = new JLabel("Phrase to Guess:");
   JLabel hostName = new JLabel("Host name: ");
   
   // Create buttons
   JButton addPlayer = new JButton("Add Player");
   JButton addHost = new JButton("Add Host");
   JButton gameStart = new JButton("Start Game");
   JButton newPhrase = new JButton("Set new phrase");
   JButton changeHost = new JButton("Change Host");
      
   // Add menu
   JMenuBar menuBar = new JMenuBar();
   JMenu gameMenu = new JMenu("Game");
   JMenu aboutMenu = new JMenu("About");
   JMenuItem playerMenu = new JMenuItem("Add Player");
   JMenuItem hostMenu = new JMenuItem("Add Host");
   JMenuItem changeHostMenu = new JMenuItem("Change Host");
   JMenuItem layoutMenu = new JMenuItem("Layout");
   
   // Add text box
   private static JTextArea gameMessages = new JTextArea(15, 45);
   JScrollPane scrollText = new JScrollPane(gameMessages);
   
   // Add Checkbox
   private static JCheckBox saveMessagesCheck = new JCheckBox("Save Messages");
   
   public GUI()
   {
      // Create JFrame and add components
      super("Word Game");
      setSize(WIDTH, HEIGHT);
      setLayout(new FlowLayout());
      container.setLayout(new GridLayout(0,1));
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(1, 4, 1, 4);
      gbc.weightx = 0.5;
      gbc.weighty = 0.5;
      gameMenu.add(playerMenu);
      gameMenu.add(hostMenu);
      gameMenu.add(changeHostMenu);
      aboutMenu.add(layoutMenu);
      menuBar.add(gameMenu);
      menuBar.add(aboutMenu);
      setJMenuBar(menuBar);
      gameMenu.setMnemonic(KeyEvent.VK_G);
      aboutMenu.setMnemonic(KeyEvent.VK_A);
      
      // Add items to panels in layout
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel1.add(hostName, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      panel1.add(currHostName);
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel1.add(playerNames, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      panel1.add(playerList, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      panel1.add(phraseToGuess, gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      panel1.add(currPhraseDisplay, gbc);
      currPhraseDisplay.setFont(new Font("Consolas", Font.PLAIN, 24));
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel2.add(saveMessagesCheck, gbc);
      saveMessagesCheck.setSelected(true);
      saveMessagesCheck.setToolTipText("Unchecking this box will show only the current message.\n"
         + "Leave checked to save messages.");
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel2.add(scrollText, gbc);
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel3.add(gameStart, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      panel3.add(newPhrase, gbc);
      container.add(panel1);
      container.add(panel2);
      container.add(panel3);
      add(container, BorderLayout.NORTH);
      setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
      
      // Add Action Listeners
      gameStart.addActionListener(this);
      newPhrase.addActionListener(this);
      playerMenu.addActionListener(this);
      hostMenu.addActionListener(this);
      changeHostMenu.addActionListener(this);
      layoutMenu.addActionListener(this);
      
      // Setup the text box so it wraps and has a starting message.
      gameMessages.setEditable(false);
      gameMessages.setLineWrap(true);
      gameMessages.setWrapStyleWord(true);
      gameMessages.setText("Game Messages will appear here.\n"
         + "Before you can start:\n"
         + "1. Add a host and set the game phrase\n"
         + "2. Add up to three players\n");
      
   
   }
   // Override to listen for button clicks and send to correct method
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == playerMenu)
      {
         addPlayerButton();
      }
      else if(e.getSource() == hostMenu)
      {
         addHostButton();
      }
      else if(e.getSource() == gameStart)
      {
         if(hostMenu.isEnabled())
         {
            updateGameMessages("Cannot start game without a host."
               + "\nPlease add host.\n");
         }
         else if(playerCount == 1)
         {
            updateGameMessages("Cannot start game without players."
               + "\nPlease add players.\n");
         }
         else
         {
            gameStartButton();
         }
      }
      else if(e.getSource() == layoutMenu)
      {
         JOptionPane.showMessageDialog(null, "This is why I chose this layout:\n"
          + "I wanted to keep the game play simple to allow for any changes\n"
          + "that may be added on the next project.\n"
          + "The game information for host and players is at the top with\n"
          + "the message box in the middle and buttons on the bottom.\n");
      }
      else if(e.getSource() == newPhrase)
      {
         newPhrase();
      }
      else if(e.getSource() == changeHostMenu)
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
         updateGameMessages("Player added: " + currentPlayers[playerCount - 1].fullName().toString() + "\n");
         ++playerCount;
         
         // Statement to limit players to 3
         if(playerCount == 4)
         {
            playerMenu.setText("Max 3 players");
            playerMenu.setEnabled(false);
         }
   }
   
   public void addHostButton()
   {
      changeHost();
      newPhrase();
      hostMenu.setEnabled(false);   
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
         
      updateGameMessages("You solved the puzzle and won the game!\n");
      int newGame = JOptionPane.showConfirmDialog(null, "Play another game? (yes or no)", "Play again?",
         JOptionPane.YES_NO_OPTION);
      
      if(newGame == JOptionPane.YES_OPTION)
      {
         gameMessages.setText("");
         updateGameMessages("Please set a new phrase.\n");
      }   
      else
      {
         System.exit(0);
      }
      
   }
   
   // Method uses stringbuilder to add players to the player list label.
   public void updatePlayerList()
   {
      currPlayers.append(currentPlayers[playerCount - 1].fullName() + " ");
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
      updateGameMessages("Host added: " + hostName.toString() + "\n");
   }
   public static void updateGameMessages(String message)
   {
      // Check to see if saved messages box is checked.
      if(saveMessagesCheck.isSelected())
      {
         gameMessages.append(message);
      }
      else if(!saveMessagesCheck.isSelected())
      {
         gameMessages.setText("");
         gameMessages.append(message);
      }
   }
}