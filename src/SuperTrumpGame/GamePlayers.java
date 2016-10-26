package SuperTrumpGame;
import javax.swing.*;
import java.util.ArrayList;

public class GamePlayers extends JPanel{
    private ArrayList<GameCards> cards;
    private String playerId;

    public GamePlayers(String s) {
        this.playerId = s;

    }

    public void setCards(ArrayList<GameCards> card) {
        this.cards = card;
    }

    public String getPlayerId(){return playerId;}
    public void addCard(GameCards card){
        cards.add(card);
    }
    public GameCards removeCard(int card){
        return cards.remove(card);
    }
    public GameCards compareCard(int card){return cards.get(card);}
    public boolean containsMag() {return cards.contains("Magnetite");}
    public void winningCombo(){cards.clear();}
    public boolean isEmpty(){
        if(cards.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public int handSize(){return cards.size();}

    public String[] cardPaths(){
        String[] paths = new String[cards.size()];
        for(int i = 0; i < cards.size(); i++)
        {
            paths[i] = cards.get(i).cardPath();
        }
        return paths;
    }

    public String toString(){
        String value = playerId + ": \n";
        if (cards == null) return value;

        for(GameCards i : cards)
        {
            value += i.toString();
        }
        return value;
    }



}