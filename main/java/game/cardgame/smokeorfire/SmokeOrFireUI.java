/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cardgame.smokeorfire;


import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



/**
 *
 * @author Antho
 */
public class SmokeOrFireUI extends javax.swing.JFrame {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private final int[] PlAYER_NUMBER = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int HANDSIZE = 4;
    private final static String newline = "\n";
    private int playerCountMenu;
    private int countTracker;
    private int inRowPosition =0;
    private int pileType;
    private SmokeOrFire game;
    private ArrayList<String> playerNamesList;   
    private ArrayList<JLabel> labelsList;
    private ArrayList<JLabel> handLabels;
    private ArrayList<JLabel> playerNameLabels;
    private ArrayList<JLabel> giveRoundLabels;
    private ArrayList<JLabel> takeRoundLabels;
    private ArrayList<JLabel> shareRoundLabels;
    private ArrayList<ArrayList<JLabel>> playerHandsLabelsList;
    private ArrayList<JLabel> player1Hand;
    private ArrayList<JLabel> player2Hand;
    private ArrayList<JLabel> player3Hand;
    private ArrayList<JLabel> player4Hand;
    private ArrayList<JLabel> player5Hand;
    private ArrayList<JLabel> player6Hand;
    private ArrayList<JLabel> player7Hand;
    private ArrayList<JLabel> player8Hand;
    private ArrayList<JLabel> player9Hand;
    private ArrayList<JLabel> player10Hand;

    
    
    /**
     * Creates new form SmokeOrFireUI
     */
    
    public SmokeOrFireUI() {
        initComponents();
        this.playerCountMenu = 0;
        /*
        this.countTracker = 1;
        this.playerNamesList = new ArrayList<>();
        this.labelsList = new ArrayList<>();
        this.playerHandsLabelsList = new ArrayList<>();
        this.playerNameLabels = new ArrayList<>();
        this.handLabels = new ArrayList<>();
        this.giveRoundLabels = new ArrayList<>();
        this.takeRoundLabels = new ArrayList<>();
        this.shareRoundLabels = new ArrayList<>();
        this.pileType = 0;
        playerIDLabelArrayBuilder(); */
        playButton.setVisible(false);
        AddPlayerPanel.setVisible(false);
        gamePanel.setVisible(false);

    }
    
    public String[] getPlayerNames(){
        String[] array = playerNamesList.toArray(new String[playerNamesList.size()]);
        return array;
    }
    
    
    // helper method for next world
    public void nextRound(){
        if(game.getGameRound() == 1){ // smoke or fire
            
            roundTextArea.setText(game.askQuestion1(game.getCurrentPlayer()));
            // make buttons visible
            actionButton1.setVisible(true); actionButton3.setVisible(true);
            //hide end turn button 
            endTurnButton.setVisible(false);
            
        } else if (game.getGameRound() == 2){ // higher or lower
            
            roundTextArea.setText(game.askQuestion1(game.getCurrentPlayer()));
            //sets button to next round Higher or Lower
            actionButton1.setText("Higher"); actionButton3.setText("Lower");
            // make buttons visible
            actionButton1.setVisible(true); actionButton3.setVisible(true);
            //hide end turn button 
            endTurnButton.setVisible(false);
            
        } else if (game.getGameRound() == 3){ // in or out
            
            roundTextArea.setText(game.askQuestion1(game.getCurrentPlayer()));
            
            actionButton1.setText("In"); actionButton3.setText("Out");
            // make buttons visible
            actionButton1.setVisible(true); actionButton3.setVisible(true);
            //hide end turn button 
            endTurnButton.setVisible(false); 
            
        } else if (game.getGameRound() == 4){ // Guess Suit
            
            roundTextArea.setText(game.askQuestion1(game.getCurrentPlayer()));
            
            actionButton1.setText("Clubs"); actionButton2.setText("Diamonds");
            actionButton3.setText("Hearts"); actionButton4.setText("Spades");
            // make buttons visible
            actionButton1.setVisible(true); actionButton2.setVisible(true);
            actionButton3.setVisible(true); actionButton4.setVisible(true);
            //hide end turn button 
            endTurnButton.setVisible(false); 
                        
        } else {
            roundTextArea.setText(game.finalString());
            actionButton4.setText("Flip Card");
            actionButton2.setText("Draw Card");
            actionButton4.setVisible(true);
            endTurnButton.setVisible(false);
        }
    }
    
    
    private void handImage(int currentPlayer, int round){
        // basic code setup (Round - 1) to give the index 0
        int position = round - 1;
        playerHandsLabelsList.get(currentPlayer).get(position).setIcon(game.getPlayer(currentPlayer).getCard(position).getCardImage());     
        
    }
    
    private void playerIDLabelArrayBuilder(){
        labelsList.add(playerID1Label);
        labelsList.add(playerID2Label);
        labelsList.add(playerID3Label);
        labelsList.add(playerID4Label);
        labelsList.add(playerID5Label);
        labelsList.add(playerID6Label);
        labelsList.add(playerID7Label);
        labelsList.add(playerID8Label);
        labelsList.add(playerID9Label);
        labelsList.add(playerID10Label);
    }
    
    private void playerNameLabelArrayBuilder(){
        playerNameLabels.add(player1NameLabel);
        playerNameLabels.add(player2NameLabel);
        playerNameLabels.add(player3NameLabel);
        playerNameLabels.add(player4NameLabel);
        playerNameLabels.add(player5NameLabel);
        playerNameLabels.add(player6NameLabel);
        playerNameLabels.add(player7NameLabel);
        playerNameLabels.add(player8NameLabel);
        playerNameLabels.add(player9NameLabel);
        playerNameLabels.add(player10NameLabel);
        
        
    }
 
