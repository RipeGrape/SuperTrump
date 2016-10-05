package SuperTrumpGame;



public class GameCards {
    private String name;
    private double hardness;
    private double specGravity;
    private int clevage;
    private int crustAbund;
    private int ecoValue;


    public GameCards(String s, double h, double sg, int c, int ca, int ev)
    {
        this.name = s;
        this.hardness = h;
        this.specGravity = sg;
        this.clevage = c;
        this.crustAbund = ca;
        this.ecoValue = ev;
    }
    public String getName()
    {
        return name;
    }
    public double getHard()
    {
        return hardness;
    }
    public double getSpecGravity()
    {
        return specGravity;
    }
    public int getClevage()
    {
        return clevage;
    }
    public int getCrustAbund()
    {
        return crustAbund;
    }
    public int getEcoValue() { return ecoValue;}


    public String toString(){
        String msg = "";
        msg += getName() + ", Hardness: " + getHard() + " Gravity: " + getSpecGravity() + " Clevage: " + getClevage() + " Crust: " + getCrustAbund() + " Value: " + getEcoValue() + "\n";
        return msg;
    }
} //end of class GameCards
