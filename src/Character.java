import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Character {
    String tempString;
    String className = "none";
    String name;
    String lvlMsg;
    String weaponType = "none";
    String armor = "none";
    String relic = "none";
    int lvlIncrease;
    int level = 0;
    double exp = 0;
    int health = 3;
    int currentHealth = health;
    int intelligence = 3;
    int strength = 4;
    int dexterity = 3;
    int hitBonus = 1;
    int weaponDmg = 0;
    int armorBonus = 0; // chances of dodging
    int armorProtection = 0; // how much damage is absorbed
    int relicBonus = 0;
    int healthHealed;
    int tempNum;
    int counter;
    Boolean ultimateWeapon = false;
    DecimalFormat df = new DecimalFormat("0.00");
    ArrayList<Quests> questLog = new ArrayList<Quests>();
    String questLogMsg;
    checker check = new checker();
    String lvlOptions = "\n(1) for Health\n(2) for Intelligence\n(3) for Strength\n(4) for Dexterity";

    public int attack() {
        return ((int) (Math.random() * strength + 1) + hitBonus);
    }

    public int dodge() {
        return ((int) (Math.random() * dexterity + 1) + armorBonus);
    }

    public int getDogeNum() {
        return ((int) (Math.random() * dexterity + 1) + armorBonus);
    }

    public Boolean heal() {
        if (currentHealth == health) {
            JOptionPane.showMessageDialog(null,
                    "You are already at max health!");
            return false;
        }
        healthHealed = ((int) (Math.random() * intelligence + 1) + relicBonus);
        if ((healthHealed + currentHealth) > health) {
            healthHealed = health - currentHealth;
        }
        JOptionPane.showMessageDialog(null,
                name + " healed for " + healthHealed + "\n" + currentHealth + " -> " + (currentHealth + healthHealed));
        currentHealth = currentHealth + healthHealed;
        return true;
    }

    public int dealDamage(int num, String string) {
        weaponDmg = num + hitBonus;
        JOptionPane.showMessageDialog(null,
                getName() + "'s " + weaponType + " strike hits and does " + weaponDmg
                        + " damage(diff in rolls + WeaponBonus)\n" + string);
        return (weaponDmg);
    }

    public void takeDamage(int num, String string) {
        if (armorProtection > num) {
            JOptionPane.showMessageDialog(null,
                    "You're armor absorbs all the damage!");
        } else {
            currentHealth = currentHealth - (num - armorProtection);
            if (num - armorProtection == 0) {
                JOptionPane.showMessageDialog(null,
                        string + " so " + getName() + " would take " + (currentHealth - (armorProtection - num))
                                + " of damage\nBut " + getName() + "'s armor absorbed the damage\nCurrent Health | "
                                + currentHealth);
            } else {
                if (armorProtection == 0) {
                    JOptionPane.showMessageDialog(null,
                            string + " so " + getName() + " takes " + (num)
                                    + " of damage");
                } else {
                    JOptionPane.showMessageDialog(null,
                            string + " so " + getName() + " would take " + (num)
                                    + " damage\nbut " + getName() + "'s armor absorbs " + armorProtection
                                    + " of damage\nSo " + getName() + " only takes " + (num - armorProtection)
                                    + " damage\nCurrent Health | " + currentHealth);
                }

            }

            if (currentHealth <= 0) {
                JOptionPane.showMessageDialog(null,
                        "As the pain of the attack overwhelms you, a suffocating darkness begins to envelopes you until there is nothing but black...\nGAME OVER");
                System.exit(0);
            }
        }
    }

    public void setName() {
        tempString = JOptionPane.showInputDialog(null, "Enter Character's Name");
        while (true) {
            if (check.checkString(tempString)) {
                name = tempString;
                break;
            } else {
                tempString = JOptionPane.showInputDialog(null, "Invalid Input\nPlease Enter Character's name");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void showStats() {
        tempString = getName() + "'s Stats:\n\nLevel (" + level + ")\nExp (" +
                df.format(exp) + ")\nMax Health (" + health
                + ")\nCurrent Health (" + currentHealth
                + ")\nIntelligence (" + intelligence + ")\nStrength (" + strength + ")\nDexterity (" + dexterity
                + ")\nWeapon Type " + weaponType + " +" + hitBonus
                + " damage\nArmor " + armor + " +" + armorBonus + " dodge\nDamage Absorption " + armorProtection
                + "\nRelic " + relic + " +"
                + relicBonus + " healing bonus";
        if (ultimateWeapon) {
            tempString = tempString + "\nUltimate Weapon HELL YEAH!";
        }
        JOptionPane.showMessageDialog(null,
                tempString,
                className,
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Every time a player levels up a skill increases
    // if num == 1 player only lvled up once, if == 2 they lvled up twice
    // tempNum is used to increase player chosen skill
    public void levelUp(int num) {
        if (num == 1) {
            lvlMsg = "Congrats " + getName() + " leveled up!\nLevel " + level + " -> " + (level + 1) + "\n";
            lvlIncrease = 1;
            level = level + 1;
        } else if (num == 2) {
            lvlMsg = "Congrats " + getName() + " leveled up TWICE!\nLevel " + level + " -> " + (level + 2) + "\n";
            lvlIncrease = 2;
            level = level + 2;
        }
        switch (level) { // at lvl 2 and four all stats go up one
            case 2:
                lvlMsg = lvlMsg + "Since you hit level 2 all stats increase by (1)\nMax Health " + health + " -> "
                        + (health + 1) +
                        "\nIntelligence " + intelligence + " -> " + (intelligence + 1) +
                        "\nStrength " + strength + " -> " + (strength + 1) +
                        "\nDexterity" + dexterity + " -> " + (dexterity + 1);
                health = health + 1;
                currentHealth = health;
                intelligence = intelligence + 1;
                strength = strength + 1;
                dexterity = dexterity + 1;
                break;
            case 4:
                lvlMsg = lvlMsg + "Since you hit level 4 all stats increase by (1)\nMax Health " + health + " -> "
                        + (health + 1) +
                        "\nIntelligence " + intelligence + " -> " + (intelligence + 1) +
                        "\nStrength " + strength + " -> " + (strength + 1) +
                        "\nDexterity" + dexterity + " -> " + (dexterity + 1);
                health = health + 1;
                currentHealth = health;
                intelligence = intelligence + 1;
                strength = strength + 1;
                dexterity = dexterity + 1;
                break;
            case 6: // at lvl six all stats go up by two
                lvlMsg = lvlMsg + "Since you hit level 6 all stats increase by (2)\nMax Health " + health + " -> "
                        + (health + 2) +
                        "\nIntelligence " + intelligence + " -> " + (intelligence + 2) +
                        "\nStrength " + strength + " -> " + (strength + 2) +
                        "\nDexterity" + dexterity + " -> " + (dexterity + 2);
                health = health + 2;
                currentHealth = health;
                intelligence = intelligence + 2;
                strength = strength + 2;
                dexterity = dexterity + 2;

                break;
            case 8: // at lvl eight (max) all stats go up by three
                lvlMsg = lvlMsg + "Since you hit level 8 all stats increase by (3)\nMax Health " + health + " -> "
                        + (health + 3) +
                        "\nIntelligence " + intelligence + " -> " + (intelligence + 3) +
                        "\nStrength " + strength + " -> " + (strength + 3) +
                        "\nDexterity" + dexterity + " -> " + (dexterity + 3);
                health = health + 3;
                currentHealth = health;
                intelligence = intelligence + 3;
                strength = strength + 3;
                dexterity = dexterity + 3;
                break;
        }
        lvlMsg = lvlMsg
                + "\nAdditionally, for each level gained you can chose to increase a stat by (1) or increase your health by (2)"
                + lvlOptions;

        counter = 0;

        while (counter < lvlIncrease) {

            while (true) {
                if (counter == 0) {
                    tempString = JOptionPane.showInputDialog(null, lvlMsg);
                } else {
                    tempString = JOptionPane.showInputDialog(null, "Second selection" + lvlOptions);
                }

                if (check.checkInt(tempString)) {
                    tempNum = Integer.parseInt(tempString);
                    if (tempNum > 0 && tempNum < 5) {
                        counter++;
                        break;
                    } else {
                        lvlMsg = "Invalid Input\nPlease Enter" + lvlOptions;
                    }
                } else {
                    lvlMsg = "Invalid Input\nPlease Enter" + lvlOptions;
                }
            }
            switch (tempNum) {
                case 1:
                    health = health + 2;
                    break;
                case 2:
                    intelligence = intelligence + 1;
                    break;
                case 3:
                    strength = strength + 1;
                    break;
                case 4:
                    dexterity = dexterity + 1;
                    break;
            }
        }
    }

    public int checkHealth() {
        return currentHealth;
    }

    public void gainExp(double num) {
        exp = exp + num;
        while (exp >= 1) {
            exp = exp - 1;
            levelUp(1);
        }
    }

    public void addQuest(Quests quest) {
        questLog.add(quest);
    }

    public Quests viewQuests(Boolean night) {
        if (night) {
            for (Quests tempQuest : questLog) {
                if (tempQuest.getCompleted()) {
                    JOptionPane.showMessageDialog(null,
                            "You've to turn in " + tempQuest.getName() + " by visiting " + tempQuest.getGiver());
                }
            }
            return null;
        } else {
            questLogMsg = "Choose a quest to embark on\n";
            counter = 1;
            for (Quests tempQuest : questLog) {
                questLogMsg = questLogMsg + "(" + counter + ")" + tempQuest.getName() + "\n" + tempQuest.getReward()
                        + "\n\n";
                counter++;
            }
            questLogMsg = questLogMsg + "(" + counter + ") To back out";
            tempString = JOptionPane.showInputDialog(null, questLogMsg);
            while (true) {
                if (check.checkInt(tempString)) {
                    tempNum = Integer.parseInt(tempString);
                    if (tempNum > 0 && tempNum <= counter) {
                        if (tempNum == counter) {
                            return null;
                        } else {
                            return questLog.get(tempNum - 1);
                        }

                    } else {
                        tempString = JOptionPane.showInputDialog(null, "Invalid Input\n" + questLogMsg);
                    }
                } else {
                    tempString = JOptionPane.showInputDialog(null, "Invalid Input\n" + questLogMsg);
                }
            }
        }

    }

    public Boolean turnInQuest(String merchant, int num) {
        for (Quests tempQuest : questLog) {
            if (tempQuest.getGiver().equalsIgnoreCase("joe") && tempQuest.getCompleted() && num == 1) {
                JOptionPane.showMessageDialog(null,
                        "Hey, I heard you gave those goblins a hell of a time! Well, well done enjoy your reward\nEXP + 1\n+ Blacksmith's Weapon | + 2 WeaponBonus");
                weaponType = "Blacksmith Weapon";
                hitBonus = 2;
                return true;
            }
            if (tempQuest.getGiver().equalsIgnoreCase("Father") && tempQuest.getCompleted() && num == 2) {
                JOptionPane.showMessageDialog(null,
                        "AH! You've return! Perhaps god will guide us through this after all!\nEXP + 2\n+ Church Artifact | + 2 RelicBonus");
                relic = "Church Artifact";
                relicBonus = 2;
                return true;
            }
            if (tempQuest.getGiver().equalsIgnoreCase("joe") && tempQuest.getCompleted() && num == 3) {
                JOptionPane.showMessageDialog(null,
                        "Nice job dealing with that troll!\nEXP + 1\n+ Blacksmith's Armor | + 2 ArmorBonus & +1 ArmorProtection");
                armor = "Blacksmith Armor";
                armorBonus = 2;
                armorProtection = 1;
                return true;
            }
            if (tempQuest.getGiver().equalsIgnoreCase("Father") && tempQuest.getCompleted() && num == 4) {
                JOptionPane.showMessageDialog(null,
                        "This will truly be a celebrated day!!!\nEXP + 2\n + Holy Armor | + 3 ArmorBonus & + 3 ArmorProtection");
                armor = "Holy Armor";
                armorBonus = 3;
                armorProtection = 2;
                return true;
            }
            if (tempQuest.getGiver().equalsIgnoreCase("Father") && tempQuest.getCompleted() && num == 5) {
                JOptionPane.showMessageDialog(null,
                        "Nicely done, hopefully he'll take up his fathers place and start leading this town\nEXP + 1\n+ Holy Armament | + 3 RelicBonus & WeaponBonus + 1 ");
                relicBonus = relicBonus + 3;
                hitBonus = hitBonus + 1;
                return true;
            }
            if (tempQuest.getGiver().equalsIgnoreCase("joe") && tempQuest.getCompleted() && num == 6) {
                JOptionPane.showMessageDialog(null,
                        "Well Done! Hopefully his leadership will be the cornerstone of our resistance!\nEXP + 2\nThe Ultimate Weapon and Armor of Pure Magical Dreams and Rainbows | + ...unknown");
                ultimateWeapon = true;
                return true;
            }
        }
        return false;
    }

    public void emptyQuest() {
        questLog.clear();
    }

    public Boolean getUltimateWeapon() {
        return ultimateWeapon;
    }

    public void godMode() {
        health = 999;
        hitBonus = 999;
        armorBonus = 999;
        armorProtection = 999;
        currentHealth = health;
    }
}
