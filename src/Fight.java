import javax.swing.JOptionPane;

public class Fight {
    int characterRoll;
    int monsterRoll;
    String fightMsg;
    int result;

    public int characterAttack(Character player, Monster monster) {

        characterRoll = player.attack();
        monsterRoll = monster.dodge();
        fightMsg = "Your attack roll is: " + characterRoll + "\n" + monster.getName() + "'s dodge roll is : "
                + monsterRoll + "\n";

        if (characterRoll > monsterRoll) {
            result = player.dealDamage(characterRoll - monsterRoll,
                    fightMsg);
        } else {
            JOptionPane.showMessageDialog(null, fightMsg + "Your attack misses!");
            result = 0;
        }
        return result;
    }

    public void characterDodge(Character player, Monster monster) {

        characterRoll = player.dodge();
        monsterRoll = monster.attack();
        fightMsg = "Your dodge roll is: " + characterRoll + "\n" + monster.getName() + "'s attack roll is : "
                + monsterRoll + "\n";

        if (monsterRoll > characterRoll) {
            player.takeDamage(monsterRoll - characterRoll, fightMsg);
        } else {
            JOptionPane.showMessageDialog(null, "the " + monster.getName() + " misses!\n" + fightMsg);
        }
    }

}
