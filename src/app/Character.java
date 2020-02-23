package app;

public abstract class Character  {

private int HP;
private int maxHP;
private int attack;
private int defence;
private boolean isLocked;
private int posX;
private int posY;

    public Character(int HP, int attack, int defence, boolean isLocked, int posX, int posY) {
        this.HP = HP;
        this.attack = attack;
        this.defence = defence;
        this.isLocked = isLocked;
        this.posX = posX;
        this.posY = posY;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
