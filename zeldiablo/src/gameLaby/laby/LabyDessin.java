package gameLaby.laby;

import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {


    /**
     * affichage d'un jeu de type arkanoid
     *
     * @param canvas dessin dans lequel dessin
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu labyJeu = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // dessin laby
        Labyrinthe labyrinthe = labyJeu.getLabyrinthe();

        for (int y = 0; y < labyrinthe.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < labyrinthe.getLength(); x++) {
                if (labyrinthe.getMur(x, y)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(y*30,x*30,30, 30);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(y*30, x*30, 30, 30);
                }
            }
        }


        // dessin Perso
        gc.setFill(Color.RED);
        Perso perso = labyJeu.getPerso();
        double px = perso.getX();
        double py = perso.getY();
        gc.fillOval(px, py, 20, 20);


    }

}
