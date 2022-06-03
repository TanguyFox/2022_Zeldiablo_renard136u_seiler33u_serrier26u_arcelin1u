package gameLaby.laby;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        gc.setFill(Color.web("0x52271a"));
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
        dessinerInventaire(gc,labyrinthe);
        dessinerPotion(gc,labyrinthe);
        dessinerPiege(gc,labyrinthe);

        //dessin "WIN" quand joueur fini
        if(labyrinthe.etreFini()){
            FileInputStream ipWin = new FileInputStream("zeldiablo/images/win.png");
            Image win = new Image(ipWin);
            int x = labyrinthe.getLength();
            int y = labyrinthe.getLengthY();
            gc.drawImage(win,x*13,y*8,338,43);
        }
        //dessin "LOOSE" quand joueur meurt
        if(labyrinthe.pj.etreMort()){
            FileInputStream ipLoose = new FileInputStream("zeldiablo/images/loose.png");
            Image loose = new Image(ipLoose);
            int x = labyrinthe.getLength();
            int y = labyrinthe.getLengthY();
            gc.drawImage(loose,x*10,y*8,477,87);
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
        FileInputStream inputstream2 = new FileInputStream("zeldiablo/images/monstre.gif");
        Image mechant = new Image(inputstream2);
        FileInputStream inputstream8 = new FileInputStream("zeldiablo/images/zombie.png");
        Image zombie = new Image(inputstream8);
        for(int j=0;j<labyrinthe.monstre.size();j++){
            List<Monstre> monstre = labyrinthe.monstre;
            if(!monstre.get(j).etreMort()){
                if(Objects.equals(monstre.get(j).getType(), TasDeMorve.type) && !monstre.get(j).etreMort()){
                    int monstreX = monstre.get(j).getX();
                    int monstreY = monstre.get(j).getY();
                    gc.drawImage(mechant, monstreY * 30, monstreX * 30, 30, 30);
                }else if(Objects.equals(monstre.get(j).getType(), Zombie.type) && !monstre.get(j).etreMort()){
                    int zombieX = monstre.get(j).getX();
                    int zombieY = monstre.get(j).getY();
                    gc.drawImage(zombie, zombieY * 30, zombieX * 30, 30, 30);
                }
            }
        }
    }

    public void dessinerEpee(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException{
        FileInputStream inputStream7 = new FileInputStream("zeldiablo/images/epee.png");
        Image arme1 = new Image(inputStream7);
        //si le joueur n'a pas l'inventaire plein et ne possède pas l'épée
        if((!labyrinthe.pj.inventairePlein()) && !(labyrinthe.epee.estPossede(labyrinthe.pj))) {
            Epee epee = labyrinthe.epee;
            int epeeX = epee.x;
            int epeeY = epee.y;
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

    public void dessinerPotion(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException{
        FileInputStream inputStream = new FileInputStream("zeldiablo/images/potion.png");
        Image potion = new Image(inputStream);
        if(!labyrinthe.potion.aSoigner){
            int px = labyrinthe.potion.getX();
            int py = labyrinthe.potion.getY();
            gc.drawImage(potion,py*30,px*30,30,30);
        }
    }

    public void dessinerPiege(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException{
        FileInputStream inputstream8 = new FileInputStream("zeldiablo/images/piege.png");
        Image trap = new Image(inputstream8);
        for(int j=0;j<labyrinthe.pieges.size();j++) {
            List<Piege> pieges = labyrinthe.pieges;
            if (!pieges.get(j).isExplose()) {
                int piegeX = pieges.get(j).getX();
                int piegeY = pieges.get(j).getY();
                gc.drawImage(trap, piegeY * 30, piegeX * 30, 30, 30);
            }
        }
    }


    public void dessinerInventaire(GraphicsContext gc, Labyrinthe labyrinthe) throws FileNotFoundException {
        //dessin de l'inventaire vide
        FileInputStream inputStream = new FileInputStream("zeldiablo/images/caseInv.png");
        Image caseInv = new Image(inputStream);
        int TAILLE_CASE = 162;
        for(int i = 0;i<5;i++){
            gc.drawImage(caseInv,i*(TAILLE_CASE),600,100,100);
        }
        //dessin des objets dans l'inventaire
        FileInputStream inputStream7 = new FileInputStream("zeldiablo/images/epee.png");
        Image epee = new Image(inputStream7);
        FileInputStream inputStream4 = new FileInputStream("zeldiablo/images/amulette2.png");
        Image amulette = new Image(inputStream4);
        if(labyrinthe.pj.inventaire.size()>0){
            for(int i=0; i<labyrinthe.pj.inventaire.size();i++){
                if(labyrinthe.pj.inventaire.get(i).getType().equals("epee")){
                    gc.drawImage(epee,i*(TAILLE_CASE),600,100,100);
                }
                if(labyrinthe.pj.inventaire.get(i).getType().equals("amulette")){
                    gc.drawImage(amulette,i*(TAILLE_CASE),600,100,100);
                }
            }
        }
    }

}
