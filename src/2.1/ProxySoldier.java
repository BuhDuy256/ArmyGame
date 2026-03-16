public class ProxySoldier implements Soldier {
    private Soldier soldier;
    private boolean hasShield;
    private boolean hasSword;

    public ProxySoldier(Soldier soldier) {
        this.soldier = soldier;
        this.hasShield = false;
        this.hasSword = false;
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength);
    }

    public void addShield() {
        if (this.hasShield) {
            throw new IllegalStateException("Can't add shield because it's already existed");
        }

        this.hasShield = true;
        this.soldier = new SoldierShieldDecorator(this.soldier);
    }

    public void addSword() {
        if (hasSword) {
            throw new IllegalStateException("Can't add sword because it's already existed");
        }

        this.hasSword = true;
        this.soldier = new SoldierSwordDecorator(this.soldier);
    }
}