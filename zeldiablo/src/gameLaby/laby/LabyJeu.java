package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.Random;

import static gameLaby.laby.Labyrinthe.*;

public class LabyJeu implements Jeu {

    //Labyrinthe et personnage

    private Labyrinthe laby;
    public final String[] DEPLACEMENT_MONSTRE = {"Gauche","Droite","Haut","Bas"};

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
        Random rand = new Random();
        int i = rand.nextInt(4);
        // deplace le perso en fonction des touches
        if (clavier.droite) {
            laby.deplacerPerso(DROITE);
            laby.deplacerMonstre(DEPLACEMENT_MONSTRE[i]);
        }
        if (clavier.gauche) {
            laby.deplacerPerso(GAUCHE);
            laby.deplacerMonstre(DEPLACEMENT_MONSTRE[i]);
        }
        if (clavier.bas) {
            laby.deplacerPerso(BAS);
            laby.deplacerMonstre(DEPLACEMENT_MONSTRE[i]);
        }
        if (clavier.haut) {
            this.laby.deplacerPerso(HAUT);
            laby.deplacerMonstre(DEPLACEMENT_MONSTRE[i]);
        }
        if (laby.pj.getPossedeAmulette()==true){

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

