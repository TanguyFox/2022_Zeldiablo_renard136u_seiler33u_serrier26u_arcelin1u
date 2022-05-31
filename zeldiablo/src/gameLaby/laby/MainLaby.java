package gameLaby.laby;

import gameArkanoid.ArkanoidDessin;
import gameArkanoid.ArkanoidJeu;
import moteurJeu.MoteurJeu;

public class MainLaby {

    public static void main(String[] args) {
        int width = 810;
        int height = 618;
<<<<<<< HEAD
        int pFPS = 5;
=======
        int pFPS = 60;
>>>>>>> a12e87fa928e950824d3cc2c07cb44ed4ab3e85c

        // creation des objets
        LabyJeu jeuLaby = new LabyJeu();
        LabyDessin dessinLaby = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeuLaby, dessinLaby);
    }
}
