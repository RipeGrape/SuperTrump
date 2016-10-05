package SuperTrumpGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GamePlayers {
    private ArrayList<GameCards> cards;
    private String playerId;

    public GamePlayers(String s) {
        this.playerId = s;
    }

    public void setCards(ArrayList<GameCards> cards) {
        this.cards = cards;
    }

    public String toString(){
        String value = playerId + ": \n";
        for(GameCards i : cards)
        {
            value += i.toString();
        }

        return value;
    }
}