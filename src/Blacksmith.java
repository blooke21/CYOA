
import javax.swing.JOptionPane;

public class Blacksmith implements Merchants {
    checker check = new checker();
    int talked = 0;
    String tempString;
    String name = "Blacksmith Joe";
    int userChoice;

    public int showMenu(int num, Boolean night) {
        switch (num) {
            case 1:// day one
                if (!night) { // fist time meeting merchant
                    if (talked == 0) {
                        tempString = JOptionPane.showInputDialog(null,
                                "Hey, you must be new in town. The names Bill but everyone calls me Blacksmith Joe. What can I do for ya?\n\n(1) Inquire about what you can do to help the town\n\n(2) Leave");
                        while (true) {
                            if (check.checkInt(tempString)) {
                                userChoice = Integer.parseInt(tempString);
                                if (userChoice == 1) {
                                    talked++;
                                    return userChoice;
                                } else {
                                    return 0;
                                }
                            } else {
                                tempString = JOptionPane.showInputDialog(null,
                                        "Invalid Input\nHey, you must be new in town. The names Bill but everyone calls me Blacksmith Joe. What can I do for ya?\n\n(1) Inquire about what you can do to help the town\n\n(2) Leave");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Hey, talking to me's not going to help those farmers");
                        return 0;
                    }
                } else { // day one night
                    return 2;
                }
            case 2:
                // day two
                if (!night) {
                    if (talked == 0) {
                        tempString = JOptionPane.showInputDialog(null,
                                "Hey, ready for another day of hard work?\n\n(1) Accept another quest\n\n(2) Leave");
                        while (true) {
                            if (check.checkInt(tempString)) {
                                userChoice = Integer.parseInt(tempString);
                                if (userChoice == 1) {
                                    talked++;
                                    return userChoice;
                                } else {
                                    return 0;
                                }
                            } else {
                                tempString = JOptionPane.showInputDialog(null,
                                        "Invalid Input\nHey, ready for another day of hard work?\n\n(1) Accept another quest\n\n(2) Leave");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Did you kill that troll already??");
                        return 0;
                    }

                } else {
                    return 2;
                }
            case 3:
                // day three
                if (!night) {
                    if (talked == 0) {
                        tempString = JOptionPane.showInputDialog(null,
                                "Alright sweet, I was just about to go looking for you\n\n(1) Accept another quest\n\n(2) Leave");
                        while (true) {
                            if (check.checkInt(tempString)) {
                                userChoice = Integer.parseInt(tempString);
                                if (userChoice == 1) {
                                    talked++;
                                    return userChoice;
                                } else {
                                    return 0;
                                }
                            } else {
                                tempString = JOptionPane.showInputDialog(null,
                                        "Invalid Input\nAlright sweet, I was just about to go looking for you\n\n(1) Accept another quest\n\n(2) Leave");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Did you rescue him??");
                        return 0;
                    }
                } else {
                    return 2;
                }
        }
        return 0;
    }

    public Quests giveQuests(int day) {

        switch (day) {
            case 1:
                JOptionPane.showMessageDialog(null,
                        "There's some farmers who are looking for some help, down the road from here\nQuest Added to Log!!");
                dayOneEasy blacksmithOne = new dayOneEasy();
                blacksmithOne.overwrite();
                System.out.print("Name: " + blacksmithOne.getName());
                return blacksmithOne;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "Well after I heard about your big success yesterday, I think you can handle something more serious.\nSome villagers are worried about a bridge troll down by the river.\nIf you can deal with him it will help with our local trading\nQuest Added to Log!!");
                dayTwoEasy blacksmithTwo = new dayTwoEasy();
                blacksmithTwo.overwrite();
                return blacksmithTwo;
            case 3:
                JOptionPane.showMessageDialog(null,
                        "It seems our actions against these monsters have not gone unnoticed.\nLate last night the town was attack and the leader of the local militia has been kidnaped and we need you to rescue him\nQuest Added to Log!!");
                dayThreeHard blacksmithThree = new dayThreeHard();
                blacksmithThree.overwrite();
                return blacksmithThree;
        }

        return null;
    }

    public Boolean finishQuest(Character player, int day, Boolean night) {
        switch (day) {
            case 1:
                if (!night) {
                    JOptionPane.showMessageDialog(null,
                            "Huh, but I already gave you that quest");
                    return false;

                } else {

                    if (player.turnInQuest("Joe", 1)) {
                        player.gainExp(1);
                        talked = 0;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Oh you didn't get out to help them farmers, it's alright they probably handled it themselves... I hope");
                        return false;
                    }
                }
            case 2:
                if (!night) {
                    JOptionPane.showMessageDialog(null,
                            "Huh, but I already gave you that quest");
                    return false;
                } else {
                    if (player.turnInQuest("Joe", 3)) {
                        player.gainExp(1);
                        talked = 0;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Oh you didn't get out to help them farmers, it's alright they probably handled it themselves... I hope");
                        return false;
                    }
                }
            case 3:
                if (!night) {
                    JOptionPane.showMessageDialog(null,
                            "Huh, shouldn't you be busy saving the Mayor's Son!!");
                    return false;
                } else {
                    if (player.turnInQuest("Joe", 6)) {
                        player.gainExp(2);
                        talked = 0;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Hey, man it was tough choice so Im not going to judge you.");
                        return false;
                    }
                }
        }
        return false;

    }

}
