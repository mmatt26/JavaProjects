package weaponswarriors;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class Warrior implements WarriorI {

    String name;
    Weapon weapon;
    int health;
    int maxHealth;
    
    public Warrior() {
        name = "Duke";
        health = 1000;
        maxHealth = 1000;
    }
    
    @Override
    public String toString() {
        return "Warrior " + getName() + ", health=" + getHealth() + ", max health=" + getMaxHealth();
    }
    
    @Override
    public WeaponI getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(WeaponI w) {
        weapon = (Weapon)w;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDefeated() {
        return (health <= 0);
    }

    @Override
    public boolean isHealthy() {
        return maxHealth == health;
    }

    @Override
    public int takeDamage(WeaponI w) {
        int damage = w.getDamage();
        health -= damage;
        return damage;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void initFromString(String input) {
        Scanner scan = new Scanner(input);
        String pat = "Warrior\\s+(\\w+),\\s*health=(\\d+),\\s*max\\s+health=(\\d+)\\s*";
        if(scan.findInLine(pat) != null) {
            MatchResult m = scan.match();
            name = m.group(1);
            health = Integer.parseInt(m.group(2));
            maxHealth = Integer.parseInt(m.group(3));
        }
    }

    @Override
    public void heal() {
        health = maxHealth;
    }   
}
