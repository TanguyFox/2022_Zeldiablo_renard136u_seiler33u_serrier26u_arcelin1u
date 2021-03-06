package gameLaby.laby;

public class Epee implements Objet {

    /**
     * attribut degat de l'arme
     */
    public int degat;
    public int x;
    public int y;
    public static String type = "epee";

    /**
     * Constructeur
     * @param dx coordonnée en ordonnée
     * @param dy coordonnée en abscisse
     * @param degat degats inflige pas l'epee
     */
    public Epee(int dx, int dy, int degat){
        this.x=dx;
        this.y=dy;
        this.degat=degat;
    }

    /**
     * permet de savoir si l'objet est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si l'objet est bien en (dx,dy)
     */
    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    /**
     * @return position x de l'objet
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return position y de l'objet
     */
    @Override
    public int getY() {
        return y;
    }

    public int getDegat(){return this.degat;}

    @Override
    public void setX(int x) {
        this.x=x;
    }

    @Override
    public void setY(int y) {
        this.y=y;
    }

    @Override
    public boolean estPossede(Joueur p) {
        return p.getInventaire().contains(this);
    }

    @Override
    public Objet getObjet() {
        return this;
    }

    @Override
    public String toString() {
        return "Epee{" +
                "degat=" + degat +
                '}';
    }

    @Override
    public String getType() {
        return "epee";
    }

    /**
     * a faire
     */
    public void faireDegats(Personnage cible) {

        if (cible.getPv() < 20) {
            cible.pertePv(cible.getPv());
        } else {
            cible.pertePv(this.degat);
        }
    }
}
