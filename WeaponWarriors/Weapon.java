package weaponswarriors;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Weapon implements WeaponI {

    String name;
    int maxDamage;
    
    public Weapon() {
        name = "Stick";
        maxDamage = 15;
    }
    
    @Override
    public String toString() {
        return "Weapon " + getName() + ", " + "damage=" + getMaxDamage();
    }
            
    @Override
    public int getDamage() {
        Random rand = new Random();
        int damage = rand.nextInt(getMaxDamage()) + 1;
        return damage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public void initFromString(String input) {
        Scanner scan = new Scanner(input);
        String pat = "Weapon\\s+(\\w+),\\s*damage=(\\d+)\\s*";
        if(scan.findInLine(pat) != null) {
            MatchResult m = scan.match();
            name = m.group(1);
            maxDamage = Integer.parseInt(m.group(2));
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
