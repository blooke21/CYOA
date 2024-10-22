public interface Monster {
    int health = 3;
    int armor = 1;
    int dodgeNum = 3;
    int attackNum = 3;
    double exp = 1;
    String name = "";

    public void setName(int num);

    public int attack();

    public String getName();

    public int dealDamage();

    public int getDodgeNum();

    public int getHealth();

    public int dodge();

    public double takeDamage(int num); // returns true if monster is killed

    public double getExp();
}
