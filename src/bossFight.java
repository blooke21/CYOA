public class bossFight extends Quests {

    public void overwrite(Character player) {
        name = "BOSS FIGHT";
        giver = "SATAN";
        numMonsters = 3;
        monsterType = "boss";
        reward = "ENTERAL DAMNATION";
        flavorTextOne = "You're awoke from your sleep by a loud scream. Peering out your rented room, you quickly survey the town.\nIf it weren't for the raging flames quickly spreading across the town you wouldn't be able to see a thing.\nHowever, this isn't the case... Countless orcs are pillaging and fighting the local militia, leading charge is a man in a black clock.\nAs you run out to join the fight you quickly locate and charge at the clocked man!";
        flavorTextTwo = "As night becomes day, and the mayor defeated all the remaining orcs dissipate into dusts.\nThe townsfolk all beaten and bruised but never broken douse the flames and begin rebuilding their town.";
        flavorTextThree = "Weeks go by of constant repair and nursing wounds, eventually the Town of Briar returns to normal.\nBut before they do they throw a celebration... \na celebration of an evil defeated by you... so the day becomes known as "
                + player.getName() + " day!\n\nTHE END";
    }

}
