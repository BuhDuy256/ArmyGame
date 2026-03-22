public class SoldierShieldDecorator extends SoldierBaseDecorator {
    private static final int SHIELD_DEFAULT_BLOCKED_DAMAGE = 2;
    private static final int SHIELD_DEFAULT_DURABILITY = 10;

    private int blockedDamage;
    private int durability;

    public SoldierShieldDecorator(Soldier s) {
        super(s);
        blockedDamage = SHIELD_DEFAULT_BLOCKED_DAMAGE;
        durability = SHIELD_DEFAULT_DURABILITY;
    }

    @Override
    public int hit() {
        return super.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        if (durability > 0) {
            durability--;
            strength = Math.max(0, strength - blockedDamage);
        } else {
            System.out.println("Shield was broken");
        }

        return super.wardOff(strength);
    }
}
