package gameLaby.laby;


public interface Objet {

    /**
     * permet de savoir si l'objet est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si l'objet est bien en (dx,dy)
     */

    boolean etrePresent(int dx, int dy);

    // ############################################
    // GETTER ET SETTER
    // ############################################

    /**
     * @return position x de l'objet
     */
    int getX();

    /**
     * @return position y de l'objet
     */
    int getY();

    void setX(int x);

    void setY(int y);

    boolean estPossede(Joueur p);

    Objet getObjet();

    String toString();

    String getType();

}
