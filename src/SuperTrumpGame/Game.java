package SuperTrumpGame;

import java.util.*;

public class Game {
    private static final int STARTING_HAND = 2;
    private int noPlayers;
    public GamePlayers[] players;
    public ArrayList<GameCards> hand;
    public GameDeck deck = new GameDeck();
    public ArrayList<GameCards> play;

    public Game(int noPlayers) {
        this.noPlayers = noPlayers;
        hand = new ArrayList<>();
        players = new GamePlayers[noPlayers];
        play = new ArrayList<>();
    }

    public int selectRandDealer() {
        Random rand = new Random();
        int dealer = rand.nextInt(noPlayers);
        System.out.println("Player " + (dealer + 1));
        return dealer;
    }

    public GamePlayers[] getSelectedPlayers(int noPlayers) {
        for (int i = 0; i < noPlayers; i++) {
            players = new GamePlayers[noPlayers];
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
        GameCards card = players[i].removeCard(cardIndex);
        play.add(card);
    }

    public void addCard(int i) {
        players[i].addCard(deck.drawCards());
    }

    public void startingHand() {
        players = new GamePlayers[noPlayers];
        for (int i = 0; i < noPlayers; i++) {
            players[i] = new GamePlayers("Player " + (i + 1));
        }
        for (GamePlayers player : players) {
            ArrayList<GameCards> cards = deck.getCard(STARTING_HAND);
            player.setCards(cards);
        }
    }

    public int switchPlayer(int currentPlayer, boolean skip[]) {
        do {
            currentPlayer++;
            if (currentPlayer >= players.length) {
                currentPlayer = 0;
            }
        }while (skip[currentPlayer] == true);
        /*if(currentPlayer + 1 == playerList.length) {
            for(int i = 0; i < playerList.length; i++) {
                if(playerList[i] == true) {
                    currentPlayer = i++;
                }
            }
        }
        else {
            for(int i = (currentPlayer+1); i < playerList.length; i++) {
                if(playerList[i] == true) {
                    currentPlayer = i;
                    break;
                }
            }
        }*/
        return currentPlayer;
    }

    public void gameRound() {
        int round = 0;
        String selection = "";
        String passTurn = "";
        int cardChoice;
        int currentPlayer = selectRandDealer();
        boolean[] playerSkip = new boolean[players.length];
        boolean firstTurn = false;
        boolean passingTurn = false;
        Arrays.fill(playerSkip, false);

        while (round < players.length - 1) {
            System.out.print(showPlayingCard());
            System.out.println(players[currentPlayer]);
            if (firstTurn == false) {
                cardChoice = selectCard();
                playCard(currentPlayer, cardChoice);
                System.out.println("Choose the type: (h, g, cl, cr, v)");
                selection = chooseCategory();
            } else {

                cardChoice = selectCard();
                if (Objects.equals(selection, "h")) {
                    passingTurn = compareHardness(currentPlayer, cardChoice);
                }
                else if (Objects.equals(selection, "g")) {
                    passingTurn = compareGravity(currentPlayer, cardChoice);
                } else if (Objects.equals(selection, "cl")) {
                    passingTurn = compareCleavage(currentPlayer, cardChoice);
                } else if (Objects.equals(selection, "cr")) {
                    passingTurn = compareCrust(currentPlayer, cardChoice);
                } else if (Objects.equals(selection, "v")) {
                    passingTurn = compareValue(currentPlayer, cardChoice);
                }
                if (passingTurn == true) {
                    System.out.println("Type pass to pass");
                    passTurn = chooseCategory();
                    if (Objects.equals(passTurn, "pass")) {
                        playerSkip[currentPlayer] = true;
                        addCard(currentPlayer);
                        round++;
                    }
                }
            }
            firstTurn = true;
            currentPlayer = switchPlayer(currentPlayer, playerSkip);

        }
    }

    private boolean compareCleavage(int i, int card) {
        if (play.get(0).getClevage() < players[i].compareCard(card).getClevage()) {
            playCard(i, card);
            return false;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return true;
        }
    }

    private boolean compareCrust(int i, int card) {
        if (play.get(0).getCrustAbund() < players[i].compareCard(card).getCrustAbund()) {
            playCard(i, card);
            return false;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return true;
        }
    }

    private boolean compareValue(int i, int card) {
        if (play.get(0).getEcoValue() < players[i].compareCard(card).getEcoValue()) {
            playCard(i, card);
            return false;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return true;
        }
    }

    private boolean compareGravity(int i, int card) {
        if (play.get(0).getSpecGravity() < players[i].compareCard(card).getSpecGravity()) {
            playCard(i, card);
            return false;
        }
        else {
            System.out.println("This crad doe not beat card in play");
            return true;
        }
    }

    private boolean compareHardness(int i, int card) {
        if (play.get(0).getHard() < players[i].compareCard(card).getHard()) {
            playCard(i, card);
            return false;
        }
        else {
            System.out.println("This card does not beat card in play");
            return true;
        }
    }
    private String chooseCategory() {
            Scanner input = new Scanner(System.in);
            String category = input.nextLine();
            return category;
    }

    private int selectCard(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the card");
        int value = input.nextInt();
        return value;
    }
} //end of class NewGame

