package gameLaby.laby;

public class TasDeMorve extends Monstre{

    public int x;
    public int y;
    public Epee epee;
    public int pv;
    public static String type="tas";

    public TasDeMorve(int x, int y) {
        super(x, y);
        this.pv = 40;
        this.epee= new Epee(this.x,this.y,30);
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
        if(!this.etreMort()){
            if(this.etrePresent(cible.x,cible.y)){
                epee.faireDegats(cible);
            }
            System.out.println("Votre vie : "+cible.getPv());
        }

    }
}
