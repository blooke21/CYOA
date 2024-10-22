public class Bruiser extends Character {
    public void override() {
        className = "Bruiser";
        strength = strength + 1;
        intelligence = intelligence - 1;
        weaponType = "Ax";
        hitBonus = hitBonus + 1;
    }
}
