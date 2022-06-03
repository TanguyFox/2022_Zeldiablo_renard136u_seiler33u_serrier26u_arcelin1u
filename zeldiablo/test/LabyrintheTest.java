import gameLaby.laby.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

class LabyrintheTest {

    //marche pas
    @Test
    public void test_attaquer() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/labySimple/laby0.txt");
        Joueur j = labyrinthe.pj;
        TasDeMorve tasDeMorve = (TasDeMorve) labyrinthe.monstre.get(0);
        Epee e = new Epee(j.x,j.y,20);
        j.recupererObjet(e);

        System.out.println(j.getInventaire().get(0));
        j.setX(tasDeMorve.getX());
        j.setY(tasDeMorve.getY());

        j.attaquer(tasDeMorve);

        assertEquals(20,tasDeMorve.pv);
    }

    @Test
    public void test_pertePv() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/labySimple/laby0.txt");
        Joueur j = labyrinthe.pj;

        j.pertePv(50);

        assertEquals(50,j.pv);
    }

    @Test
    public void test_etreMort() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/labySimple/laby0.txt");
        Joueur j = labyrinthe.pj;

        j.pertePv(j.pv);

        assertTrue(j.etreMort());
    }


    //marche pas mdr
    @Test
    public void test_faireDegat() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/labySimple/laby0.txt");
        Joueur j = labyrinthe.pj;
        Monstre z = labyrinthe.monstre.get(1);
        Epee e = labyrinthe.getEpee();

        j.setX(e.getX());
        j.setY(e.getY());
        j.recupererObjet(e);

        System.out.println(z.getPv());
        System.out.println(e.getDegat());

        e.faireDegats(z);

        assertEquals(50,z.getPv());
    }




}