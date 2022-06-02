package gameLaby.laby;


public class Amulette implements Objet{

    /**
     * position de l'amulette
     */

    private int x,y;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */

    public Amulette(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si l'amulette est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si l'amulette est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }


    // ############################################
    // GETTER ET SETTER
    // ############################################

    /**
     * @return position x de l'amulette
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return position y de l'amulette
     */
    @Override
    public int getY() {
        return y;
    }

    @Override
    public Objet getObjet() {
        return this;
    }

    @Override
    public String getType() {
        return "amulette";
    }

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
}
