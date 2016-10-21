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
    JButton startGame = new JButton( "Start Game" );
    JButton instructions = new JButton( "Instructions" );

    public static void main(String[] args){
        SuperTrump cframe = new SuperTrump();
        cframe.setSize(350, 240);
        cframe.setVisible(true);
        cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("Shuffled deck \n");
        //playGame.addActionListener(frame);
        //.add(playGame);

    }

    public SuperTrump() {
        super("Super Trump Game");
        setSize(300,200);
        setLayout(new FlowLayout());
        add(startGame);
        add(instructions);
        startGame.addActionListener(this);
    }

    private static void playGame() {
        int noPlayers = getNoPlayers();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == startGame) {
            startGame.setEnabled(false);
            playGame();
        }
    }
}

