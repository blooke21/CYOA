import javax.swing.JOptionPane;

public class CharacterCreation {
    checker check = new checker();
    int classChoice;

    public Character create(String tempString) {
        while (true) {
            if (check.checkInt(tempString)) {
                classChoice = Integer.parseInt(tempString);
                if (classChoice > 0 && classChoice < 4) {
                    if (classChoice == 1) {
                        // user selected Bruiser
                        Bruiser player = new Bruiser();
                        player.setName();
                        player.override();
                        return player;
                    } else if (classChoice == 2) {
                        // user selected Rouge
                        Rouge player = new Rouge();
                        player.setName();
                        player.override();
                        return player;
                    } else {
                        // user selected Mystic
                        Mystic player = new Mystic();
                        player.setName();
                        player.override();
                        return player;
                    }
                } else {
                    tempString = JOptionPane.showInputDialog(null,
                            "Invalid Input\nChose the class you want to play\n(1) Bruiser: Specializes in attacking. Starts with a stronger weapon\n(2) Rouge: Specializes in dodging. Starts with stronger armor\n(3) Mystic: Specializes in healing. Starts with a stronger relic(better healing)");
                }
            } else {
                tempString = JOptionPane.showInputDialog(null,
                        "Invalid Input\nChose the class you want to play\n(1) Bruiser: Specializes in attacking. Starts with a stronger weapon\n(2) Rouge: Specializes in dodging. Starts with stronger armor\n(3) Mystic: Specializes in healing. Starts with a stronger relic(better healing)");
            }
        }
    }
}
