package gameLaby.laby;

public interface Personnage {

    boolean etrePresent(int dx, int dy);

    int getX();

    int getY();

    int getPv();

    void setX(int x);

    void setY(int y);

    String toString();

    void pertePv(int degatSubis);

    boolean etreMort();
}
