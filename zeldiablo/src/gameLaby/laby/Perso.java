package gameLaby.laby;


/**
 * gere un personnage situe en x,y
 */
public class Perso {

    /**
     * position du personnage
     */
    private int x, y;

    /**
     * Si le personnage possède l'amulette alors true sinon false
     */
    private boolean possedeAmulette;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.possedeAmulette=false;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER ET SETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }

    /**
     * @return si le personnage possede l'amulette
     */

    public boolean getPossedeAmulette(){
        return this.possedeAmulette;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPossedeAmulette(boolean b){
        this.possedeAmulette = b;
    }

    @Override
    public String toString() {
        return "Perso{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
