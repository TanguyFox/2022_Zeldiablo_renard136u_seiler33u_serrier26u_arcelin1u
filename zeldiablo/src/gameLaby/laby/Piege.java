package gameLaby.laby;

public class Piege{

    public int x,y;
    public boolean explose;

    public Piege(int dx, int dy){
        this.x = dx;
        this.y = dy;
        this.explose=false;
    }

    /**
     * permet de savoir si l'objet est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si l'objet est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    /**
     * @return position x de l'objet
     */
    public int getX() {
        return x;
    }

    /**
     * @return position y de l'objet
     */
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void faireDegats(Joueur cible){
        if((cible.etrePresent(this.x,this.y)) && (!cible.etreMort())){
            cible.pertePv(50);
            this.explose=true;
            System.out.println("la mine a explosé");
            System.out.println("Votre vie : "+ cible.pv);
        }
    }



}
