
public interface Merchants {
    checker check = new checker();
    String tempString = "";
    int talked = 0;
    String name = "";
    int userChoice = 0;

    public abstract int showMenu(int num, Boolean night);

    public abstract Quests giveQuests(int day);

    public abstract Boolean finishQuest(Character player, int day, Boolean night);

}
