package SuperTrumpGame;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameCards extends JFrame {
    private String name;
    private double hardness;
    private double specGravity;
    private int clevage;
    private int crustAbund;
    private int ecoValue;
    private boolean trump;
    //private BufferedImage image;

    public GameCards(String s, double h, double sg, int c, int ca, int ev, boolean t) {//throws IOException {
        this.name = s;
        this.hardness = h;
        this.specGravity = sg;
        this.clevage = c;
        this.crustAbund = ca;
        this.ecoValue = ev;
        this.trump = t;
    }

    public String getName() {
        return name;
    }

    public double getHard() {
        return hardness;
    }

    public double getSpecGravity() {
        return specGravity;
    }

    public int getClevage() {
        return clevage;
    }

    public int getCrustAbund() {
        return crustAbund;
    }

    public int getEcoValue() {
        return ecoValue;
    }

    public boolean getTrump() {
        return trump;
    }

    /*
        public BufferedImage getImage() {
            return image;
        }*/
    public String cardPath() {
        return /*"E:\\cp2406 Programming II\\ColbranKaineA1\\images\\"+*/getName()+".jpg";

    }

    public String toString(){
        String msg = "";
        msg += getName() + ", Hardness: " + getHard() + " Gravity: " + getSpecGravity() + " Clevage: " + getClevage() + " Crust: " + getCrustAbund() + " Value: " + getEcoValue() + "\n";
        return msg;
    }


} //end of class GameCards
