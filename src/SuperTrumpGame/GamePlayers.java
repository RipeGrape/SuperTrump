package SuperTrumpGame;
import java.util.ArrayList;

public class GamePlayers {
    private ArrayList<GameCards> cards;
    private String playerId;

    public GamePlayers(String s) {
        this.playerId = s;
    }

    public void setCards(ArrayList<GameCards> card) {
        this.cards = card;
    }

    public void addCard(GameCards card){
        cards.add(card);
    }
    public GameCards removeCard(int card){
        return cards.remove(card);
    }
    public GameCards compareCard(int card){return cards.get(card);}

    public String toString(){
        String value = playerId + ": \n";
        for(GameCards i : cards)
        {
            value += i.toString();
        }
        return value;
    }
}