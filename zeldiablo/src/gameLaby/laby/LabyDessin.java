package gameLaby.laby;

import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class LabyDessin implements DessinJeu {


    /**
     * affichage d'un jeu de type arkanoid
     *
     * @param canvas dessin dans lequel dessin
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) throws FileNotFoundException {
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
                    FileInputStream inputstream = new FileInputStream("C://Users//Elève//Desktop//mur.png");
                    Image image = new Image(inputstream);
                    gc.drawImage(image,y*30,x*30,30,30);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(y*30, x*30, 30, 30);
                }
            }
        }

        // dessin Perso
        gc.setFill(Color.RED);
        Perso perso = labyrinthe.pj;
        int px = perso.getX();
        int py = perso.getY();
        gc.fillOval(py*30, px*30, 30, 30);

        //dessin monstre
        gc.setFill(Color.PURPLE);
        Perso monstre = labyrinthe.monstre;
        FileInputStream inputstream = new FileInputStream("C://Users//Elève//Desktop//monstre.gif");
        Image image = new Image(inputstream);
        int monstreX = monstre.getX();
        int monstreY = monstre.getY();
        gc.drawImage(image,monstreY*30,monstreX*30,30,30);


        //dessin amulette
        gc.setFill(Color.YELLOW);
        Amulette amulette = labyrinthe.amulette;
        int amuletteX = amulette.getX();
        int amuletteY = amulette.getY();
        gc.fillOval(amuletteY*30,amuletteX*30,30,30);


    }

}
