package app;

public class Pea{

    private int LOCx;
    private int LOCy;
    private int Attack;

    public Pea(int LOCx, int LOCy, int attack) {
        this.LOCx = LOCx;
        this.LOCy = LOCy;
        Attack = attack;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getLOCx() {
        return LOCx;
    }

    public int getLOCy() {
        return LOCy;
    }

    public void setLOCy(int LOCy) {
        this.LOCy = LOCy;
    }

    public void setLOCx(int LOCx) {
        this.LOCx = LOCx;
    }

}
