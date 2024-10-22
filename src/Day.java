import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Day {
    int day;
    Boolean night = false;
    Boolean menuQuit = false;
    Blacksmith Joe = new Blacksmith();
    Church church = new Church();
    Menu menu = new Menu();
    setMonsterList setList = new setMonsterList();
    int merchantNum;
    Quests selectedQuest;
    ArrayList<Monster> monsterList = new ArrayList<Monster>();

    public Character runDay(Character player) {
        day = 1;
        while (day <= 3) {
            System.out.print(day);
            switch (menu.displayMenu(night, day)) {
                case 1:
                    player.showStats();
                    break;
                case 2:
                    if (player.questLog.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Your Quest Log is empty speak to the merchants to get some more");
                    } else {
                        // display quest log
                        selectedQuest = player.viewQuests(night);
                        if (selectedQuest == null) {
                            break;
                        } else {
                            monsterList = setList.setList(selectedQuest.getMonsterNum(),
                                    selectedQuest.getMonsterType());
                            selectedQuest.encounter(player, monsterList);
                            night = true;
                        }

                    }
                    break;
                case 3:
                    // Blacksmith
                    merchantNum = Joe.showMenu(day, night);
                    // shows blacksmith menu if return 1 hero accepted quest
                    if (merchantNum == 1) {
                        player.addQuest(Joe.giveQuests(day));
                        // if 2 it is night and program will check if they completed his quest
                    } else if (merchantNum == 2) {
                        if (Joe.finishQuest(player, day, night)) {
                            day = day + 1;
                            night = false;
                            player.emptyQuest();
                            menuQuit = true;
                        }
                        break;
                    }
                    break;
                case 4:
                    // Church
                    merchantNum = church.showMenu(day, night);
                    if (merchantNum == 1) {
                        player.addQuest(church.giveQuests(day));
                    } else if (merchantNum == 2) {
                        if (church.finishQuest(player, day, night)) {
                            day = day + 1;
                            night = false;
                            player.emptyQuest();
                            menuQuit = true;
                        }
                        break;
                    }
                    break;
                case 5:
                    // Quit
                    System.exit(0);
                    break;
                case 666:
                    player.godMode();
                    break;
            }

        }
        bossFight boss = new bossFight();
        boss.overwrite(player);
        player.addQuest(boss);
        monsterList = setList.setList(boss.getMonsterNum(),
                boss.getMonsterType());
        boss.encounter(player, monsterList);
        return player;
    }
}
