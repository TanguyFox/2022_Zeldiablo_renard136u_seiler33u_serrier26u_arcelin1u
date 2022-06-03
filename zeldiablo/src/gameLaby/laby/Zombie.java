package gameLaby.laby;

public class Zombie extends Monstre{

    public int x;
    public int y;
    public int pv;
    public Epee epee;
    public static String type="zombie";

    public Zombie(int x, int y) {
        super(x,y);
        this.pv = 70;
        this.epee= new Epee(this.x,this.y,10);
    }

    @Override
    public int getPv() {
        return this.pv;
    }

    public void pertePv(int degatSubis){
        this.pv -=degatSubis;
    }

    public String getType(){
        return type;
    }

    @Override
    public boolean etreMort() {
        return this.getPv()<1;
    }

    public void attaquer(Joueur cible) {
        if(this.etrePresent(cible.x,cible.y)){
            epee.faireDegats(cible);
        }
        System.out.println("Votre vie : "+cible.getPv());
    }
}
