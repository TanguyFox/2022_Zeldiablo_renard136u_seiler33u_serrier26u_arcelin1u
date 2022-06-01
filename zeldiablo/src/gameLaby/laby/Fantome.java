package gameLaby.laby;

public class Fantome extends Monstre{

    public int x;
    public int y;
    public Epee epee;

    public Fantome(int x, int y) {
        super(x, y);
        this.epee=null;
    }

    /**
     * A FAIRE
     *
     * @param action
     */
    @Override
    public void deplacerMonstres(String action) {
        throw new Error("TO DO");
    }

    @Override
    public void recupererObjet(Objet objet) {
        throw new Error("TO DO");
    }
}
