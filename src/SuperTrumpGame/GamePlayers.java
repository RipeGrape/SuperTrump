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

    public void playersHand(){
        ImageIcon image;
        JLabel label;
        for(GameCards i : cards) {
            image = new ImageIcon(i.cardPath());
            label = new JLabel(image);
            add(label);
        }
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