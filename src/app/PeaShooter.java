package app;

import java.util.Timer;

public class PeaShooter extends Plants {

    public PeaShooter(int cost, int waitTime, int HP, int att, int def, boolean isLocked, int posX, int posY) {
        super(cost, waitTime, HP, att, def, isLocked, posX, posY);
        Pea pea=new Pea(posX,posY,att);
    }
    @Override
    public void power(){

    }
}
