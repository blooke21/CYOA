import javax.swing.JOptionPane;

public class Menu {
    checker check = new checker();
    String tempString;
    int tempInt;
    String time;

    public int displayMenu(Boolean night, int day) {
        if (!night) {
            time = "| Day " + day;
        } else {
            time = "| Night " + day;
        }

        tempString = JOptionPane.showInputDialog(null,
                "(1) View Player Stats\n(2) View Current Quests\n(3) Speak to the Blacksmith\n(4) Visit the Church\n(5) Quit",
                "The Town of Brier " + time, JOptionPane.INFORMATION_MESSAGE);
        while (true) {
            if (check.checkInt(tempString)) {
                tempInt = Integer.parseInt(tempString);
                if (tempInt > 0 && tempInt < 6) {
                    return tempInt;
                } else if (tempInt == 666) {
                    return 666;
                } else {
                    tempString = JOptionPane.showInputDialog(null,
                            "Invalid\n(1) View Player Stats\n(2) View Current Quests\n(3) Speak to the Blacksmith\n(4) Visit the Church\n(5) Quit",
                            "The Town of Brier " + time, JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                tempString = JOptionPane.showInputDialog(null,
                        "Invalid\n(1) View Player Stats\n(2) View Current Quests\n(3) Speak to the Blacksmith\n(4) Visit the Church\n(5) Quit",
                        "The Town of Brier", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
