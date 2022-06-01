package gameLaby.laby;

public class TasDeMorve extends Monstre{

    public int x;
    public int y;
    public Epee epee;

    public TasDeMorve(int x, int y) {
        super(x, y);
        this.epee=null;
    }

    @Override
    public void deplacerMonstres(String action) {
    }

    @Override
    public void recupererObjet(Objet objet) {
        throw new Error("TO DO");
    }
}
