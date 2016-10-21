package SuperTrumpGame;

import java.io.IOException;
import java.util.*;

public class Game {
    private static final int STARTING_HAND = 8;
    private int noPlayers;
    public ArrayList<GamePlayers> players;
    public ArrayList<GameCards> hand;
    public GameDeck deck = new GameDeck();
    public ArrayList<GameCards> play;

    public Game(int noPlayers) {
        this.noPlayers = noPlayers;
        hand = new ArrayList<>();
        players = new ArrayList<GamePlayers>(noPlayers);
        play = new ArrayList<>();
    }

    public int selectRandDealer() {
        Random rand = new Random();
        int dealer = rand.nextInt(noPlayers);
        System.out.println("Player " + (dealer + 1));
        return dealer;
    }

    public ArrayList<GamePlayers> getSelectedPlayers(int noPlayers) {
        for (int i = 0; i < noPlayers; i++) {
            players.add(new GamePlayers("Player " + (i + 1)));
        }
        return players;
    }

    public String showPlayingCard() {
        String value = "";
        System.out.print("Card In Play: \n" + value);
        for (GameCards i : play) {
            value += i.toString();
        }
        return value;
    }

    public void playCard(int i, int cardIndex) {
        if (play.size() > 0) {
            play.remove(0);
        }
        GameCards card = players.get(i).removeCard(cardIndex);
        play.add(card);
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

    public int gameRound(int currentPlayer) {
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
            players.get(currentPlayer).playersHand();
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
                    if (players.get(currentPlayer).compareCard(cardChoice).getTrump()) {
                        category = trumpCard(currentPlayer, cardChoice);
                    } else {
                        category = firstTurnOfRound(currentPlayer, cardChoice);
                        playCard(currentPlayer, cardChoice);
                    }
                } else {
                    while (passingTurn == false) {
                        passTurn = chooseCategory();
                        if (Objects.equals(passTurn, "pass")) {
                            playerSkip[currentPlayer] = true;
                            addCard(currentPlayer);
                            round++;
                        } else {
                            cardChoice = selectCard();
                            if (players.get(currentPlayer).compareCard(cardChoice).getTrump()) {
                                category = trumpCard(currentPlayer, cardChoice);
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
            //}
            passingTurn = false;
            winner = checkForWinning(currentPlayer);
            if (winner == true) {
                playerSkip[currentPlayer] = true;
            }
            firstTurn = true;
            currentPlayer = switchPlayer(currentPlayer, playerSkip);
        }
        return currentPlayer;
    }

    private String firstTurnOfRound(int currentPlayer, int cardChoice) {
        String category;
        if (players.get(currentPlayer).compareCard(cardChoice).getTrump()) {
            category = trumpCard(currentPlayer, cardChoice);
        }
        else {
            System.out.println("Choose the Category type: (h, g, cl, cr, v)");
            category = chooseCategory();
        }
        return category;
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

    private String trumpCard(int currentPlayer, int card) {
        String newCategory = players.get(currentPlayer).compareCard(card).getName();
        if (Objects.equals(newCategory, "The Gemmologist")){
            System.out.println("Category changed to Hardness");
            newCategory = "h";
        }
        else if (Objects.equals(newCategory, "The Petrologist")){
            System.out.println("Category changed to Crust Abundance");
            newCategory = "cr";
        }
        else if (Objects.equals(newCategory, "The Mineralogist")){
            System.out.println("Category changed to Clevage");
            newCategory = "cl";
        }
        else if (Objects.equals(newCategory, "The Geophysicist")){
            if(players.get(currentPlayer).containsMag()){
                String playCombo = chooseCategory();
                if(Objects.equals(playCombo, "y")){
                    players.get(currentPlayer).winningCombo();
                }
            }
            System.out.println("Category changed to Specific Gravity");
            newCategory = "g";
        }
        else if (Objects.equals(newCategory, "The Miner")){
            System.out.println("Category changed to Economic Value");
            newCategory = "v";
        }
        else if (Objects.equals(newCategory, "The Geologist")){
            System.out.println("Choose the Category type: (h, g, cl, cr, v)");
            newCategory = chooseCategory();
        }
        playCard(currentPlayer, card);
        return newCategory;
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
    public String chooseCategory() {
            Scanner input = new Scanner(System.in);
            String category = input.nextLine();
            return category;
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
} //end of class NewGame

