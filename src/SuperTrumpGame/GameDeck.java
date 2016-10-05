package SuperTrumpGame;

import java.util.*;
import java.util.Random;

public class GameDeck {
    private static final int NUM_DECK_INIT = 12;
    private Random rand = new Random();
    private int cardsDrawn = 0;
    public ArrayList<GameCards> card;
    private ArrayList<GamePlayers> players;
    //NONE = 1;
    //POOR_NONE = 2;
    //ONE_POOR = 3;
    //TWO_POOR = 4;
    //ONE_GOOD = 5;
    //ONE_GOOD_ONE_POOR = 6;
    //TWO_GOOD = 7;
    //THREE_GOOD = 8;
    //ONE_PERFECT = 9;
    //ONE_PERFECT_ONE_GOOD = 10;
    //ONE_PERFECT_TWO_GOOD = 11;
    //TWO_PERFECT_ONE_GOOD = 12;
    //THREE_PERFECT = 13;
    //FOUR_PERFECT = 14;
    //SIX_PERFECT = 15

    //ULTRATRACE = 1;
    //TRACE = 2;
    //LOW = 3;
    //MODERATE = 4;
    //HIGH = 5;
    //VERY_HIGH = 6;

    //TRIVAL = 1;
    //LOW = 2;
    //MODERATE = 3;
    //HIGH = 4;
    //VERY_HIGH = 5;
    //IM_RICH = 6;


    public GameDeck() {
        card = new ArrayList<GameCards>();
            card.add(new GameCards("Quartz", 7, 2.65, 2, 5, 3)); // card 1
            card.add(new GameCards("Plagioclase", 6.5, 2.8, 10, 5, 3)); // card 2
            card.add(new GameCards("Orthoclase", 6.5, 2.6, 10, 5, 3)); // card 3
            card.add(new GameCards("Biotite", 3, 3.3, 9, 4, 2)); // card 4
            card.add(new GameCards("Muscovite", 3, 2.9, 9, 4, 3)); // card 5
            card.add(new GameCards("Hornblende", 6, 3.5, 7, 4, 1)); // card 6
            card.add(new GameCards("Actinolite", 6, 3.5, 7, 3, 2)); // card 7
            card.add(new GameCards("Glaucophane", 6, 3.2, 7, 3, 1)); // card 8
            card.add(new GameCards("Olivine", 7, 4.4, 4, 5, 2)); // card 9
            card.add(new GameCards("Garnet", 7.5, 4.3, 1, 4, 3)); // card 10
            card.add(new GameCards("Titanite", 5.5, 3.6, 8, 3, 2)); // card 11
            card.add(new GameCards("Zircon", 7.5, 4.7, 4, 2, 3)); // card 12
    }

    public ArrayList<GameCards> shuffle(){
        // Shuffles the deck
        Collections.shuffle(card);
        return card;
        /*for (int i = NUM_DECK_INIT - 1; i > 0; i--) {
            int randCard = rand.nextInt(i);
            GameCards first = card.get(randCard);
            GameCards second = card.get(i);
            card.set(i, first);
            card.set(randCard, second);
        }*/
    }

    public ArrayList<GameCards> getCard(int noCards) {
        ArrayList<GameCards> hand = new ArrayList<GameCards>();
        for (int i = 0; i < noCards; i++) {
            GameCards dealCards = card.remove(i);
            hand.add(dealCards);
        }
        return hand;
    }

    public GameCards drawCards() {
        return card.remove(0);

//        return card.get(0);
        /* GameCards draw = card.remove(cardsDrawn);
        card.add(draw);
        cardsDrawn++;
        return cardsDrawn;*/
    }

    /*    public int cardsLeft(){
            return card.length - cardsUsed;
        }

    public void addExtraCard(GameCards cards){
        for (int i = 0; i < NUM_DECK_INIT; i++) {
            if (cards != null){
                card.get(i) = cards;
            }
        }
    }
    public GameCards dealCards(){
        if (cardsUsed == card.length) {
            throw new IllegalStateException("Deck is empty.");
        }
        cardsUsed++;
        return card[cardsUsed - 1];
    }
    public void startingHand(){
        int STARTING_HAND = 2;
        for (int i = 0; i < STARTING_HAND; i++) {
            for (int j = 0; j < players.size(); j++) {
                add();
            }
        }
    }

    public void add(){
        for (int i = 0; i < NUM_DECK_INIT; i++) {
            for (GameCards c : card) {
                card[i] = c;
            }
        }

    }*/

    //The test to see if the list would print and random
    /*public String display() {
        String msg = "";
        for (GameCards c : card) {
            msg += c.toString();
        }
        return msg;
    }*/

} //end of class GameDeck


//    public ArrayList<GameCards> dealCards(int i) {
//        return null;
//    }



