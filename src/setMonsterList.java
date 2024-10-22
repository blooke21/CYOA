import java.util.ArrayList;

public class setMonsterList {
    ArrayList<Monster> monsterList = new ArrayList<Monster>();

    public ArrayList<Monster> setList(int num, String type) {
        num = num + 1;
        if (type.equalsIgnoreCase("G")) {
            for (int x = 1; x < num; x++) {
                Goblin goblin = new Goblin();
                goblin.setName(x);
                monsterList.add(goblin);
            }
            return monsterList;
        } else if (type.equalsIgnoreCase("L")) {
            for (int x = 1; x < num; x++) {
                Lizard lizard = new Lizard();
                lizard.setName(x);
                monsterList.add(lizard);
            }
            return monsterList;
        } else if (type.equalsIgnoreCase("T")) {
            for (int x = 1; x < num; x++) {
                Troll troll = new Troll();
                troll.setName(x);
                monsterList.add(troll);
            }
            return monsterList;
        } else if (type.equalsIgnoreCase("B")) {
            for (int x = 1; x < num; x++) {
                Blob blob = new Blob();
                blob.setName(x);
                monsterList.add(blob);
            }
            return monsterList;
        } else if (type.equalsIgnoreCase("O")) {
            for (int x = 1; x < num; x++) {
                Orc orc = new Orc();
                orc.setName(x);
                monsterList.add(orc);
            }
            return monsterList;
        } else if (type.equalsIgnoreCase("boss")) {
            Boss boss = new Boss();
            boss.setName(0);
            monsterList.add(boss);
            for (int x = 1; x < num; x++) {
                Orc orc = new Orc();
                orc.setName(x);
                monsterList.add(orc);
            }
            return monsterList;
        } else {
            return null;
        }

    }
}
