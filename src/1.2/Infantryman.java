public class Infantryman implements Soldier {
    private static final int INFANTRY_DEFAULT_DAMAGE = 3;
    private static final int INFANTRY_DEFAULT_HEALTH = 15;

    private int health;

    public Infantryman() {
        this.health = INFANTRY_DEFAULT_HEALTH;
    }

    @Override
    public int hit() {
        System.out.println("Infantry hit!");
        return INFANTRY_DEFAULT_DAMAGE;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("Infantry ward off!");
        return this.health - strength > 0;
    }
}