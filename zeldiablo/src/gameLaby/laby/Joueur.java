package gameLaby.laby;

import java.util.ArrayList;
import java.util.List;

public class Joueur implements Personnage{

    public int x;
    public int y;
    public List<Objet> inventaire;
    public boolean possedeAmulette;

    public Joueur(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.inventaire = new ArrayList<>();
        this.possedeAmulette=false;
    }

    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    public boolean inventairePlein(){
        boolean plein = false;
        if(inventaire.size()>=5){
            return true;
        }
        return plein;
    }

    @Override
    public void recupererObjet(Objet objet) {
        if (this.etrePresent(objet.getX(), objet.getY())){
            if (!inventairePlein()) {
                inventaire.add(objet);
                this.setPossedeAmulette(true);
                System.out.println("Vous avez récupérez l'amulette !");
            } else {
                System.out.println("Inventaire plein !");
            }
        }
    }

    public List<Objet> getInventaire() {
        return inventaire;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

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

    /**
     * A FAIRE
     * @param epee
     */
    @Override
    public void attaquer(Epee epee) {
        throw new Error("TO DO");
    }

    /**
     * A FAIRE
     * @param degatSubis
     */
    @Override
    public void pertePv(int degatSubis) {
        throw new Error("TO DO");
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "x=" + x +
                ", y=" + y +
                ", inventaire=" + inventaire +
                ", possedeAmulette=" + possedeAmulette +
                '}';
    }
}
