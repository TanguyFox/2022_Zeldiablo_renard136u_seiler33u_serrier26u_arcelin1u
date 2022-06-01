package gameLaby.laby;

import gameLaby.laby.Cancel.Perso;

public interface Objet {

    /**
     * permet de savoir si l'objet est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si l'objet est bien en (dx,dy)
     */

    public boolean etrePresent(int dx, int dy);

    // ############################################
    // GETTER ET SETTER
    // ############################################

    /**
     * @return position x de l'objet
     */
    public int getX();

    /**
     * @return position y de l'objet
     */
    public int getY();

    public void setX(int x);

    public void setY(int y);

    public boolean estPossede(Perso p);

    public Objet getObjet();

    public String toString();

}
