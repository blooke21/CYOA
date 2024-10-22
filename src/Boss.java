import javax.swing.JOptionPane;

public class Boss implements Monster {
    int health = 15;
    int armor = 3;
    int dodgeNum = 4;
    int attackNum = 8;
    double exp = 1;
    String name;

    public void setName(int num) {
        name = "Mayor Steven";
    }

    public String getName() {
        return name;
    }

    public int attack() {
        return ((int) (Math.random() * attackNum + 1));
    }

    public int dealDamage() {
        return ((int) (Math.random() * attackNum + 1) + 2);
    }

    public int getDodgeNum() {
        return ((int) (Math.random() * dodgeNum + 1));
    }

    public int getHealth() {
        return health;
    }

    public int dodge() {
        return ((int) (Math.random() * dodgeNum + 1));
    }

    public double takeDamage(int num) {
        if (num == 666) {
            JOptionPane.showMessageDialog(null,
                    "The Ultimate Weapon and Armor of Pure Magical Dreams and Rainbows detects the evil residing in the Mayor and shoots a magical rainbow that does 10 damage");
            health = 10;
            return 0;
        } else {
            if (armor > num) {
                JOptionPane.showMessageDialog(null,
                        "The Mayor Steven's armor absorbs all the damage!");
                return 0;
            } else {
                health = health - (num - armor);
                if (health > 0) {
                    if (num - armor == 0) {
                        JOptionPane.showMessageDialog(null,
                                "You would have dealt: " + num + " Damage\nThe Mayor Steven's armor absorbs " + armor
                                        + " and took no damage");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "You would have dealt: " + num + " Damage\nThe The Mayor Steven's armor absorbs "
                                        + armor
                                        + " the damage but still took "
                                        + (num - armor) + " damage");
                    }
                    return 0;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Your attack finishes " + name + " off\n EXP +" + exp);
                    return exp;

                }
            }
        }
    }

    public double getExp() {
        return exp;
    }
}
