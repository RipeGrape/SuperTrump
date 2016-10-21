package SuperTrumpGame;

import java.io.IOException;
import java.util.*;
import java.util.Random;

public class GameDeck {
    private static final int NUM_DECK_INIT = 12;
    private Random rand = new Random();
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
            card.add(new GameCards("Quartz", 7, 2.65, 2, 5, 3, false)); // card 1
            card.add(new GameCards("Plagioclase", 6.5, 2.8, 10, 5, 3, false)); // card 2
            card.add(new GameCards("Orthoclase", 6.5, 2.6, 10, 5, 3, false)); // card 3
            card.add(new GameCards("Biotite", 3, 3.3, 9, 4, 2, false)); // card 4
            card.add(new GameCards("Muscovite", 3, 2.9, 9, 4, 3, false)); // card 5
            card.add(new GameCards("Hornblende", 6, 3.5, 7, 4, 1, false)); // card 6
            card.add(new GameCards("Actinolite", 6, 3.5, 7, 3, 2, false)); // card 7
            card.add(new GameCards("Glaucophane", 6, 3.2, 7, 3, 1, false)); // card 8
            card.add(new GameCards("Olivine", 7, 4.4, 4, 5, 2, false)); // card 9
            card.add(new GameCards("Garnet", 7.5, 4.3, 1, 4, 3, false)); // card 10
            card.add(new GameCards("Titanite", 5.5, 3.6, 8, 3, 2, false)); // card 11
            card.add(new GameCards("Zircon", 7.5, 4.7, 4, 2, 3, false)); // card 12
            card.add(new GameCards("Augite", 6.5, 3.6, 7, 5, 1, false));// card 13
            card.add(new GameCards("Orthopyroxene", 6, 3.9, 7, 5, 1, false));// card 14
            card.add(new GameCards("Chlorite",3, 3.3 , 9, 4, 2, false));// card 15
            card.add(new GameCards("Antigorite", 4, 2.6, 9, 3, 2, false));// card 16
            card.add(new GameCards("Talc", 1, 2.8, 9, 3, 3, false));// card 17
            card.add(new GameCards("Kaolinite", 2.5, 2.7, 9, 4, 4, false));// card 18
            card.add(new GameCards("Andalusite", 7, 3.15, 7, 3, 3, false));// card 19
            card.add(new GameCards("Kyanite", 7, 3.7, 10, 2, 3, false));// card 20
            card.add(new GameCards("Sillimanite", 7.5, 3.25, 10, 3, 2, false));// card 21
            card.add(new GameCards("Staurolite", 7, 3.8, 5, 2, 2, false));// card 22
            card.add(new GameCards("Epidote", 6.5, 3.5, 9, 4, 1, false));// card 23
            card.add(new GameCards("Tourmaline", 7.5, 3.2, 4, 2, 3, false));// card 24
            card.add(new GameCards("Topaz", 8, 3.6, 9, 1, 2, false));// card 25
            card.add(new GameCards("Beryl", 8, 2.9, 3, 2, 3, false));// card 26
            card.add(new GameCards("Pyrite", 6.5, 5, 4, 3, 3, false));// card 27
            card.add(new GameCards("Pyrrhotite", 4.5, 4.6, 1, 3, 3, false));// card 28
            card.add(new GameCards("Chalcopyrite", 4, 4.3, 4, 3, 5, false));// card 29
            card.add(new GameCards("Galena", 2.5, 7.6, 13, 2, 4, false));// card 30
            card.add(new GameCards("Sphalerite", 4, 4.1, 15, 2, 4, false));// card 31
            card.add(new GameCards("Molybdenite", 1.5, 4.7, 9, 2, 4, false));// card 32
            card.add(new GameCards("Gold", 3, 19.3, 1, 1, 6, false));// card 33
            card.add(new GameCards("Diamond", 10, 3.5, 14, 1, 6, false));// card 34
            card.add(new GameCards("Graphite", 2, 2.2, 9, 2, 3, false));// card 35
            card.add(new GameCards("Halite", 2.5, 2.2, 13, 2, 3, false));// card 36
            card.add(new GameCards("Fluorite", 4, 3.2, 14, 2, 3, false));// card 37
            card.add(new GameCards("Gypsum", 2, 2.3, 11, 21, 4, false));// card 38
            card.add(new GameCards("Barite", 3.5, 4.5, 12, 2, 3, false));// card 39
            card.add(new GameCards("Apatite", 5, 3.2, 4, 3, 4, false));// card 40
            card.add(new GameCards("Monazite", 5, 5.3, 6, 2, 3, false));// card 41
            card.add(new GameCards("Calcite", 3, 2.7, 13, 4, 4, false));// card 42
            card.add(new GameCards("Dolomite", 4, 2.9, 13, 2, 2, false));// card 43
            card.add(new GameCards("Magnesite", 4, 3.0, 13, 2, 3, false));// card 44
            card.add(new GameCards("Siderite", 4.5, 4, 13, 2, 3, false));// card 45
            card.add(new GameCards("Magnetite", 6, 5.2, 1, 4, 5, false)); // card 46
            card.add(new GameCards("Hematite", 6, 5.3, 1, 2, 4, false));// card 47
            card.add(new GameCards("Chromite", 5.5, 5.1, 1, 2, 4, false));// card 48
            card.add(new GameCards("Ilmenite", 6, 4.8, 1, 3, 3, false));// card 49
            card.add(new GameCards("Rutile", 3.5, 43, 7, 3, 4, false));// card 50
            card.add(new GameCards("Corundum", 9, 4.0, 1, 2, 4, false));// card 51
            card.add(new GameCards("Cassiterite", 7, 7.1, 6, 2, 4, false));// card 52
            card.add(new GameCards("Gibbsite", 3.5, 2.4, 9, 3, 4,  false));// card 53
            card.add(new GameCards("Goethite", 5.5 , 4.3, 10, 4, 3, false));// card 54
            card.add(new GameCards("The Miner", 0, 0, 0, 0, 0, true));// card 55
            card.add(new GameCards("The Petrologist", 0, 0, 0, 0, 0, true));// card 56
            card.add(new GameCards("The Gemmologist", 0, 0, 0, 0, 0, true));// card 57
            card.add(new GameCards("The Mineralogist", 0, 0, 0, 0, 0, true));// card 58
            card.add(new GameCards("The Geophysicist", 0, 0, 0, 0, 0, true));// card 59
            card.add(new GameCards("The Geologist", 0, 0, 0, 0, 0, true));// card 60
    }

    public void shuffle(){
        // Shuffles the deck
        Collections.shuffle(card);
    }

    public ArrayList<GameCards> getCard(int noCards) {
        ArrayList<GameCards> hand = new ArrayList<GameCards>();
        for (int i = 0; i < noCards; i++) {
            hand.add(card.remove(i));
        }
        return hand;
    }

    public GameCards drawCards() {
        return card.remove(0);
    }
} //end of class GameDeck



