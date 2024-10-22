import javax.swing.JOptionPane;

public class Church implements Merchants {
    checker check = new checker();
    int talked = 0;
    String tempString;
    int userChoice;

    public int showMenu(int num, Boolean night) {
        switch (num) {
            case 1:// day one
                if (!night) { // fist time meeting merchant
                    if (talked == 0) {
                        tempString = JOptionPane.showInputDialog(null,
                                "Greeting fellow brother in arms, how may I help one of the flock\n\n(1) Ask about the monsters attacking the town\n\n(2) Leave");
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
                                        "Invalid Input\nGreeting fellow brother in arms, how may I help one of the flock\n\n(1) Ask about the monsters attacking the town\n\n(2) Leave");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "It seems you are lost little one? I thought you were off to deal with that Lizard nest");
                        return 0;
                    }
                } else if (night) { // day one night
                    return 2;
                } else {
                    return 0;
                }
            case 2:
                // day two
                if (!night) {
                    if (talked == 0) {
                        tempString = JOptionPane.showInputDialog(null,
                                "Ohh, you've returned once again. How may I assist our soon to be savor!\n\n(1) Ask about the monsters attacking the town\n\n(2) Leave");
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
                                        "Invalid Input\nOhh, you've returned once again. How may I assist our soon to be savor!\n\n(1) Ask about the monsters attacking the town\n\n(2) Leave");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Come to pray quickly before braving the terror?");
                        return 0;
                    }
                } else if (night) {
                    return 2;
                } else {
                    return 0;
                }
            case 3:
                // day three
                if (!night) {
                    if (talked == 0) {
                        tempString = JOptionPane.showInputDialog(null,
                                "(1) Acquire yet another quest\n\n(2) Leave");
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
                                        "Invalid Input\nOhh, you've returned once again. How may I assist our soon to be savor!\n\n(1) Ask about the monsters attacking the town\n\n(2) Leave");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Come to pray quickly before braving the terror?");
                        return 0;
                    }
                } else if (night) {
                    return 2;
                } else {
                    return 0;
                }
        }
        return 0;
    }

    public Quests giveQuests(int day) {

        switch (day) {
            case 1:
                JOptionPane.showMessageDialog(null,
                        "AH I see, so you did not come here seeking Divine Healing\nAbout a month ago the local major's wife passed away. He quickly became interested by dark magic, constantly asking me troubling questions.\nI believe he was aiming to raise the dead. A week ago he disappeared and these monster began to swarm us. The local militia did everything to secured the town but if the waves of monster are not abated we might not survive the year.\nIf you are seeking to help us, the local militia did find a nest of some sort of lizard creature. If you destroy it... we might stand a chance.\nQuest Added to Log!!");
                dayOneHard churchOne = new dayOneHard();
                churchOne.overwrite();
                return churchOne;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "With your success yesterday the local militia were able to scout out further and investigate the cause of these monsters.\nThey found a large totem guarded by lizard men.\nThey were able to take out quite a few but eventually had to retreat.\nIf the lizard men are weak this might be our chance to turn the tide. Take this holy symbol to and cleanse the totem!\nQuest Added to Log!!");
                dayTwoHard churchTwo = new dayTwoHard();
                churchTwo.overwrite();
                return churchTwo;
            case 3:
                JOptionPane.showMessageDialog(null,
                        "Just the person I wanted to see. The mayor's son has gone missing.\nThe local militia were making it a point to keep him safe but two nights ago he disappeared.\nHowever now they believe they found him, here I'll mark it on your map.\nQuest Added to Log!!");
                dayThreeEasy churchThree = new dayThreeEasy();
                churchThree.overwrite();
                return churchThree;

        }

        return null;
    }

    public Boolean finishQuest(Character player, int day, Boolean night) {
        switch (day) {
            case 1:
                if (!night) {
                    JOptionPane.showMessageDialog(null,
                            "Mmm, need guidance little one or are we just lost?");
                    return false;
                } else {
                    if (player.turnInQuest("Father", 2)) {
                        player.gainExp(2);
                        talked = 0;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Perhaps god, will deal with those Lizards");
                        return false;
                    }
                }
            case 2:
                if (!night) {
                    JOptionPane.showMessageDialog(null,
                            "Come to pray quickly before braving the terror?");
                    return false;
                } else {
                    if (player.turnInQuest("Father", 4)) {
                        player.gainExp(2);
                        talked = 0;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Only fate and god can tell if you made the right choice.");
                        return false;
                    }
                }
            case 3:
                if (!night) {
                    JOptionPane.showMessageDialog(null,
                            "Come to pray quickly before braving the terror?");
                    return false;
                } else {
                    System.out.print("hit");
                    if (player.turnInQuest("Father", 5)) {
                        player.gainExp(1);
                        talked = 0;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Only fate and god can tell if you made the right choice.");
                        return false;
                    }
                }
        }
        return false;

    }
}
