public class Mystic extends Character {
    public void override() {
        className = "Mystic";
        intelligence = intelligence + 1;
        strength = strength - 1;
        weaponType = "Fireball";
        relic = "Mystic Symbol";
        relicBonus = relicBonus + 1;
    }
}
