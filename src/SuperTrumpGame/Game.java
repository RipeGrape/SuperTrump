package SuperTrumpGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class Game extends JFrame implements ActionListener {
    private static final int STARTING_HAND = 8;
    public ArrayList<GamePlayers> players;
    public ArrayList<GameCards> hand;
    public GameDeck deck = new GameDeck();
    public ArrayList<GameCards> play;

    JPanel mainBoard = new JPanel();
    JPanel gameBoard = new JPanel();
    JPanel selectionBoard = new JPanel();
    JPanel playerBoard = new JPanel();
    JPanel numOfPlayers = new JPanel();
    JButton startGame = new JButton( "Start Game" );
    JButton instructions = new JButton( "Instructions" );
    JButton threePlayers = new JButton( "3 PLAYERS" );
    JButton fourPlayers = new JButton( "4 PLAYERS" );
    JButton fivePlayers = new JButton( "5 PLAYERS" );
    JButton hardButton = new JButton( "Hardness" );
    JButton gravButton = new JButton( "Specific Gravity" );
    JButton clevButton = new JButton( "Clevage" );
    JButton crustButton = new JButton( "Crust Abundance" );
    JButton valueButton = new JButton( "Economic Value" );
    ArrayList<JButton> card = new ArrayList<JButton>();
    JButton pass = new JButton("Pass");
    public int cardChoice = 0;
    private int currentPlayer = 0;
    int noPlayers = 0;
    private boolean firstTurnComplete = false;
    private String category ="";


    public Game() {
        super("Super Trump Game");
        setLayout(new FlowLayout());
        add(startGame, BorderLayout.NORTH);
        add(instructions, BorderLayout.NORTH);
        numOfPlayers.setVisible(false);
        playerBoard.setVisible(false);
        selectionBoard.setVisible(false);
        startGame.addActionListener(this);
        mainBoard.setSize(1200,1000);
        mainBoard.setVisible(true);
        mainBoard.add(pass);

        hand = new ArrayList<>();
        players = new ArrayList<GamePlayers>(noPlayers);
        play = new ArrayList<>();
        deck.shuffle();
    }

    public void addButtons() {
        add(playerBoard);
        playerBoard.setVisible(true);
        System.out.println(players.get(currentPlayer).cardPaths());
        String[] paths = players.get(currentPlayer).cardPaths();
        for (int i = 0; i < players.get(currentPlayer).handSize(); i++) {
            card.add(new JButton());
            card.get(i).setActionCommand("" + i);
            ImageIcon icon = new ImageIcon(getClass().getResource(paths[i]));
            card.get(i).setPreferredSize(new Dimension(100, 150));
            icon.setImage(icon.getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH));
            //card.get(i).setVisible(true);
            card.get(i).setIcon(icon);
            playerBoard.add(card.get(i));
            card.get(i).addActionListener(this);
        }
    }
    public int selectRandDealer(int noPlayers) {
        Random rand = new Random();
        int dealer = rand.nextInt(noPlayers);
        System.out.println("Player " + (dealer + 1));
        return currentPlayer;
    }

    public ArrayList<GamePlayers> getSelectedPlayers() {
        for (int i = 0; i < noPlayers; i++) {
            players.add(new GamePlayers("Player " + (i + 1)));
        }
        return players;
    }

    public String showPlayingCard() {
        String value = "";
        if (play == null){return value;}
        for (GameCards i : play) {
            value = i.cardPath();
        }
        return value;
    }

    public void playCard(int i, int cardIndex) {
        if (play.size() > 0) {
            play.remove(0);
        }
        GameCards card = players.get(i).removeCard(cardIndex);
        play.add(card);
        ImageIcon icon = new ImageIcon(getClass().getResource(showPlayingCard()));
        play.get(0).setPreferredSize(new Dimension(100, 150));
        icon.setImage(icon.getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH));
    }

    public void addCard(int i) {
        players.get(i).addCard(deck.drawCards());
    }

    public void startingHand() {
        players = new ArrayList<GamePlayers>(noPlayers);
        for (int i = 0; i < noPlayers; i++) {
            players.add(new GamePlayers("Player " + (i + 1)));
        }
        for (GamePlayers player : players) {
            ArrayList<GameCards> cards = deck.getCard(STARTING_HAND);
            player.setCards(cards);
        }
    }

    public int switchPlayer(int currentPlayer, boolean skip[]) {
        do {
            currentPlayer++;
            if (currentPlayer >= players.size()) {
                currentPlayer = 0;
            }
        }while (skip[currentPlayer] == true);
        return currentPlayer;
    }

    public void gameRound() {
        int round = 0;
        String category = "";
        String passTurn = "";
        int cardChoice;
        boolean[] playerSkip = new boolean[players.size()];
        boolean firstTurn = false;
        boolean winner = false;
        boolean passingTurn = false;
        Arrays.fill(playerSkip, false);
        System.out.println("New Round");

        while (round < players.size() - 1) {
            System.out.print(showPlayingCard());
            //players.get(currentPlayer).playersHand();
            //System.out.println(players.get(currentPlayer).toString());
            /*System.out.println("Type pass to pass");
            passTurn = chooseCategory();
            if (Objects.equals(passTurn, "pass")) {
                playerSkip[currentPlayer] = true;
                addCard(currentPlayer);
                round++;
            } else {*/
                if (firstTurn == false) {
                    cardChoice = selectCard();

                } else {
                    while (passingTurn == false) {
                        //passTurn = chooseCategory();
                        if (Objects.equals(passTurn, "pass")) {
                            playerSkip[currentPlayer] = true;
                            addCard(currentPlayer);
                            round++;
                        } else {
                            cardChoice = selectCard();
                            if (players.get(currentPlayer).compareCard(cardChoice).getTrump()) {
                                trumpCard(currentPlayer, cardChoice);
                                passingTurn = true;
                            } else if (Objects.equals(category, "h")) {
                                //cardChoice = selectCard();
                                passingTurn = compareHardness(currentPlayer, cardChoice);
                            } else if (Objects.equals(category, "g")) {
                                //cardChoice = selectCard();
                                passingTurn = compareGravity(currentPlayer, cardChoice);
                            } else if (Objects.equals(category, "cl")) {
                                //cardChoice = selectCard();
                                passingTurn = compareCleavage(currentPlayer, cardChoice);
                            } else if (Objects.equals(category, "cr")) {
                                //cardChoice = selectCard();
                                passingTurn = compareCrust(currentPlayer, cardChoice);
                            } else if (Objects.equals(category, "v")) {
                                //cardChoice = selectCard();
                                passingTurn = compareValue(currentPlayer, cardChoice);
                            }
                        }
                    }
                }
            passingTurn = false;
            winner = checkForWinning(currentPlayer);
            if (winner == true) {
                playerSkip[currentPlayer] = true;
            }
            firstTurn = true;
            currentPlayer = switchPlayer(currentPlayer, playerSkip);
        }
    }

    private void firstTurnOfRound(int currentPlayer, int cardChoice) {
        if (players.get(currentPlayer).compareCard(cardChoice).getTrump()) {
            trumpCard(currentPlayer, cardChoice);
        }
        else {
            System.out.println("Choose the Category type: (h, g, cl, cr, v)");
            chooseCategory();
            playCard(currentPlayer, cardChoice);
        }
    }

    private boolean checkForWinning(int currentPlayer) {
        if(players.get(currentPlayer).isEmpty()){
            players.remove(currentPlayer);
            return true;
        }
        else {
            return false;
        }
    }

    private void trumpCard(int currentPlayer, int card) {
        String newCategory = players.get(currentPlayer).compareCard(card).getName();
        if (Objects.equals(newCategory, "The Gemmologist")){
            System.out.println("Category changed to Hardness");
            category = "h";
        }
        else if (Objects.equals(newCategory, "The Petrologist")){
            System.out.println("Category changed to Crust Abundance");
            category = "cr";
        }
        else if (Objects.equals(newCategory, "The Mineralogist")){
            System.out.println("Category changed to Clevage");
            category = "cl";
        }
        else if (Objects.equals(newCategory, "The Geophysicist")){
            if(players.get(currentPlayer).containsMag()){
                /*if(Objects.equals(playCombo, "y")){
                    players.get(currentPlayer).winningCombo();
                }*/
            }
            category = "g";
        }
        else if (Objects.equals(newCategory, "The Miner")){
            category = "v";
        }
        else if (Objects.equals(newCategory, "The Geologist")){
            chooseCategory();
        }
        playCard(currentPlayer, card);
    }

    private boolean compareCleavage(int i, int card) {
        if (play.get(0).getClevage() < players.get(i).compareCard(card).getClevage()) {
            playCard(i, card);
            return true;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return false;
        }
    }

    private boolean compareCrust(int i, int card) {
        if (play.get(0).getCrustAbund() < players.get(i).compareCard(card).getCrustAbund()) {
            playCard(i, card);
            return true;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return false;
        }
    }

    private boolean compareValue(int i, int card) {
        if (play.get(0).getEcoValue() < players.get(i).compareCard(card).getEcoValue()) {
            playCard(i, card);
            return true;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return false;
        }
    }

    private boolean compareGravity(int i, int card) {
        if (play.get(0).getSpecGravity() < players.get(i).compareCard(card).getSpecGravity()) {
            playCard(i, card);
            return true;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return false;
        }
    }

    private boolean compareHardness(int i, int card) {
        if (play.get(0).getHard() < players.get(i).compareCard(card).getHard()) {
            playCard(i, card);
            return true;
        }
        else {
            System.out.println("This card does not beat card in play");
            return false;
        }
    }
    public void chooseCategory() {
        add(selectionBoard);
        selectionBoard.setVisible(true);
        selectionBoard.add(hardButton);
        selectionBoard.add(gravButton);
        selectionBoard.add(clevButton);
        selectionBoard.add(crustButton);
        selectionBoard.add(valueButton);
        hardButton.addActionListener(this);
        gravButton.addActionListener(this);
        clevButton.addActionListener(this);
        crustButton.addActionListener(this);
        valueButton.addActionListener(this);
    }

    public int selectCard(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the card");
        while(!input.hasNextInt() ){
            input.next();
        }
        int value = input.nextInt();
        return value;
    }

    public boolean loser() {
        if(players.size() == 1){
            System.out.println("You are the loser" + players.get(0));
            return true;
        }
        else{
            return false;
        }
    }
    private void playGame() {
        /*cframe = new Game(noPlayers);
        cframe.setVisible(true);*/
        //Game game = new Game(noPlayers);

        selectRandDealer(noPlayers);
        boolean gameFinish = false;
        boolean gameCompleteCheck = false;

        while (gameFinish == false){
            gameRound();
            gameCompleteCheck = loser();
            if(gameCompleteCheck) {
                gameFinish = true;
            }
        }
    }

    private void getNoPlayers() {
        //This bring up the players choice of the number of players
        JLabel titleOfPlayer = new JLabel("How many players?");
        add(titleOfPlayer);
        add(numOfPlayers);
        numOfPlayers.setVisible(true);
        numOfPlayers.add(threePlayers);
        numOfPlayers.add(fourPlayers);
        numOfPlayers.add(fivePlayers);
        threePlayers.addActionListener(this);
        fourPlayers.addActionListener(this);
        fivePlayers.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //The action if that button is pressed
        JButton source = (JButton) e.getSource();
        if (source == startGame) { //Start Game Button
            startGame.setEnabled(false);
            getNoPlayers();
        }
        else if (source == threePlayers) { // 3 players button
            noPlayers =3;
            numOfPlayers.removeAll();

            getSelectedPlayers();
            startingHand();
            addButtons();
            //playGame();
        }
        else if (source == fourPlayers) { //4 players button
            noPlayers =4;
            numOfPlayers.removeAll();
            addButtons();
            //playGame();
        }
        else if (source == fivePlayers) { //5 players button
            noPlayers = 5;
            numOfPlayers.removeAll();
           // playGame();
        }
        else if (source == hardButton) {
            category = "h";
            playCard(currentPlayer, cardChoice);
        }
        else if (source == gravButton) {
            category = "g";
            playCard(currentPlayer, cardChoice);
        }
        else if (source == clevButton) {
            category = "cl";
            playCard(currentPlayer, cardChoice);
        }
        else if (source == crustButton) {
            category = "cr";
            playCard(currentPlayer, cardChoice);
        }
        else if (source == valueButton) {
            category = "v";
            playCard(currentPlayer, cardChoice);
        }
        // assume here that we have a card button pressed
        else {
            System.out.println("selected card: " + source.getActionCommand());
            cardChoice = Integer.parseInt(source.getActionCommand());
            players.get(currentPlayer).compareCard(cardChoice);
            if (firstTurnComplete == false){
                firstTurnOfRound(currentPlayer, cardChoice);
                playCard(currentPlayer, cardChoice);

            }

            //cardChoice = cardButton();
        }
    }

} //end of class NewGame

