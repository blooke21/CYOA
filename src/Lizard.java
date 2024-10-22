import javax.swing.JOptionPane;

public class Lizard implements Monster {
    int health = 3;
    int armor = 1;
    int dodgeNum = 3;
    int attackNum = 3;
    double exp = .45;
    String name = "Lizard";

    public void setName(int num) {
        name = "Lizard " + num;
    }

    public String getName() {
        return name;
    }

    public int attack() {
        return ((int) (Math.random() * attackNum + 1));
    }

    public int dealDamage() {
        return ((int) (Math.random() * attackNum + 1));
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
        if (armor > num) {
            JOptionPane.showMessageDialog(null,
                    "The lizard's armor absorbs all the damage!");
            return 0;
        } else {
            health = health - (num - armor);
            if (health > 0) {
                if (num - armor == 0) {
                    JOptionPane.showMessageDialog(null,
                            "You would have dealt: " + num + " Damage\nThe lizard's armor absorbs " + armor
                                    + " and took no damage");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "You would have dealt: " + num + " Damage\nThe lizard's armor absorbs " + armor
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

    public double getExp() {
        return exp;
    }
}
