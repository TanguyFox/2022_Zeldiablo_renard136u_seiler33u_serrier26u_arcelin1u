import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class LabyrintheTest {

    @Test
    void deplacerMonstre() {
        throw new Error("TO DO");
    }

    @Test
    void getMonstre() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        Perso m = laby.getMonstre();
        int mx = m.getX();
        int my = m.getY();

        assertEquals(1,mx);
        assertEquals(1,my);
    }

    @Test
    void test_deplacerPersoGauche() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        laby.deplacerPerso(Labyrinthe.GAUCHE);
        Perso p = laby.getPj();

        assertEquals(2,p.getX());
        assertEquals(2,p.getY());
    }

    @Test
    void test_deplacerPersoDroite() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        laby.deplacerPerso(Labyrinthe.DROITE);
        Perso p = laby.getPj();

        assertEquals(2,p.getX());
        assertEquals(4,p.getY());
    }

    @Test
    void test_deplacerPersoHaut() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        laby.deplacerPerso(Labyrinthe.HAUT);
        Perso p = laby.getPj();

        assertEquals(1,p.getX());
        assertEquals(3,p.getY());
    }

    @Test
    void test_deplacerPersoBas() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        laby.deplacerPerso(Labyrinthe.BAS);
        Perso p = laby.getPj();

        assertEquals(3,p.getX());
        assertEquals(3,p.getY());
    }

}