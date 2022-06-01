package gameLaby.laby;

public abstract class Monstre implements Personnage{

    public int x;
    public int y;
    public Epee epee;

    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
        this.epee = null;
    }

    /**
     * A FAIRE
     * @param action
     */
    public abstract void deplacerMonstres(String action);

    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    /**
     * A faire
     * @param epee
     */
    public void recupererArme(Epee epee) {
        this.epee = epee;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * A FAIRE
     * @param epee
     */
    public void attaquer(Epee epee) {
        throw new Error("TO DO");
    }

    /**
     * A FAIRE
     * @param degatSubis
     */
    @Override
    public void pertePv(int degatSubis) {
        throw new Error("TO DO");
    }

    @Override
    public String toString() {
        return "Monstre{" +
                "x=" + x +
                ", y=" + y +
                ", epee=" + epee +
                '}';
    }
}
