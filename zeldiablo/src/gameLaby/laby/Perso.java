package gameLaby.laby;


import java.util.ArrayList;
import java.util.List;

/**
 * gere un personnage situe en x,y
 */
public class Perso {

    /**
     * position du personnage
     */
    private int x, y;
    private List<Objet> inventaire;

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
        this.inventaire = new ArrayList<>();
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

    public List<Objet> getInventaire() {
        return inventaire;
    }

    /**
     * @return si le personnage possede l'amulette
     */

    public boolean isAmulettePossedee(){
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

    public boolean inventairePlein(){
        boolean plein = false;
        if(inventaire.size()==5){
            return true;
        }
        return plein;
    }

    public void recupererObjet(Objet objet){
        if(!inventairePlein()){
            inventaire.add(objet);
            this.setPossedeAmulette(true);
        }else{
            System.out.println("Inventaire plein !");
        }
    }

    @Override
    public String toString() {
        return "Perso{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
