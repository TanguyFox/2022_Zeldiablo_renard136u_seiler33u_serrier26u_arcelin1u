package gameLaby.laby;

public class TasDeMorve extends Monstre{

    public int x;
    public int y;
    public Epee epee;

    public TasDeMorve(int x, int y) {
        super(x, y);
        this.pv = 40;
        this.epee=null;
    }

    @Override
    public void deplacerMonstres(String action) {
    }

    @Override
    public int getPv() {
        return this.pv;
    }
}