    public int getInRowPosition(){
        return this.inRowPosition;
    }
    private void HandLabelsBuilder(){
        this.handLabels.add(player1Card1Label); // index 0
        this.handLabels.add(player1Card2Label); // index 1
        this.handLabels.add(player1Card3Label); // index 2
        this.handLabels.add(player1Card4Label); // index 3
        this.handLabels.add(player2Card1Label); // index 4        
        this.handLabels.add(player2Card2Label); // index 5                   
        this.handLabels.add(player2Card3Label); // index 6         
        this.handLabels.add(player2Card4Label); // index 7
        this.handLabels.add(player3Card1Label); // index 8
        this.handLabels.add(player3Card2Label); // index 9
        this.handLabels.add(player3Card3Label); // index 10
        this.handLabels.add(player3Card4Label); // index 11
        this.handLabels.add(player4Card1Label); // index 12        
        this.handLabels.add(player4Card2Label); // index 13                   
        this.handLabels.add(player4Card3Label); // index 14         
        this.handLabels.add(player4Card4Label); // index 15
        this.handLabels.add(player5Card1Label); // index 16
        this.handLabels.add(player5Card2Label); // index 17
        this.handLabels.add(player5Card3Label); // index 18
        this.handLabels.add(player5Card4Label); // index 19
        this.handLabels.add(player6Card1Label); // index 20        
        this.handLabels.add(player6Card2Label); // index 21                   
        this.handLabels.add(player6Card3Label); // index 22         
        this.handLabels.add(player6Card4Label); // index 23
        this.handLabels.add(player7Card1Label); // index 24
        this.handLabels.add(player7Card2Label); // index 25
        this.handLabels.add(player7Card3Label); // index 26
        this.handLabels.add(player7Card4Label); // index 27
        this.handLabels.add(player8Card1Label); // index 28        
        this.handLabels.add(player8Card2Label); // index 29                   
        this.handLabels.add(player8Card3Label); // index 30         
        this.handLabels.add(player8Card4Label); // index 31
        this.handLabels.add(player9Card1Label); // index 32
        this.handLabels.add(player9Card2Label); // index 33
        this.handLabels.add(player9Card3Label); // index 34
        this.handLabels.add(player9Card4Label); // index 35
        this.handLabels.add(player10Card1Label); // index 36        
        this.handLabels.add(player10Card2Label); // index 37                   
        this.handLabels.add(player10Card3Label); // index 38         
        this.handLabels.add(player10Card4Label); // index 39
       
    }
    
    private void giveRoundLabelsBuilder(){
        this.giveRoundLabels.add(giveOneLabel);
        this.giveRoundLabels.add(giveTwoLabel);
        this.giveRoundLabels.add(giveThreeLabel);
    }
    private void takeRoundLabelsBuilder(){
        this.takeRoundLabels.add(takeOneLabel); // index 0
        this.takeRoundLabels.add(takeTwoLabel); // index 1
        this.takeRoundLabels.add(takeThreeLabel); // index 2
        this.takeRoundLabels.add(fuckYouLabel); // index 3
   
    }    
    private void shareRoundLabelsBuilder(){

        this.shareRoundLabels.add(shareOneLabel);
        this.shareRoundLabels.add(shareTwoLabel);
        this.shareRoundLabels.add(shareThreeLabel);       
    }
    
    public void setLastRoundIcon(){       
        switch (pileType){
            case 0:
                giveRoundLabels.get(inRowPosition).setIcon(game.getCardDrawn());
                break;
            case 1:
                takeRoundLabels.get(inRowPosition).setIcon(game.getCardDrawn());
                break;
            case 2:
                shareRoundLabels.get(inRowPosition).setIcon(game.getCardDrawn());
                break;
            case 3:
                takeRoundLabels.get(3).setIcon(game.getCardDrawn());
                break;
            }       
    }
    
