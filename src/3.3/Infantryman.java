public class Infantryman implements Soldier {
    private static final int INFANTRY_DEFAULT_DAMAGE = 3;
    private static final int INFANTRY_DEFAULT_HEALTH = 15;

    private int health;

    public Infantryman() {
        this.health = INFANTRY_DEFAULT_HEALTH;
    }

    @Override
    public int hit() {
        return INFANTRY_DEFAULT_DAMAGE;
    }

    @Override
    public boolean wardOff(int strength) {
        return this.health - strength > 0;
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }
}