package app;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private transient int[][] myPlants;
    private transient int[][] myZombies;

    private String username;
    private int levelUnlocked;

    User()
    {
        levelUnlocked=1;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevelUnlocked() {
        return levelUnlocked;
    }

    public void setLevelUnlocked(int levelUnlocked) {
        this.levelUnlocked = levelUnlocked;
    }
}
