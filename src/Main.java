import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        CharacterCreation create = new CharacterCreation();
        Character player = new Character();
        Day day = new Day();
        player = create.create(JOptionPane.showInputDialog(null,
                "Chose the class you want to play\n(1) Bruiser: Specializes in attacking. Starts with a stronger weapon\n(2) Rouge: Specializes in dodging. Starts with stronger armor\n(3) Mystic: Specializes in healing. Starts with a stronger relic(better healing)"));

        JOptionPane.showMessageDialog(null,
                "Welcome to the small town of Briar.\nYou are a glory seeking mercenary and heard the people of Briar are facing attacks from monster daily. Desperate from a chance to make something of yourself, you've find yourself in the busy cities town square.\nWill you find enteral glory or succumb to the evil of the monsters?");

        JOptionPane.showMessageDialog(null,
                "The game is separated into day and night cycles. During the day you can speak to the town people and do quests. At night you can turn those quests in!");

        day.runDay(player);

    }
}