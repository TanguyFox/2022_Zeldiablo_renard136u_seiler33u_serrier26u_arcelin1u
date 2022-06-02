package gameLaby.laby;

public abstract class Monstre implements Personnage{

    public int x;
    public int y;
    public int pv;
    public Epee epee;

    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
        this.epee = new Epee(x,y,10);
        this.pv = 100;
    }

    /**
     * A FAIRE
     * @param action
     */
    public abstract void deplacerMonstres(String action);

    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }


    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * A FAIRE
     * Ca fonctionne peut etre
     */
    public void attaquer(Joueur cible) {
        if(this.etrePresent(cible.x,cible.y)){
            cible.pertePv(epee.degat);
        }
    }

    /**
     * A FAIRE
     * @param degatSubis
     */
    @Override
    public void pertePv(int degatSubis) {
        this.pv -=degatSubis;
    }

    @Override
    public String toString() {
        return "Monstre{" +
                "x=" + x +
                ", y=" + y +
                ", epee=" + epee +
                '}';
    }

    /**
     *     public void deplacerMonstre(String action) {
     *         // case courante
     *         int[] courante = {this.monstre.getX(), this.monstre.getY()};
     *
     *         // calcule case suivante
     *         int[] suivante = getSuivant(courante[0], courante[1], action);
     *
     *         // si c'est pas un mur, on effectue le deplacement
     *
     *         if (!this.murs[suivante[0]][suivante[1]] && !etreFini()) {
     *
     *             if ((!this.murs[suivante[0]][suivante[1]]) && (!etreFini())) {
     *
     *                 // si c'est un monstre, on reste aux mêmes coordonnées
     *                 if (suivante[0] == pj.getX() && suivante[1] == pj.getY()) {
     *                     System.out.println("Le Monstre attaque !");
     *                 } else {
     *                     // on met a jour personnage
     *                     this.monstre.setX(suivante[0]);
     *                     this.monstre.setY(suivante[1]);
     *                 }
     *             }
     *         }
     *     }
     */
}
