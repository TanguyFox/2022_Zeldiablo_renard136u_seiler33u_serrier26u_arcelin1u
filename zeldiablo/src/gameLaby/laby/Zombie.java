package gameLaby.laby;

public class Zombie extends Monstre{

    public int x;
    public int y;
    public int pv;
    public Epee epee;
    public static String type="zombie";

    public Zombie(int x, int y) {
        super(x,y);
        this.pv = 70;
        this.epee=null;
    }

    @Override
    public int getPv() {
        return this.pv;
    }

    public void pertePv(int degatSubis){
        this.pv -=degatSubis;
    }

    public String getType(){
        return type;
    }

    @Override
    public boolean etreMort() {
        return this.getPv()<1;
    }
}
