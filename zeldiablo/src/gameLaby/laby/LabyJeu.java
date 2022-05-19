package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

import static gameLaby.laby.Labyrinthe.*;

public class LabyJeu implements Jeu {

    //Labyrinthe et personnage

    private Labyrinthe laby;
    private Perso perso;

    /**
     Constructeur par défaut
    */
    public LabyJeu(){
        try {
            this.laby=new Labyrinthe("zeldiablo/labySimple/laby1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.perso=new Perso(30,30);
    }
    /**
     *
     */

    public void update(double secondes, Clavier clavier) {
        // deplace le perso en fonction des touches
        if (clavier.droite) {
            this.laby.deplacerPerso(DROITE);
        }
        if (clavier.gauche) {
            this.laby.deplacerPerso(GAUCHE);
        }
        if (clavier.bas) {
            this.laby.deplacerPerso(BAS);
        }
        if (clavier.haut) {
            this.laby.deplacerPerso(HAUT);
        }

    }
    @Override
    public void init() {
    }
    @Override
    public boolean etreFini() {
        return false;
    }


    public Labyrinthe getLabyrinthe() {
        return this.laby;
    }

    public Perso getPerso() {
        return perso;
    }


}

