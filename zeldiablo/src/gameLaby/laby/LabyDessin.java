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
        FileInputStream inputstream = new FileInputStream("zeldiablo/images/mur2.png");
        Image mur = new Image(inputstream);
        FileInputStream inputstream6 = new FileInputStream("zeldiablo/images/sol2.png");
        Image sol = new Image(inputstream6);
        for (int y = 0; y < labyrinthe.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < labyrinthe.getLength(); x++) {
                if (labyrinthe.getMur(x, y)) {
                    gc.drawImage(mur,y*30,x*30,30,30);
                } else {

                    gc.drawImage(sol,y*30,x*30,30,30);
                }
            }
        }


        //dessin amulette
        if(labyrinthe.pj.getPossedeAmulette()==false) {
            gc.setFill(Color.YELLOW);
            Amulette amulette = labyrinthe.amulette;
            int amuletteX = amulette.getX();
            int amuletteY = amulette.getY();
            FileInputStream inputStream4 = new FileInputStream("zeldiablo/images/amulette2.png");
            Image joyaux = new Image(inputStream4);
            gc.drawImage(joyaux,amuletteY*30,amuletteX*30,30,30);
        }


        //dessin monstre
        Perso monstre = labyrinthe.monstre;
        FileInputStream inputstream2 = new FileInputStream("zeldiablo/images/monstre.gif");
        Image mechant = new Image(inputstream2);
        int monstreX = monstre.getX();
        int monstreY = monstre.getY();
        gc.drawImage(mechant,monstreY*30,monstreX*30,30,30);

        //dessin sortie
        Sortie sortie = labyrinthe.sortie;
        int sortieX = sortie.getX();
        int sortieY = sortie.getY();
        FileInputStream inputstream5 = new FileInputStream("zeldiablo/images/portail2.png");
        Image porte = new Image(inputstream5);
        gc.drawImage(porte,sortieY*30,sortieX*30,30,30);

        // dessin Perso
        gc.setFill(Color.RED);
        Perso perso = labyrinthe.pj;
        FileInputStream inputStream3 = new FileInputStream("zeldiablo/images/personnage2.png");
        Image personnage = new Image(inputStream3);
        int px = perso.getX();
        int py = perso.getY();
        gc.drawImage(personnage,py*30,px*30,30,30);


    }

}
