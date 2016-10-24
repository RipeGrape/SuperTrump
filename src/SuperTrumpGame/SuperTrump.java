package SuperTrumpGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SuperTrump extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JPanel players = new JPanel();
    JButton startGame = new JButton( "Start Game" );
    JButton instructions = new JButton( "Instructions" );
    JButton threePlayers = new JButton( "3 PLAYERS" );
    JButton fourPlayers = new JButton( "4 PLAYERS" );
    JButton fivePlayers = new JButton( "5 PLAYERS" );
    int noPlayers = 0;

    public static void main(String[] args){
        JFrame cframe = new SuperTrump();
        cframe.setSize(1000, 700);
        cframe.setVisible(true);
        cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.out.println("Shuffled deck \n");
    }

    public SuperTrump() {
        super("Super Trump Game");
        setSize(1000,700);
        setLayout(new FlowLayout());
        add(startGame, BorderLayout.NORTH);
        add(instructions, BorderLayout.NORTH);
        add(players, BorderLayout.CENTER);
        players.setVisible(false);
        startGame.addActionListener(this);
    }

   private void playGame() {
        Game game = new Game(noPlayers);
        game.deck.shuffle();
        int dealer = game.selectRandDealer();
        game.getSelectedPlayers(noPlayers);
        game.startingHand();
        //boolean[] winners = new boolean[noPlayers];
        boolean gameFinish = false;
        boolean gameCompleteCheck = false;


        while (gameFinish == false){
            int startingPlayer = dealer;
            dealer = game.gameRound(startingPlayer);
            gameCompleteCheck = game.loser();
            if(gameCompleteCheck) {
                gameFinish = true;
            }
        }
    }

    private void getNoPlayers() {
        JLabel titleOfPlayer = new JLabel("How many players?");
        players.setVisible(true);
        players.add(threePlayers);
        players.add(fourPlayers);
        players.add(fivePlayers);
        threePlayers.addActionListener(this);
        fourPlayers.addActionListener(this);
        fivePlayers.addActionListener(this);
        /*while ( noPlayers  <3 ||  noPlayers >5){
            System.out.println("Wrong number of players!");
            System.out.println("How many players? (choose a number between 1-3)");

        }*/
        //System.out.println("Thank you");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == startGame) {
            startGame.setEnabled(false);
            getNoPlayers();
        }
        else if (source == threePlayers) {
            noPlayers =3;
            players.setVisible(false);
            playGame();
        }
        else if (source == fourPlayers) {
            noPlayers =4;
            players.setVisible(false);
            playGame();
        }
        else if (source == fivePlayers) {
            noPlayers = 5;
            players.setVisible(false);
            playGame();
        }
    }
}

