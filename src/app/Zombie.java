package app;

import java.io.Serializable;

public class Zombie extends Character implements Serializable {


    public Zombie(int HP, int attack, int defence, boolean isLocked, int posX, int posY) {
        super(HP, attack, defence, isLocked, posX, posY);
    }


}
