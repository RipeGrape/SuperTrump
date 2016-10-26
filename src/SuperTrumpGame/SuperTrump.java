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

public class SuperTrump extends JFrame{
    static JFrame cframe = new JFrame();
    static JFrame gamePane = new JFrame();
    JPanel numOfPlayers = new JPanel();



    public static void main(String[] args){
        cframe = new Game();
        cframe.setSize(1200, 1000);
        cframe.setVisible(true);
        cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*gamePane = new Game();
        gamePane.setVisible(false);
        gamePane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.out.println("Shuffled deck \n");*/
    }


    /*private void playGame() {
        *//*cframe = new Game(noPlayers);
        cframe.setVisible(true);*//*
        Game game = new Game(noPlayers);
        game.deck.shuffle();
        int dealer = game.selectRandDealer(noPlayers);
        game.getSelectedPlayers();
        game.startingHand();
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
        //This bring up the players choice of the number of players
        JLabel titleOfPlayer = new JLabel("How many players?");
        add(titleOfPlayer);
        add(numOfPlayers);
        numOfPlayers.setVisible(true);
        numOfPlayers.add(threePlayers);
        numOfPlayers.add(fourPlayers);
        numOfPlayers.add(fivePlayers);
        threePlayers.addActionListener(this);
        fourPlayers.addActionListener(this);
        fivePlayers.addActionListener(this);
        *//*while ( noPlayers  <3 ||  noPlayers >5){
            System.out.println("Wrong number of players!");
            System.out.println("How many players? (choose a number between 1-3)");

        }
    }*/

    /*@Override
    public void actionPerformed(ActionEvent e) {
        //The action if that button is pressed
        Object source = e.getSource();
        if (source == startGame) { //Start Game Button
            startGame.setEnabled(false);
            getNoPlayers();
        }
        else if (source == threePlayers) { // 3 players button
            noPlayers =3;
            numOfPlayers.removeAll();
            playGame();
        }
        else if (source == fourPlayers) { //4 players button
            noPlayers =4;
            numOfPlayers.removeAll();
            playGame();
        }
        else if (source == fivePlayers) { //5 players button
            noPlayers = 5;
            numOfPlayers.removeAll();
            playGame();
        }*/
}


