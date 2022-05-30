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
    void getMonstre() {
        throw new Error("TO DO");
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

    }

    @Test
    void test_deplacerPersoHaut() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        laby.deplacerPerso(Labyrinthe.HAUT);
        Perso p = laby.getPj();
    }

    @Test
    void test_deplacerPersoBas() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo/labySimple/laby0.txt");

        laby.deplacerPerso(Labyrinthe.BAS);
        Perso p = laby.getPj();
    }

}