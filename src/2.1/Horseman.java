public class Horseman implements Soldier {
    private static final int HORSEMAN_DEFAULT_DAMAGE = 5;
    private static final int HORSEMAN_DEFAULT_HEALTH = 20;

    private int health;

    public Horseman() {
        this.health = HORSEMAN_DEFAULT_HEALTH;
    }

    @Override
    public int hit() {
        return HORSEMAN_DEFAULT_DAMAGE;
    }

    @Override
    public boolean wardOff(int strength) {
        return this.health - strength > 0;
    }
}
