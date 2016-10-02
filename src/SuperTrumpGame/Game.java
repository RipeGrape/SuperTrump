package SuperTrumpGame;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Game {
    private static final int STARTING_HAND = 2;
    private int noPlayers;
    public GamePlayers[] players;
    public ArrayList<GameCards> hand;
    public GameDeck deck = new GameDeck();
//    public ArrayList<CurrentCard> play;

    public Game(int noPlayers) {
        this.noPlayers = noPlayers;
        hand = new ArrayList<>();
        players = new GamePlayers[noPlayers];
        //play = new ArrayList<CurrentCard>();
    }

    public int selectRandDealer() {
        Random rand = new Random();
        int dealer = rand.nextInt(noPlayers);
        System.out.println("Player " + (dealer+1));
        return dealer;
    }

    public GamePlayers[] getSelectedPlayers(int noPlayers) {
        for (int i = 0; i < noPlayers; i++) {
            players = new GamePlayers[noPlayers];
        }
        return players;
    }

    public String playerHand() {
        String str = "";
        if (hand == null){
            throw new NullPointerException("Null Card.");
        }
        for (GamePlayers p : players) {
            str += p.toString();
        }
        return str;
    }
    public void playCard(GameCards card){
        hand.remove(card);
    }

    public void addCard() {
        players = new GamePlayers[noPlayers];
            for(int i = 0; i < noPlayers; i++){
                players[i] = new GamePlayers("Player " + (i+1));
            }
        for (GamePlayers player : players){
            ArrayList<GameCards> cards = deck.getCard(STARTING_HAND);
            player.setCards(cards);
        }
    }
    public int switchPlayer(int currentPlayer) {
        currentPlayer++;
        if (currentPlayer >= players.length){
            currentPlayer = 0;
        }
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
        boolean passTurn = false;
        int currentValue;
        int currentPlayer = selectRandDealer();
        boolean[] player = new boolean[players.length];

        while (round < players.length - 1){
            System.out.println(currentPlayer);
            //switchPlayer(currentPlayer);
            System.out.println(players[currentPlayer]);
            Scanner input = new Scanner(System.in);
            System.out.println("type pass or play: ");
            String what = input.nextLine();
            if(Objects.equals(what, "pass")) {
                //player[currentPlayer] = true;
                round++;
            }
                //player[currentPlayer] = true;
            currentPlayer ++;
            if (currentPlayer >= players.length){
                currentPlayer = 0;
                }
        }
    }
    /*public void startingHand(){
        int STARTING_HAND = 2;
        for (int i = 0; i < STARTING_HAND; i++) {
            for (int j = 0; j < players.length; j++) {
                addCard(hand.get(i), players[j]);
            }
        }
    }*/

} //end of class NewGame