    private void handLabelArrayBuilder(int playerCount){               
          
        this.player1Hand = new ArrayList<>();
        this.player2Hand = new ArrayList<>();
        switch(playerCount){
            case 3:
                this.player3Hand = new ArrayList<>();
                break;
            case 4:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                break;
            case 5:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                this.player5Hand = new ArrayList<>();
                break;
            case 6:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                this.player5Hand = new ArrayList<>();
                this.player6Hand = new ArrayList<>();
                break;            
            case 7:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                this.player5Hand = new ArrayList<>();
                this.player6Hand = new ArrayList<>();
                this.player7Hand = new ArrayList<>();
                break;                    
            case 8:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                this.player5Hand = new ArrayList<>();
                this.player6Hand = new ArrayList<>();
                this.player7Hand = new ArrayList<>();
                this.player8Hand = new ArrayList<>();
                break;                  
            case 9:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                this.player5Hand = new ArrayList<>();
                this.player6Hand = new ArrayList<>();
                this.player7Hand = new ArrayList<>();
                this.player8Hand = new ArrayList<>();
                this.player9Hand = new ArrayList<>();
                break;                   
            case 10:
                this.player3Hand = new ArrayList<>();
                this.player4Hand = new ArrayList<>();
                this.player5Hand = new ArrayList<>();
                this.player6Hand = new ArrayList<>();
                this.player7Hand = new ArrayList<>();
                this.player8Hand = new ArrayList<>();
                this.player9Hand = new ArrayList<>();
                this.player10Hand = new ArrayList<>();
                break;   
        }        
        for(int i = 0; i < HANDSIZE; i++){
            this.player1Hand.add(handLabels.get(i));
            this.player2Hand.add(handLabels.get(4 + i));
            switch(playerCount){
                case 3:
                    this.player3Hand.add(handLabels.get(8 + i));
                    break;
                case 4:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));                    
                    break;
                case 5:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));
                    this.player5Hand.add(handLabels.get(16 + i));                    
                    break;
                case 6:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));
                    this.player5Hand.add(handLabels.get(16 + i));
                    this.player6Hand.add(handLabels.get(20 + i));
                    break;            
                case 7:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));
                    this.player5Hand.add(handLabels.get(16 + i));
                    this.player6Hand.add(handLabels.get(20 + i));
                    this.player7Hand.add(handLabels.get(24 + i));
                    break;                    
                case 8:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));
                    this.player5Hand.add(handLabels.get(16 + i));
                    this.player6Hand.add(handLabels.get(20 + i));
                    this.player7Hand.add(handLabels.get(24 + i));
                    this.player8Hand.add(handLabels.get(28 + i));
                    break;                  
                case 9:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));
                    this.player5Hand.add(handLabels.get(16 + i));
                    this.player6Hand.add(handLabels.get(20 + i));
                    this.player7Hand.add(handLabels.get(24 + i));
                    this.player8Hand.add(handLabels.get(28 + i));
                    this.player9Hand.add(handLabels.get(32 + i));
                    break;                   
                case 10:
                    this.player3Hand.add(handLabels.get(8 + i));
                    this.player4Hand.add(handLabels.get(12 + i));
                    this.player5Hand.add(handLabels.get(16 + i));
                    this.player6Hand.add(handLabels.get(20 + i));
                    this.player7Hand.add(handLabels.get(24 + i));
                    this.player8Hand.add(handLabels.get(28 + i));
                    this.player9Hand.add(handLabels.get(32 + i));
                    this.player10Hand.add(handLabels.get(36 + i));                     
                    break;   
            }                        
        }
        
        playerHandsLabelsList.add(player1Hand); // index 0
        playerHandsLabelsList.add(player2Hand); // index 1
        switch(playerCount){
            case 3:
                playerHandsLabelsList.add(player3Hand);
                break;
            case 4:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand);
                break;
            case 5:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand); 
                playerHandsLabelsList.add(player5Hand); 
                break;
            case 6:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand); 
                playerHandsLabelsList.add(player5Hand); 
                playerHandsLabelsList.add(player6Hand);
                break;            
            case 7:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand); 
                playerHandsLabelsList.add(player5Hand); 
                playerHandsLabelsList.add(player6Hand); 
                playerHandsLabelsList.add(player7Hand); 
                break;                    
            case 8:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand); 
                playerHandsLabelsList.add(player5Hand); 
                playerHandsLabelsList.add(player6Hand); 
                playerHandsLabelsList.add(player7Hand); 
                playerHandsLabelsList.add(player8Hand);
                break;                  
            case 9:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand); 
                playerHandsLabelsList.add(player5Hand); 
                playerHandsLabelsList.add(player6Hand); 
                playerHandsLabelsList.add(player7Hand); 
                playerHandsLabelsList.add(player8Hand); 
                playerHandsLabelsList.add(player9Hand); 
                break;                   
            case 10:
                playerHandsLabelsList.add(player3Hand); 
                playerHandsLabelsList.add(player4Hand); 
                playerHandsLabelsList.add(player5Hand); 
                playerHandsLabelsList.add(player6Hand); 
                playerHandsLabelsList.add(player7Hand); 
                playerHandsLabelsList.add(player8Hand); 
                playerHandsLabelsList.add(player9Hand); 
                playerHandsLabelsList.add(player10Hand); 
                break;   
        }         

                  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        gameTitleLabel = new javax.swing.JLabel();
        playerNumSelectComboBox1 = new javax.swing.JComboBox<>();
        playButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        menuBackgroundLabel = new javax.swing.JLabel();
        AddPlayerPanel = new javax.swing.JPanel();
        playerAddLabel = new javax.swing.JLabel();
        nameOfThePlayerLabel = new javax.swing.JLabel();
        playerNameTextField = new javax.swing.JTextField();
        playerID1Label = new javax.swing.JLabel();
        playerID2Label = new javax.swing.JLabel();
        playerID3Label = new javax.swing.JLabel();
        playerID4Label = new javax.swing.JLabel();
        playerID5Label = new javax.swing.JLabel();
        playerID6Label = new javax.swing.JLabel();
        playerID7Label = new javax.swing.JLabel();
        playerID8Label = new javax.swing.JLabel();
        playerID9Label = new javax.swing.JLabel();
        playerID10Label = new javax.swing.JLabel();
        readyButton = new javax.swing.JButton();
        errorLabel1 = new javax.swing.JLabel();
        ReturnButton = new javax.swing.JButton();
        addPlayerBackground = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        gamePanelTitleLabel = new javax.swing.JLabel();
        player1NameLabel = new javax.swing.JLabel();
        player2NameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roundScrollPane1 = new javax.swing.JScrollPane();
        roundTextArea = new javax.swing.JTextArea();
        actionButton1 = new javax.swing.JButton();
        actionButton2 = new javax.swing.JButton();
        actionButton3 = new javax.swing.JButton();
        actionButton4 = new javax.swing.JButton();
        exit2Button = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        endTurnButton = new javax.swing.JButton();
        player1Card3Label = new javax.swing.JLabel();
        player1Card2Label = new javax.swing.JLabel();
        player1Card1Label = new javax.swing.JLabel();
        player1Card4Label = new javax.swing.JLabel();
        player2Card4Label = new javax.swing.JLabel();
        player2Card2Label = new javax.swing.JLabel();
        player2Card1Label = new javax.swing.JLabel();
        player2Card3Label = new javax.swing.JLabel();
        takeTwoLabel = new javax.swing.JLabel();
        takeOneLabel = new javax.swing.JLabel();
        takeThreeLabel = new javax.swing.JLabel();
        giveOneLabel = new javax.swing.JLabel();
        shareOneLabel = new javax.swing.JLabel();
        giveTwoLabel = new javax.swing.JLabel();
        shareTwoLabel = new javax.swing.JLabel();
        giveThreeLabel = new javax.swing.JLabel();
        shareThreeLabel = new javax.swing.JLabel();
        fuckYouLabel = new javax.swing.JLabel();
        player3NameLabel = new javax.swing.JLabel();
        player3Card4Label = new javax.swing.JLabel();
        player3Card2Label = new javax.swing.JLabel();
        player3Card1Label = new javax.swing.JLabel();
        player3Card3Label = new javax.swing.JLabel();
        player4NameLabel = new javax.swing.JLabel();
        player4Card4Label = new javax.swing.JLabel();
        player4Card2Label = new javax.swing.JLabel();
        player4Card1Label = new javax.swing.JLabel();
        player4Card3Label = new javax.swing.JLabel();
        player5NameLabel = new javax.swing.JLabel();
        player5Card4Label = new javax.swing.JLabel();
        player5Card2Label = new javax.swing.JLabel();
        player5Card1Label = new javax.swing.JLabel();
        player5Card3Label = new javax.swing.JLabel();
        player6NameLabel = new javax.swing.JLabel();
        player6Card4Label = new javax.swing.JLabel();
        player6Card2Label = new javax.swing.JLabel();
        player6Card1Label = new javax.swing.JLabel();
        player6Card3Label = new javax.swing.JLabel();
        player7NameLabel = new javax.swing.JLabel();
        player7Card4Label = new javax.swing.JLabel();
        player7Card2Label = new javax.swing.JLabel();
        player7Card1Label = new javax.swing.JLabel();
        player7Card3Label = new javax.swing.JLabel();
        player8NameLabel = new javax.swing.JLabel();
        player8Card4Label = new javax.swing.JLabel();
        player8Card2Label = new javax.swing.JLabel();
        player8Card1Label = new javax.swing.JLabel();
        player8Card3Label = new javax.swing.JLabel();
        player9NameLabel = new javax.swing.JLabel();
        player9Card4Label = new javax.swing.JLabel();
        player9Card2Label = new javax.swing.JLabel();
        player9Card1Label = new javax.swing.JLabel();
        player9Card3Label = new javax.swing.JLabel();
        player10NameLabel = new javax.swing.JLabel();
        player10Card4Label = new javax.swing.JLabel();
        player10Card2Label = new javax.swing.JLabel();
        player10Card1Label = new javax.swing.JLabel();
        player10Card3Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        chatTextField = new javax.swing.JTextField();
        chatLabel = new javax.swing.JLabel();
        replayButton = new javax.swing.JButton();
        backToMenuButton = new javax.swing.JButton();
        playerPanelBackGroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        menuPanel.setMaximumSize(new java.awt.Dimension(1000, 9000));
        menuPanel.setMinimumSize(new java.awt.Dimension(2100, 915));
        menuPanel.setPreferredSize(new java.awt.Dimension(2100, 1000));

        gameTitleLabel.setFont(new java.awt.Font("Old English Text MT", 1, 64)); // NOI18N
        gameTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        gameTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameTitleLabel.setText("Smoke & Fire: The Drinking Card Game");

        playerNumSelectComboBox1.setBackground(new java.awt.Color(155, 12, 12));
        playerNumSelectComboBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        playerNumSelectComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Player Count", "2 Players", "3 Players", "4 Players", "5 Players", "6 Players", "7 Players", "8 Players", "9 Players", "10 Players" }));
        playerNumSelectComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNumSelectComboBox1ActionPerformed(evt);
            }
        });

        playButton.setBackground(new java.awt.Color(155, 12, 12));
        playButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(155, 12, 12));
        exitButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setToolTipText("");
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        menuBackgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background3.PNG"))); // NOI18N

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(gameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(820, 820, 820)
                .addComponent(playerNumSelectComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(820, 820, 820)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(820, 820, 820)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(menuBackgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 2100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(gameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230)
                .addComponent(playerNumSelectComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(playButton)
                .addGap(27, 27, 27)
                .addComponent(exitButton))
            .addComponent(menuBackgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        AddPlayerPanel.setMinimumSize(new java.awt.Dimension(2100, 915));
        AddPlayerPanel.setPreferredSize(new java.awt.Dimension(2100, 1000));
        AddPlayerPanel.setLayout(null);

        playerAddLabel.setFont(new java.awt.Font("Engravers MT", 0, 48)); // NOI18N
        playerAddLabel.setForeground(new java.awt.Color(255, 255, 255));
        playerAddLabel.setText("Add The Names of the Players");
        AddPlayerPanel.add(playerAddLabel);
        playerAddLabel.setBounds(27, 11, 1133, 89);

        nameOfThePlayerLabel.setFont(new java.awt.Font("Engravers MT", 0, 24)); // NOI18N
        nameOfThePlayerLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameOfThePlayerLabel.setText("Name of the Player:");
        AddPlayerPanel.add(nameOfThePlayerLabel);
        nameOfThePlayerLabel.setBounds(50, 180, 370, 60);

        playerNameTextField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        playerNameTextField.setToolTipText("");
        playerNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playerNameTextFieldKeyPressed(evt);
            }
        });
        AddPlayerPanel.add(playerNameTextField);
        playerNameTextField.setBounds(420, 190, 630, 40);

        playerID1Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID1Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID1Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID1Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID1Label);
        playerID1Label.setBounds(1180, 220, 400, 60);

        playerID2Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID2Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID2Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID2Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID2Label);
        playerID2Label.setBounds(1180, 310, 400, 60);

        playerID3Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID3Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID3Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID3Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID3Label);
        playerID3Label.setBounds(1180, 400, 400, 60);

        playerID4Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID4Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID4Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID4Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID4Label);
        playerID4Label.setBounds(1180, 500, 400, 60);

        playerID5Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID5Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID5Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID5Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID5Label);
        playerID5Label.setBounds(1180, 590, 400, 60);

        playerID6Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID6Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID6Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID6Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID6Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID6Label);
        playerID6Label.setBounds(1620, 220, 400, 60);

        playerID7Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID7Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID7Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID7Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID7Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID7Label);
        playerID7Label.setBounds(1620, 310, 400, 60);

        playerID8Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID8Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID8Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID8Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID8Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID8Label);
        playerID8Label.setBounds(1620, 400, 400, 60);

        playerID9Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID9Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID9Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID9Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID9Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID9Label);
        playerID9Label.setBounds(1620, 500, 400, 60);

        playerID10Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        playerID10Label.setForeground(new java.awt.Color(255, 255, 255));
        playerID10Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID10Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerID10Label.setPreferredSize(new java.awt.Dimension(400, 60));
        AddPlayerPanel.add(playerID10Label);
        playerID10Label.setBounds(1620, 590, 400, 60);

        readyButton.setBackground(new java.awt.Color(155, 12, 12));
        readyButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        readyButton.setText("Ready");
        readyButton.setPreferredSize(new java.awt.Dimension(150, 60));
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButtonActionPerformed(evt);
            }
        });
        AddPlayerPanel.add(readyButton);
        readyButton.setBounds(1790, 900, 270, 50);

        errorLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AddPlayerPanel.add(errorLabel1);
        errorLabel1.setBounds(420, 150, 630, 40);

        ReturnButton.setBackground(new java.awt.Color(155, 12, 12));
        ReturnButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        ReturnButton.setText("Return");
        ReturnButton.setPreferredSize(new java.awt.Dimension(150, 60));
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });
        AddPlayerPanel.add(ReturnButton);
        ReturnButton.setBounds(50, 900, 270, 50);

        addPlayerBackground.setForeground(new java.awt.Color(255, 255, 255));
        addPlayerBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backgroud2.PNG"))); // NOI18N
        AddPlayerPanel.add(addPlayerBackground);
        addPlayerBackground.setBounds(0, 0, 2396, 1202);

        gamePanel.setFocusable(false);
        gamePanel.setMinimumSize(new java.awt.Dimension(2100, 915));
        gamePanel.setPreferredSize(new java.awt.Dimension(2100, 1000));
        gamePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gamePanelTitleLabel.setFont(new java.awt.Font("Engravers MT", 0, 36)); // NOI18N
        gamePanelTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        gamePanelTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamePanelTitleLabel.setText("Smoke Or Fire");
        gamePanel.add(gamePanelTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 430, 44));

        player1NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player1NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player1NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1NameLabel.setText("Player 1");
        player1NameLabel.setToolTipText("");
        player1NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player1NameLabel.setOpaque(true);
        gamePanel.add(player1NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 200, 50));

        player2NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player2NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player2NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2NameLabel.setText("Player 2");
        player2NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player2NameLabel.setOpaque(true);
        gamePanel.add(player2NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 200, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Give");
        gamePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 720, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Take");
        gamePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 720, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Share");
        gamePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 720, 100, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fuck You");
        gamePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 100, -1));

        roundTextArea.setEditable(false);
        roundTextArea.setColumns(20);
        roundTextArea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        roundTextArea.setLineWrap(true);
        roundTextArea.setRows(5);
        roundTextArea.setWrapStyleWord(true);
        roundTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        roundScrollPane1.setViewportView(roundTextArea);

        gamePanel.add(roundScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 320, 300));

        actionButton1.setBackground(new java.awt.Color(155, 12, 12));
        actionButton1.setToolTipText("");
        actionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton1ActionPerformed(evt);
            }
        });
        gamePanel.add(actionButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 800, 100, 50));

        actionButton2.setBackground(new java.awt.Color(155, 12, 12));
        actionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton2ActionPerformed(evt);
            }
        });
        gamePanel.add(actionButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 800, 100, 50));

        actionButton3.setBackground(new java.awt.Color(155, 12, 12));
        actionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton3ActionPerformed(evt);
            }
        });
        gamePanel.add(actionButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 800, 100, 50));

        actionButton4.setBackground(new java.awt.Color(155, 12, 12));
        actionButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton4ActionPerformed(evt);
            }
        });
        gamePanel.add(actionButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 740, 100, 50));

        exit2Button.setText("Exit");
        exit2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2ButtonActionPerformed(evt);
            }
        });
        gamePanel.add(exit2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(2011, 10, 70, -1));

        startButton.setBackground(new java.awt.Color(155, 12, 12));
        startButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        gamePanel.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 90, -1));

        endTurnButton.setBackground(new java.awt.Color(155, 12, 12));
        endTurnButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        endTurnButton.setText("End Turn");
        endTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnButtonActionPerformed(evt);
            }
        });
        gamePanel.add(endTurnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, -1, -1));
        gamePanel.add(player1Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, -1, -1));
        gamePanel.add(player1Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, -1, -1));
        gamePanel.add(player1Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));
        gamePanel.add(player1Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, -1, -1));
        gamePanel.add(player2Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 750, -1, -1));
        gamePanel.add(player2Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 590, -1, -1));
        gamePanel.add(player2Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, -1, -1));
        gamePanel.add(player2Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 750, -1, -1));

        takeTwoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(takeTwoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        takeOneLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(takeOneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, -1, -1));

        takeThreeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(takeThreeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        giveOneLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(giveOneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, -1, -1));

        shareOneLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(shareOneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, -1, -1));

        giveTwoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(giveTwoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        shareTwoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(shareTwoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, -1, -1));

        giveThreeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(giveThreeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        shareThreeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(shareThreeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        fuckYouLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        gamePanel.add(fuckYouLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        player3NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player3NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player3NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player3NameLabel.setText("Player 3");
        player3NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player3NameLabel.setOpaque(true);
        gamePanel.add(player3NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 200, 50));
        gamePanel.add(player3Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 240, -1, -1));
        gamePanel.add(player3Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 80, -1, -1));
        gamePanel.add(player3Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 80, -1, -1));
        gamePanel.add(player3Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, -1, -1));

        player4NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player4NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player4NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player4NameLabel.setText("Player 4");
        player4NameLabel.setToolTipText("");
        player4NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player4NameLabel.setOpaque(true);
        gamePanel.add(player4NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 530, 200, 50));
        gamePanel.add(player4Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 750, -1, -1));
        gamePanel.add(player4Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 590, -1, -1));
        gamePanel.add(player4Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 590, -1, -1));
        gamePanel.add(player4Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 750, -1, -1));

        player5NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player5NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player5NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player5NameLabel.setText("Player 5");
        player5NameLabel.setToolTipText("");
        player5NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player5NameLabel.setOpaque(true);
        gamePanel.add(player5NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 200, 50));
        gamePanel.add(player5Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 240, -1, -1));
        gamePanel.add(player5Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 80, -1, -1));
        gamePanel.add(player5Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 80, -1, -1));
        gamePanel.add(player5Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 240, -1, -1));

        player6NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player6NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player6NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player6NameLabel.setText("Player 6");
        player6NameLabel.setToolTipText("");
        player6NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player6NameLabel.setOpaque(true);
        gamePanel.add(player6NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 530, 200, 50));
        gamePanel.add(player6Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 750, -1, -1));
        gamePanel.add(player6Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 590, -1, -1));
        gamePanel.add(player6Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 590, -1, -1));
        gamePanel.add(player6Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 750, -1, -1));

        player7NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player7NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player7NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player7NameLabel.setText("Player 7");
        player7NameLabel.setToolTipText("");
        player7NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player7NameLabel.setOpaque(true);
        gamePanel.add(player7NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 530, 200, 50));
        gamePanel.add(player7Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 750, -1, -1));
        gamePanel.add(player7Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 590, -1, -1));
        gamePanel.add(player7Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 590, -1, -1));
        gamePanel.add(player7Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 750, -1, -1));

        player8NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player8NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player8NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player8NameLabel.setText("Player 8");
        player8NameLabel.setToolTipText("");
        player8NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player8NameLabel.setOpaque(true);
        gamePanel.add(player8NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 20, 200, 50));
        gamePanel.add(player8Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 240, -1, -1));
        gamePanel.add(player8Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 80, -1, -1));
        gamePanel.add(player8Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 80, -1, -1));
        gamePanel.add(player8Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 240, -1, -1));

        player9NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player9NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player9NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player9NameLabel.setText("Player 9");
        player9NameLabel.setToolTipText("");
        player9NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player9NameLabel.setOpaque(true);
        gamePanel.add(player9NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 530, 200, 50));
        gamePanel.add(player9Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 750, -1, -1));
        gamePanel.add(player9Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 590, -1, -1));
        gamePanel.add(player9Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 590, -1, -1));
        gamePanel.add(player9Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 750, -1, -1));

        player10NameLabel.setBackground(new java.awt.Color(155, 12, 12));
        player10NameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        player10NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player10NameLabel.setText("Player 10");
        player10NameLabel.setToolTipText("");
        player10NameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        player10NameLabel.setOpaque(true);
        gamePanel.add(player10NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 20, 200, 50));
        gamePanel.add(player10Card4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 240, -1, -1));
        gamePanel.add(player10Card2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 80, -1, -1));
        gamePanel.add(player10Card1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 80, -1, -1));
        gamePanel.add(player10Card3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 240, -1, -1));

        chatTextArea.setEditable(false);
        chatTextArea.setColumns(20);
        chatTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chatTextArea.setLineWrap(true);
        chatTextArea.setRows(5);
        chatTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(chatTextArea);

        gamePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 320, 290));

        chatTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chatTextFieldKeyPressed(evt);
            }
        });
        gamePanel.add(chatTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 820, 320, 40));

        chatLabel.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        chatLabel.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel.setText("Chat");
        gamePanel.add(chatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, 40));

        replayButton.setText("Replay");
        replayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayButtonActionPerformed(evt);
            }
        });
        gamePanel.add(replayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(2010, 70, 70, -1));

        backToMenuButton.setText("Menu");
        backToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButtonActionPerformed(evt);
            }
        });
        gamePanel.add(backToMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(2010, 40, 70, -1));

        playerPanelBackGroundLabel.setBackground(new java.awt.Color(155, 12, 12));
        playerPanelBackGroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backgroud2.PNG"))); // NOI18N
        gamePanel.add(playerPanelBackGroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2100, 1000));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddPlayerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddPlayerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        //new AddPlayerNames().setVisible(true);
        game = new SmokeOrFire();
        game.setPlayerCount(playerCountMenu);       
        AddPlayerPanel.setVisible(true);
        menuPanel.setVisible(false);
        
        
        this.countTracker = 1;
        this.playerNamesList = new ArrayList<>();
        this.labelsList = new ArrayList<>();
        this.playerHandsLabelsList = new ArrayList<>();
        this.playerNameLabels = new ArrayList<>();
        this.handLabels = new ArrayList<>();
        this.giveRoundLabels = new ArrayList<>();
        this.takeRoundLabels = new ArrayList<>();
        this.shareRoundLabels = new ArrayList<>();
        this.pileType = 0;
        playerIDLabelArrayBuilder();        
        
        HandLabelsBuilder();
        giveRoundLabelsBuilder();
        takeRoundLabelsBuilder();
        shareRoundLabelsBuilder();
        playerNameLabelArrayBuilder();
        

                 
        
        
    }//GEN-LAST:event_playButtonActionPerformed

    private void playerNumSelectComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNumSelectComboBox1ActionPerformed
        // TODO add your handling code here:
        if(playerNumSelectComboBox1.getSelectedIndex() != 0){
            this.playerCountMenu = PlAYER_NUMBER[playerNumSelectComboBox1.getSelectedIndex()];
            playButton.setVisible(true);
        } else {
            playButton.setVisible(false);
        }
    }//GEN-LAST:event_playerNumSelectComboBox1ActionPerformed

    private void playerNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playerNameTextFieldKeyPressed
        // TODO add your handling code here:
        //if user presses enter
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            // Check if user entered a name before pressing Enter
            if(playerNameTextField.getText().trim() == null || playerNameTextField.getText().trim().isBlank()){
                errorLabel1.setText("You have not entered a Name! Please enter a Name");
            
            } else if(countTracker <= game.getPlayerCount()){
                errorLabel1.setText(null);
                String name = playerNameTextField.getText().trim();
                playerNamesList.add(name);
                playerNameTextField.setText("");
                for(int i = 0; i < playerNamesList.size(); i++){
                        labelsList.get(i).setText(playerNamesList.get(i));        
                }
                countTracker++;
            } else { // check if user tried to enter more names then players
                
                errorLabel1.setText("You have entered more name's then players! Please Click Ready");
            }
        }

    }//GEN-LAST:event_playerNameTextFieldKeyPressed

    private void readyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyButtonActionPerformed
        // TODO add your handling code here:
        
        if(playerNamesList.isEmpty() || playerNamesList.size() < game.getPlayerCount()){
            errorLabel1.setText("You have not entered the correct number of player names!");   
        } else {
            for(int i = 0; i < game.getPlayerCount(); i++){
                game.createPlayer(i, playerNamesList.get(i).toString());
            }
            AddPlayerPanel.setVisible(false);
            handLabelArrayBuilder(game.getPlayerCount()); // test location
            for(int i = 0; i < game.getPlayerCount(); i++){
                playerNameLabels.get(i).setText(game.getPlayer(i).getName());
                playerNameLabels.get(i).setVisible(true);
            } 
            
            if(game.getPlayerCount() != 10){
                for(int i = game.getPlayerCount(); i < 10; i++){
                    playerNameLabels.get(i).setVisible(false);
                }
            }    
            game.startGame();
            roundTextArea.setText(game.getMessage());  
            gamePanel.setVisible(true);
            startButton.setVisible(true);
            actionButton1.setVisible(false);
            actionButton2.setVisible(false);
            actionButton3.setVisible(false);
            actionButton4.setVisible(false);
            endTurnButton.setVisible(false);
            replayButton.setVisible(false);
        }    
    }//GEN-LAST:event_readyButtonActionPerformed

    
    private void exit2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2ButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit2ButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        //game.roundOne();
        startButton.setVisible(false); actionButton1.setVisible(true); actionButton3.setVisible(true);
        actionButton1.setText("Smoke");
        actionButton3.setText("Fire");
        roundTextArea.setText(game.askQuestion1(game.getCurrentPlayer()));
        
        
    }//GEN-LAST:event_startButtonActionPerformed

    private void actionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton1ActionPerformed
        // TODO add your handling code here:
        if(game.getGameRound() == 1){
            game.setChoice(1); // round 1 Smoke Or Fire = Smoke
            roundTextArea.append(game.roundOne(game.getCurrentPlayer()));
            actionButton1.setVisible(false); actionButton3.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test            
            endTurnButton.setVisible(true);
        } else if (game.getGameRound() == 2){
            game.setChoice(1); // round 2 Higher or Lower  = Higher
            roundTextArea.append(game.roundTwo(game.getCurrentPlayer()));           
            actionButton1.setVisible(false); actionButton3.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test             
            endTurnButton.setVisible(true);            
        } else if (game.getGameRound() == 3){
            game.setChoice(1); // round 3  In or Out = In
            roundTextArea.append(game.roundThree(game.getCurrentPlayer()));           
            actionButton1.setVisible(false); actionButton3.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test             
            endTurnButton.setVisible(true);             
        } else {
            game.setSuitChoice("Clubs"); // round 4 Suits = Clubs
            roundTextArea.append(game.roundFour(game.getCurrentPlayer()));           
            actionButton1.setVisible(false); actionButton2.setVisible(false);
            actionButton3.setVisible(false); actionButton4.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test             
            endTurnButton.setVisible(true);             
        } 
    }//GEN-LAST:event_actionButton1ActionPerformed

    private void actionButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton3ActionPerformed
        // TODO add your handling code here:
        if(game.getGameRound() == 1){
            game.setChoice(0); // round 1 Smoke Or Fire = fire
            roundTextArea.append(game.roundOne(game.getCurrentPlayer()));
            actionButton1.setVisible(false); actionButton3.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test            
            endTurnButton.setVisible(true);
        } else if(game.getGameRound() == 2){
            game.setChoice(0); // round 2 Higher or Lower = Lower
            roundTextArea.append(game.roundTwo(game.getCurrentPlayer()));           
            actionButton1.setVisible(false); actionButton3.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test             
            endTurnButton.setVisible(true);            
        } else if (game.getGameRound() == 3){
            game.setChoice(0); // round 3  In or Out = Out
            roundTextArea.append(game.roundThree(game.getCurrentPlayer()));          
            actionButton1.setVisible(false); actionButton3.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test              
            endTurnButton.setVisible(true);             
        } else {
            game.setSuitChoice("Hearts"); // round 4 Suits = Hearts
            roundTextArea.append(game.roundFour(game.getCurrentPlayer()));          
            actionButton1.setVisible(false); actionButton2.setVisible(false);
            actionButton3.setVisible(false); actionButton4.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test              
            endTurnButton.setVisible(true);             
        }        
    }//GEN-LAST:event_actionButton3ActionPerformed

    private void endTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnButtonActionPerformed
        // TODO add your handling code here:
        if(game.getCurrentPlayer() != game.getPlayerCount() - 1){
            game.setCurrentPlayer(game.getCurrentPlayer() + 1);
            nextRound();
            
        } else {
            game.setCurrentPlayer(0);
            game.setGameRound(game.getGameRound() + 1);
            endTurnButton.setVisible(false);
            nextRound();      
        }  
    }//GEN-LAST:event_endTurnButtonActionPerformed

    private void actionButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton2ActionPerformed
        // TODO add your handling code here:
        if(game.getGameRound() == 4){ // round 4 Suits = Diamonds
            game.setSuitChoice("Diamonds"); 
            roundTextArea.append(game.roundFour(game.getCurrentPlayer()));         
            actionButton1.setVisible(false); actionButton2.setVisible(false);
            actionButton3.setVisible(false); actionButton4.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test                       
            endTurnButton.setVisible(true);
        } else{
            game.reDraw(pileType);
            roundTextArea.setText(game.getMessage());
            actionButton2.setVisible(false);
            setLastRoundIcon();
            System.out.println("ReDraw pileType: " + pileType + " Row: " + inRowPosition + " Deck Empty:" + game.getEmptyDeck());
            if(game.getEmptyDeck()!= true && game.playerDrinkCheck() != true){
                actionButton2.setVisible(true);
            } else if (pileType != 3) {
                game.resetPlayersDrinkStatus();
                actionButton4.setVisible(true);
                this.pileType++;                
            } else {
                roundTextArea.append(newline + "Game Over");
                replayButton.setVisible(true);
                actionButton4.setVisible(false);                
            }         
        }  
    }//GEN-LAST:event_actionButton2ActionPerformed

    private void actionButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton4ActionPerformed
        // TODO add your handling code here:
        if(game.getGameRound() == 4){  // round 4 Suits = Spades      
            game.setSuitChoice("Spades");         
            roundTextArea.append(game.roundFour(game.getCurrentPlayer()));        
            actionButton1.setVisible(false); actionButton2.setVisible(false);
            actionButton3.setVisible(false); actionButton4.setVisible(false);
            // get card image 
            handImage(game.getCurrentPlayer(), game.getGameRound());
            // test                
            endTurnButton.setVisible(true);        
        } else { // round 5 = Flip Card
            //inRowPosition = 0; start
            //pileType = 0; start
            //needs to be setup for the fuck you card.                         
            System.out.println("Flipped pileType: " + pileType + " Row: " + inRowPosition + " Deck Empty:" + game.getEmptyDeck());
            if(this.inRowPosition == 2 && this.pileType >= 3){
                this.inRowPosition = 0;
                this.pileType = 3;
            } else if(this.pileType >= 3){
                this.pileType = 0;
                this.inRowPosition++;
            }
            game.SetPileRound(this.inRowPosition);
            game.roundFive(this.pileType,this.inRowPosition);
            roundTextArea.setText(game.getMessage());
            setLastRoundIcon();
            
            if(game.getEmptyDeck()!= true && game.playerDrinkCheck() != true){
                actionButton4.setVisible(false);
                actionButton2.setVisible(true);
            } else {
                if(pileType == 3 && inRowPosition == 0){
                    roundTextArea.append(newline + "Game Over");
                    actionButton4.setVisible(false);
                    replayButton.setVisible(true);
                } else {    
                    this.pileType++;
                    game.resetPlayersDrinkStatus();
                }
            }    
        } 
    }//GEN-LAST:event_actionButton4ActionPerformed

    private void chatTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chatTextFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String s = chatTextField.getText().trim();
            chatTextArea.append("Said: " + s + newline);
            chatTextField.setText("");
        }        
    }//GEN-LAST:event_chatTextFieldKeyPressed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        AddPlayerPanel.setVisible(false);
        playButton.setVisible(false);        
        for(int i = 0; i < playerNamesList.size(); i++){
            labelsList.get(i).setText(null);        
        }        
        game.returnGame();
        playerNumSelectComboBox1.setSelectedIndex(0);
        menuPanel.setVisible(true);
        
        
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void replayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replayButtonActionPerformed
        // TODO add your handling code here:
        URL imageURL = getClass().getResource("/red_back.png");
        ImageIcon img = new ImageIcon(imageURL);
        for(int i = 0; i < 3; i++ ){
            giveRoundLabels.get(i).setIcon(img);
            shareRoundLabels.get(i).setIcon(img);
        }
        for(int i = 0; i < 4; i++){
            takeRoundLabels.get(i).setIcon(img);;
        }
        
        for(int i = 0; i < game.getPlayerCount(); i++){           
            for(int j = 0; j < 4; j++){
                playerHandsLabelsList.get(i).get(j).setIcon(null);
            }
        }
        roundTextArea.setText("Let's Play Another Round!" + newline + "Press the Start Button to Begin");
        game.replayGame();
        pileType = 0;
        inRowPosition = 0;
        startButton.setVisible(true);
        replayButton.setVisible(false);
    }//GEN-LAST:event_replayButtonActionPerformed

    private void backToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButtonActionPerformed
        // TODO add your handling code here:
        URL imageURL = getClass().getResource("/red_back.png");
        ImageIcon img = new ImageIcon(imageURL);
        for(int i = 0; i < 3; i++ ){
            giveRoundLabels.get(i).setIcon(img);
            shareRoundLabels.get(i).setIcon(img);
        }
        for(int i = 0; i < 4; i++){
            takeRoundLabels.get(i).setIcon(img);;
        }
        
        for(int i = 0; i < game.getPlayerCount(); i++){           
            for(int j = 0; j < 4; j++){
                playerHandsLabelsList.get(i).get(j).setIcon(null);
            }
        }
        
        for(int i = 0; i < game.getPlayerCount(); i++){
            playerNameLabels.get(i).setVisible(false);
        }
        for(int i = 0; i < playerNamesList.size(); i++){
            labelsList.get(i).setText(null);        
        }                 
        roundTextArea.setText("");
        game.resetGame();
        playerNumSelectComboBox1.setSelectedIndex(0);
        pileType = 0;
        inRowPosition = 0;
        startButton.setVisible(true);
        replayButton.setVisible(false);
        gamePanel.setVisible(false);
        menuPanel.setVisible(true);
    }//GEN-LAST:event_backToMenuButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SmokeOrFireUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SmokeOrFireUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SmokeOrFireUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SmokeOrFireUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmokeOrFireUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPlayerPanel;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton actionButton1;
    private javax.swing.JButton actionButton2;
    private javax.swing.JButton actionButton3;
    private javax.swing.JButton actionButton4;
    private javax.swing.JLabel addPlayerBackground;
    private javax.swing.JButton backToMenuButton;
    private javax.swing.JLabel chatLabel;
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JTextField chatTextField;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JButton exit2Button;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel fuckYouLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel gamePanelTitleLabel;
    private javax.swing.JLabel gameTitleLabel;
    private javax.swing.JLabel giveOneLabel;
    private javax.swing.JLabel giveThreeLabel;
    private javax.swing.JLabel giveTwoLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel menuBackgroundLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nameOfThePlayerLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel player10Card1Label;
    private javax.swing.JLabel player10Card2Label;
    private javax.swing.JLabel player10Card3Label;
    private javax.swing.JLabel player10Card4Label;
    private javax.swing.JLabel player10NameLabel;
    private javax.swing.JLabel player1Card1Label;
    private javax.swing.JLabel player1Card2Label;
    private javax.swing.JLabel player1Card3Label;
    private javax.swing.JLabel player1Card4Label;
    private javax.swing.JLabel player1NameLabel;
    private javax.swing.JLabel player2Card1Label;
    private javax.swing.JLabel player2Card2Label;
    private javax.swing.JLabel player2Card3Label;
    private javax.swing.JLabel player2Card4Label;
    private javax.swing.JLabel player2NameLabel;
    private javax.swing.JLabel player3Card1Label;
    private javax.swing.JLabel player3Card2Label;
    private javax.swing.JLabel player3Card3Label;
    private javax.swing.JLabel player3Card4Label;
    private javax.swing.JLabel player3NameLabel;
    private javax.swing.JLabel player4Card1Label;
    private javax.swing.JLabel player4Card2Label;
    private javax.swing.JLabel player4Card3Label;
    private javax.swing.JLabel player4Card4Label;
    private javax.swing.JLabel player4NameLabel;
    private javax.swing.JLabel player5Card1Label;
    private javax.swing.JLabel player5Card2Label;
    private javax.swing.JLabel player5Card3Label;
    private javax.swing.JLabel player5Card4Label;
    private javax.swing.JLabel player5NameLabel;
    private javax.swing.JLabel player6Card1Label;
    private javax.swing.JLabel player6Card2Label;
    private javax.swing.JLabel player6Card3Label;
    private javax.swing.JLabel player6Card4Label;
    private javax.swing.JLabel player6NameLabel;
    private javax.swing.JLabel player7Card1Label;
    private javax.swing.JLabel player7Card2Label;
    private javax.swing.JLabel player7Card3Label;
    private javax.swing.JLabel player7Card4Label;
    private javax.swing.JLabel player7NameLabel;
    private javax.swing.JLabel player8Card1Label;
    private javax.swing.JLabel player8Card2Label;
    private javax.swing.JLabel player8Card3Label;
    private javax.swing.JLabel player8Card4Label;
    private javax.swing.JLabel player8NameLabel;
    private javax.swing.JLabel player9Card1Label;
    private javax.swing.JLabel player9Card2Label;
    private javax.swing.JLabel player9Card3Label;
    private javax.swing.JLabel player9Card4Label;
    private javax.swing.JLabel player9NameLabel;
    private javax.swing.JLabel playerAddLabel;
    private javax.swing.JLabel playerID10Label;
    private javax.swing.JLabel playerID1Label;
    private javax.swing.JLabel playerID2Label;
    private javax.swing.JLabel playerID3Label;
    private javax.swing.JLabel playerID4Label;
    private javax.swing.JLabel playerID5Label;
    private javax.swing.JLabel playerID6Label;
    private javax.swing.JLabel playerID7Label;
    private javax.swing.JLabel playerID8Label;
    private javax.swing.JLabel playerID9Label;
    private javax.swing.JTextField playerNameTextField;
    private javax.swing.JComboBox<String> playerNumSelectComboBox1;
    private javax.swing.JLabel playerPanelBackGroundLabel;
    private javax.swing.JButton readyButton;
    private javax.swing.JButton replayButton;
    private javax.swing.JScrollPane roundScrollPane1;
    private javax.swing.JTextArea roundTextArea;
    private javax.swing.JLabel shareOneLabel;
    private javax.swing.JLabel shareThreeLabel;
    private javax.swing.JLabel shareTwoLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel takeOneLabel;
    private javax.swing.JLabel takeThreeLabel;
    private javax.swing.JLabel takeTwoLabel;
    // End of variables declaration//GEN-END:variables
}
