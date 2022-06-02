package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * classe labyrinthe. represente un labyrinthe avecW
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char EPEE = 'E';
    public static final char MORVE = 'M';
    public static final char ZOMBIE = 'Z';
    public static final char AMULETTE = 'A';
    public static final char SORTIE = 'S';


    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    public final String[] DEPLACEMENT_MONSTRE = {"Gauche","Droite","Haut","Bas"};


    /**
     * attribut du personnage
     */
    public Joueur pj;

    //passer par une liste pour en ajouter plusieurs
    public List<Monstre> monstre;

    public Amulette amulette;

    public Epee epee;

    public Sortie sortie;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                x--;
                break;
            case BAS:
                // on descend une ligne
                x++;
                break;
            case DROITE:
                // on augmente colonne
                y++;
                break;
            case GAUCHE:
                // on augmente colonne
                y--;
                break;
            default:
                throw new Error("action inconnue");
        }
        return new int[]{x, y};
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbLignes][nbColonnes];
        this.pj = null;
        this.monstre = new ArrayList<>();
        this.amulette = null;
        this.sortie = null;
        this.epee = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[numeroLigne][colonne] = true;
                        break;
                    case VIDE:
                        this.murs[numeroLigne][colonne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[numeroLigne][colonne] = false;
                        // ajoute PJ
                        this.pj = new Joueur(numeroLigne, colonne);
                        break;
                    case MORVE:
                        this.murs[numeroLigne][colonne] = false;
                        TasDeMorve tasDeMorve = new TasDeMorve(numeroLigne, colonne);
                        monstre.add(tasDeMorve);
                        break;
                    case ZOMBIE:
                        this.murs[numeroLigne][colonne] = false;
                        Zombie zombie = new Zombie(numeroLigne, colonne);
                        monstre.add(zombie);
                        break;
                    case EPEE:
                        this.murs[numeroLigne][colonne] = false;
                        this.epee = new Epee(numeroLigne, colonne, 20);
                        System.out.println(epee.getX() + " " + epee.getY());
                        break;
                    case AMULETTE:
                        this.murs[numeroLigne][colonne] = false;
                        this.amulette = new Amulette(numeroLigne, colonne);
                        System.out.println(amulette.getX() + " " + amulette.getY());
                        break;
                    case SORTIE:
                        this.murs[numeroLigne][colonne] = false;
                        this.sortie = new Sortie(numeroLigne, colonne);
                        System.out.println(sortie.getX() + " " + sortie.getY());
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }
            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        // case courante
        int[] courante = {this.pj.getX(), this.pj.getY()};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]] && !etreFini()) {
            for(int i=0;i<monstre.size();i++){
                if(suivante[0] == monstre.get(i).getX() && suivante[1] == monstre.get(i).getY()){
                    System.out.println("ATTENTION, il y a un monstre ici");
                    this.pj.attaquer(monstre.get(i));
                }else {
                    // on met a jour personnage
                    this.pj.setX(suivante[0]);
                    this.pj.setY(suivante[1]);
                }
            }
        }

        if(!this.pj.isEpeePossedee()){
            pj.recupererObjet(epee);
        }

        if (!this.pj.isAmulettePossedee()) {
            pj.recupererObjet(amulette);
        }
    }

    public void deplacerMonstre(){
        for(int i=0;i< monstre.size();i++){
            Random rand = new Random();
            int j = rand.nextInt(4);

            int[] courante = {this.monstre.get(i).getX(), this.monstre.get(i).getY()};

            int[] suivante = getSuivant(courante[0], courante[1], DEPLACEMENT_MONSTRE[j]);

            if(!Objects.equals(monstre.get(i).getType(), "tas")){
                if (!this.murs[suivante[0]][suivante[1]] && !etreFini()) {

                    if ((!this.murs[suivante[0]][suivante[1]]) && (!etreFini())) {

                        // si c'est un monstre, on reste aux mêmes coordonnées
                        if (suivante[0] == pj.getX() && suivante[1] == pj.getY()) {
                            System.out.println("Le Monstre attaque !");
                        } else {
                            // on met a jour personnage
                            this.monstre.get(i).setX(suivante[0]);
                            this.monstre.get(i).setY(suivante[1]);
                        }
                    }
                }
            }


        }
    }





        /**
         * jamais fini
         *
         * @return fin du jeu
         */
        public boolean etreFini () {
            return pj.etrePresent(sortie.getX(), sortie.getY()) && pj.isAmulettePossedee();
        }

        // ##################################
        // GETTER
        // ##################################

        /**
         * return taille selon Y
         *
         * @return
         */
         public int getLengthY () {
            return murs[0].length;
        }

        /**
         * return taille selon X
         *
         * @return
         */
        public int getLength () {
            return murs.length;
        }

        /**
         * return mur en (i,j)
         * @param x
         * @param y
         * @return
         */
        public boolean getMur ( int x, int y){
            // utilise le tableau de boolean
            return this.murs[x][y];
        }

        public List<Monstre> getMonstre() {
            return this.monstre;
        }

        public Joueur getPj () {
            return this.pj;
        }

        public Amulette getAmulette () {
            return this.amulette;
        }

        public Sortie getSortie () {
            return sortie;
        }

        public Epee getEpee(){
            return this.epee;
        }

    }


