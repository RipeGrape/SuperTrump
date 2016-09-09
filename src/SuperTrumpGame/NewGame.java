package SuperTrumpGame;
import java.util.Random;

public class NewGame {
    private int noPlayers;

    public NewGame(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    public void selectRandDealer() {
        Random rand = new Random();
        int dealer = rand.nextInt(noPlayers) + 1;
        System.out.println("Player " +dealer);
    }
}
