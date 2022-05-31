package gameLaby.laby;

/**
 * gere une sortie situe en x,y
 */

public class Sortie {

    /**
     * position de la sortie
     */
    private int x, y;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Sortie(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si la sortie est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si la sortie est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER ET SETTER
    // ############################################

    /**
     * @return position x de la sortie
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y de la sortie
     */
    public int getY() {
        //getter
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Sortie{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
