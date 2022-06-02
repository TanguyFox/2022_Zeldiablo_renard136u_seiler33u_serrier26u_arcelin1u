package gameLaby.laby;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Joueur implements Personnage{

    public int x;
    public int y;
    public List<Objet> inventaire;
    public boolean possedeAmulette;
    public Epee epee;
    public int pv;
    public boolean possedeEpee;

    public Joueur(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.inventaire = new ArrayList<>();
        this.possedeAmulette=false;
        this.pv=100;
        this.epee = null;
        this.possedeEpee = false;
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

    public void recupererObjet(Objet objet) {
        if (this.etrePresent(objet.getX(), objet.getY())){
            if (!inventairePlein()) {
                if(Objects.equals(objet.getType(), "amulette")){
                    this.setPossedeAmulette(true);
                }else if(Objects.equals(objet.getType(), "epee")){
                    this.setPossedeEpee(true);
                    this.epee = (Epee) objet;
                }
                inventaire.add(objet);;
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

    public int getPv(){return this.pv;}

    public boolean isAmulettePossedee(){
        return this.possedeAmulette;
    }

    public boolean isEpeePossedee(){
        return this.possedeEpee;
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

    public void setPossedeEpee(boolean b){
        this.possedeEpee = b;
    }

    public void attaquer(Monstre cible) {
        if(this.etrePresent(cible.getX(),cible.getY())) {
            if(this.isEpeePossedee()){
                this.epee.faireDegats(cible);
            }else{
                cible.pertePv(2);
            }
            System.out.println("Vie du monstre : "+cible.getPv());
        }
    }

    /**
     * @param degatSubis
     */
    @Override
    public void pertePv(int degatSubis) {
        this.pv-=degatSubis;
    }

    @Override
    public boolean etreMort() {
        return this.getPv() < 1;
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
