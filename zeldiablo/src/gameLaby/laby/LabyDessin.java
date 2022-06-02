package gameLaby.laby;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;


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
        gc.setFill(Color.web("0x003333"));
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

        dessinerSortie(gc,labyrinthe);
        dessinerAmulette(gc,labyrinthe);
        dessinerMonstre(gc,labyrinthe);
        dessinerEpee(gc,labyrinthe);
        dessinerPerso(gc,labyrinthe);

        if(labyrinthe.etreFini()){
            FileInputStream ipWin = new FileInputStream("zeldiablo/images/win.png");
            Image win = new Image(ipWin);
            int x = labyrinthe.getLength();
            int y = labyrinthe.getLengthY();
            gc.drawImage(win,x*15,y*8,200,200);
        }
    }

    public void dessinerSortie(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException {
        if((!labyrinthe.pj.etrePresent(labyrinthe.sortie.getX(),labyrinthe.sortie.getY()))){
            Sortie sortie = labyrinthe.sortie;
            int sortieX = sortie.getX();
            int sortieY = sortie.getY();
            FileInputStream inputstream5 = new FileInputStream("zeldiablo/images/portail2.png");
            Image porte = new Image(inputstream5);
            gc.drawImage(porte,sortieY*30,sortieX*30,30,30);
        }
    }

    public void dessinerAmulette(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException {
        if(!labyrinthe.pj.isAmulettePossedee()) {
            Amulette amulette = labyrinthe.amulette;
            int amuletteX = amulette.getX();
            int amuletteY = amulette.getY();
            FileInputStream inputStream4 = new FileInputStream("zeldiablo/images/amulette2.png");
            Image joyaux = new Image(inputStream4);
            gc.drawImage(joyaux,amuletteY*30,amuletteX*30,30,30);
        }
    }

    public void dessinerMonstre(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException {
        for(int j=0;j<labyrinthe.monstre.size();j++){
            List<Monstre> monstre = labyrinthe.monstre;
            if(monstre.get(j).pv>0){
                if(Objects.equals(monstre.get(j).getType(), TasDeMorve.type) && !monstre.get(j).etreMort()){
                    FileInputStream inputstream2 = new FileInputStream("zeldiablo/images/monstre.gif");
                    Image mechant = new Image(inputstream2);
                    int monstreX = monstre.get(j).getX();
                    int monstreY = monstre.get(j).getY();
                    gc.drawImage(mechant, monstreY * 30, monstreX * 30, 30, 30);
                }else if(Objects.equals(monstre.get(j).getType(), Zombie.type) && !monstre.get(j).etreMort()){
                    FileInputStream inputstream8 = new FileInputStream("zeldiablo/images/zombie.png");
                    Image zombie = new Image(inputstream8);
                    int zombieX = monstre.get(j).getX();
                    int zombieY = monstre.get(j).getY();
                    gc.drawImage(zombie, zombieY * 30, zombieX * 30, 30, 30);
                }
            }
        }
    }

    public void dessinerEpee(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException{
        //si le joueur n'a pas l'inventaire plein et ne possède pas l'épée
        if((!labyrinthe.pj.inventairePlein()) && !(labyrinthe.epee.estPossede(labyrinthe.pj))) {
            Epee epee = labyrinthe.epee;
            FileInputStream inputStream7 = new FileInputStream("zeldiablo/images/epee.png");
            int epeeX = epee.x;
            int epeeY = epee.y;
            Image arme1 = new Image(inputStream7);

            gc.drawImage(arme1,epeeY*30,epeeX*30,30,30);
        }
    }

    public void dessinerPerso(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException {
        Joueur joueur = labyrinthe.pj;

        FileInputStream inputStream3 = new FileInputStream("zeldiablo/images/personnage2.png");

        Image personnage = new Image(inputStream3);
        int px = joueur.getX();
        int py = joueur.getY();
        gc.drawImage(personnage,py*30,px*30,30,30);


    }

}
