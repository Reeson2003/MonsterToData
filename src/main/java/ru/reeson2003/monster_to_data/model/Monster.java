package ru.reeson2003.monster_to_data.model;

/**
 * Created by reeson on 22.02.17.
 */
public class Monster {
    private int id;
    private String name;
    private int level;
    private int health;
    private int mana;

    public Monster(int id, String name, int level, int health, int mana) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "[" + id + "] Monster: " + name + " , lvl:" + level +
                ", " + health + " HP, " + mana + " MP";
    }
}
