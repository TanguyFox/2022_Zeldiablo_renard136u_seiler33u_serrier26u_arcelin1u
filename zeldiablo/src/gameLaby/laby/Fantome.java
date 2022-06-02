package gameLaby.laby;

public class Fantome extends Monstre{

    public int x;
    public int y;
    public int pv;
    public Epee epee;

    public Fantome(int x, int y) {
        super(x, y);
        this.pv = 70;
        this.epee=null;
    }

    /**
     * A FAIRE
     *
     * @param action
     */
    @Override
    public void deplacerMonstres(String action) {
        int[] courante = {this.getX(), this.getY()};

        int[] suivante = Labyrinthe.getSuivant(courante[0], courante[1], action);

        this.setX(suivante[0]);
        this.setY(suivante[1]);
    }

    @Override
    public int getPv() {
        return this.pv;
    }


}
