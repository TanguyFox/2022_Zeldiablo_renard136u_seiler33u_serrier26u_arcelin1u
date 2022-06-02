package gameLaby.laby;

public abstract class Monstre implements Personnage{

    public int x;
    public int y;
    public int pv;
    public Epee epee;
    public String type;

    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
        this.epee = new Epee(x,y,10);
        this.pv = 100;
        this.type=null;
    }


    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }


    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public String getType(){
        return this.type;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public void attaquer(Joueur cible) {
        if(this.etrePresent(cible.x,cible.y)){
            epee.faireDegats(cible);
        }
        System.out.println("Votre vie : "+cible.getPv());
    }

    /**
     * @param degatSubis
     */
    @Override
    public void pertePv(int degatSubis) {
        this.pv -=degatSubis;
        if(this.etreMort()){
            System.out.println("Monstre mort\n");
        }
    }

    @Override
    public String toString() {
        return "Monstre{" +
                "x=" + x +
                ", y=" + y +
                ", epee=" + epee +
                '}';
    }

    @Override
    public int getPv() {
        return this.pv;
    }

    @Override
    public boolean etreMort() {
        return (this.getPv()<1);
    }
}
