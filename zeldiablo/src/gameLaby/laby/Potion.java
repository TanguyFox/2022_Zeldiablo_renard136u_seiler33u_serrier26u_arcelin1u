package gameLaby.laby;

public class Potion {

    public int x,y;

    public Potion(int dx, int dy){
        this.x = dx;
        this.y = dy;
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

    public void soigner(Joueur j){
        if((j.etrePresent(this.x,this.y)&&(!j.etreMort()))){
            j.pv = 100;
            System.out.println("Vous vous soigné");
            System.out.println("Votre vie : "+ j.pv);
        }
    }
}

