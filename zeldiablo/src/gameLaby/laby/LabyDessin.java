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

        for (int x = 0; x < labyrinthe.getLength(); x++) {
            // affiche la ligne
            for (int y = 0; y < labyrinthe.getLengthY(); y++) {
                if (labyrinthe.getMur(x, y)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x*30,y*30,30, 30);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x*30, y*30, 30, 30);
                }
            }
        }

        // dessin Perso
        gc.setFill(Color.RED);
        Perso perso = labyrinthe.pj;
        int px = perso.getX();
        System.out.println("px : "+px);
        int py = perso.getY();
        System.out.println("py : "+py);
        gc.fillOval(py*30, px*30, 30, 30);

        System.out.println(px);
        System.out.println(py);


    }

}
