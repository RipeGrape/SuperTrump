package SuperTrumpGame;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
	    startGame();


    }

    private static void menu() {
        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        System.out.println("3. Exit Game");
    }

    private static void startGame() {
        int noPlayers = getNoPlayers();
        NewGame game = new NewGame(noPlayers);
        game.selectRandDealer();
//        game.dealCards();
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

