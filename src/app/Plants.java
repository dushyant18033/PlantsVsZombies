package app;

import java.io.Serializable;
import java.util.Timer;

public abstract class Plants extends Character  implements Serializable {

    private int cost;
    private int WaitTime;

    public Plants(int cost, int waitTime,int HP, int att,int def, boolean isLocked,int posX,int posY ) {
        super(HP,att,def,isLocked,posX,posY);
        this.cost = cost;
        WaitTime = waitTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWaitTime() {
        return WaitTime;
    }

    public void setWaitTime(int waitTime) {
        WaitTime = waitTime;
    }

    public abstract void power();

}
