import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Quests {
    checker check = new checker();
    Boolean complete = false;
    Fight fight = new Fight();
    Boolean turnOne = true;
    int heal = 2;
    String[] healOptions = new String[] { "Heal", "Attack" };
    String name = "";
    String encounterMsg = "";
    String giver = "";
    int targetInt = 0;
    int numMonsters;
    String monsterType;
    int result = 0;
    String targetString = "";
    double exp;
    String reward = "";
    ArrayList<Monster> monsterList = new ArrayList<Monster>();
    String flavorTextOne;
    String flavorTextTwo;
    String flavorTextThree;

    public String getMonsterType() {
        return monsterType;
    }

    public int getMonsterNum() {
        return numMonsters;
    }

    public Boolean getCompleted() {
        return complete;
    }

    public String getGiver() {
        return giver;
    }

    public String getReward() {
        return reward;
    }

    public String getName() {
        return name;
    }

    public Character encounter(Character player, ArrayList<Monster> monsterList) {
        if (!complete) {
            introMsg();

            encounterMsg = "Select Target\n\n";

            // continues looping until all monsters are dead
            while (true) {
                if (monsterList.size() == 0) {
                    break;
                } else {
                    if (player.getUltimateWeapon() && turnOne) {
                        monsterList.get(0).takeDamage(666);
                    }

                    // displays currently still alive monsters
                    for (int x = 1; x < monsterList.size() + 1; x++) {
                        encounterMsg = encounterMsg + "(" + (x) + ") " + monsterList.get(x - 1).getName() + " | Health "
                                + monsterList.get(x - 1).getHealth() + "\n";
                        if (!turnOne) {
                            // Monster attack but not on turn one
                            fight.characterDodge(player, monsterList.get(x - 1));
                        }
                    }
                    if (!turnOne) {
                        // forces player to attack on turn one
                        heal = JOptionPane.showOptionDialog(null, "Choose Option",
                                player.getName() + " | Health " + player.checkHealth(),
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, healOptions, healOptions[0]);
                    }
                    if (heal == 0) {
                        if (!player.heal()) {
                            heal = 0;
                            encounterMsg = "Which one will you attack next!\n\n";
                        } else {
                            encounterMsg = "Which one will you attack next!\n\n";
                        }
                    } else {
                        // takes user input
                        targetString = JOptionPane.showInputDialog(null, encounterMsg);
                        while (true) {
                            if (check.checkInt(targetString)) {

                                targetInt = (Integer.parseInt(targetString));

                                if (targetInt > 0 && targetInt < (monsterList.size() + 1)) {

                                    // if they enter a valid number
                                    // the monster and player are passed to the fight method
                                    // returns zero if the player missed or the monster doesn't take any damage
                                    result = fight.characterAttack(player, monsterList.get(targetInt - 1));
                                    if (result == 0) {
                                        break;
                                    } else {
                                        // if fight returns a number the monster takes that damage
                                        exp = monsterList.get(targetInt - 1).takeDamage(result);

                                        if (exp == 0) {
                                            // if take damage returns zero the monster still has health left
                                            break;
                                        } else {
                                            // else the method returns the amount of exp the player gains
                                            player.gainExp(monsterList.get(targetInt - 1).getExp());
                                            monsterList.remove(targetInt - 1);
                                            break;
                                        }

                                    }
                                } else {
                                    targetString = JOptionPane.showInputDialog(null,
                                            "Invalid Input\n" + encounterMsg);
                                }
                            } else {
                                targetString = JOptionPane.showInputDialog(null,
                                        "Invalid Input\n" + encounterMsg);
                            }
                        }
                        turnOne = false;
                        encounterMsg = "Which one will you attack next!\n\n";
                    }
                }
            }
            complete = true;
            extMsg();
            return player;
        } else {
            JOptionPane.showMessageDialog(null,
                    "You've already completed that quest! Make sure to turn it in!");
            return player;
        }

    }

    public void introMsg() {
        JOptionPane.showMessageDialog(null,
                flavorTextOne);
    }

    public void extMsg() {
        JOptionPane.showMessageDialog(null,
                flavorTextTwo);
        JOptionPane.showMessageDialog(null,
                flavorTextThree);

    }
}
