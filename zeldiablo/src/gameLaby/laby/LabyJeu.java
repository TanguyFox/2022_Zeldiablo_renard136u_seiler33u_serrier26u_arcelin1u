package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.Random;

import static gameLaby.laby.Labyrinthe.*;

public class LabyJeu implements Jeu {

    //Labyrinthe et personnage

    private Labyrinthe laby;

    /**
     Constructeur par défaut
    */
    public LabyJeu(){
        try {
            this.laby=new Labyrinthe("zeldiablo/labySimple/laby3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(double secondes, Clavier clavier) {

        // deplace le perso en fonction des touches
        if (clavier.droite) {
            laby.deplacerPerso(DROITE);
            System.out.println("Perso :"+laby.pj.getX()+ " "+laby.pj.getY());
            laby.deplacerMonstre();
        }
        if (clavier.gauche) {
            laby.deplacerPerso(GAUCHE);
            laby.deplacerMonstre();
        }
        if (clavier.bas) {
            laby.deplacerPerso(BAS);
            laby.deplacerMonstre();
        }
        if (clavier.haut) {
            this.laby.deplacerPerso(HAUT);
            laby.deplacerMonstre();
        }


    }
    @Override
    public void init() {
    }
    @Override
    public boolean etreFini() {
        return laby.etreFini();
    }


    public Labyrinthe getLabyrinthe() {
        return this.laby;
    }



}

