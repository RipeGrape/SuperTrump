package SuperTrumpGame;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Shuffled deck \n");

        menu();
        playGame();
    }

    private static void menu() {
        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        System.out.println("3. Exit Game");
    }

    private static void playGame() {
        int noPlayers = getNoPlayers();
        Game game = new Game(noPlayers);
        GameDeck deck = new GameDeck();
        deck.shuffle();
        int currentPlayer = game.selectRandDealer();
        game.getSelectedPlayers(noPlayers);
        game.startingHand();

        boolean gameFinish = false;
        while (gameFinish == false){
            //System.out.print(game.playerHand());
            //System.out.println(deck.display());
            game.gameRound();
            gameFinish = true;
        }
    }

    private static int getNoPlayers() {
        Scanner input = new Scanner(System.in);
        int noPlayers;
        System.out.println("How many players? (choose a number between 1-3)");
        noPlayers = input.nextInt();
        while ( noPlayers  <3 ||  noPlayers >5){
            System.out.println("Wrong number of players!");
            System.out.println("How many players? (choose a number between 1-3)");
            noPlayers = input.nextInt();
        }
        System.out.println("Thank you");
        return noPlayers;
    }
}

