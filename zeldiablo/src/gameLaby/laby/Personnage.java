package gameLaby.laby;

public interface Personnage {

    boolean etrePresent(int dx, int dy);

    void recupererObjet(Objet objet);

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    String toString();

    void attaquer(Epee epee);

    void pertePv(int degatSubis);
}
