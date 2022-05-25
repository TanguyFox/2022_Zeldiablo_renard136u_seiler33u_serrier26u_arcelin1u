package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

import static gameLaby.laby.Labyrinthe.*;

public class LabyJeu implements Jeu {

    //Labyrinthe et personnage

    private Labyrinthe laby;

    /**
     Constructeur par défaut
    */
    public LabyJeu(){
        try {
            this.laby=new Labyrinthe("zeldiablo/labySimple/laby1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(double secondes, Clavier clavier) {
        // deplace le perso en fonction des touches
        if (clavier.droite) {
            laby.deplacerPerso(DROITE);
            System.out.println("aller à droite");
        }
        if (clavier.gauche) {
            laby.deplacerPerso(GAUCHE);
            System.out.println("aller à gauche");
        }
        if (clavier.bas) {
            laby.deplacerPerso(BAS);
            System.out.println("aller en bas");
        }
        if (clavier.haut) {
            this.laby.deplacerPerso(HAUT);
            System.out.println("aller en haut");
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



}

