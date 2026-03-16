public class SoldierShieldDecorator extends SoldierBaseDecorator {
    private static final int SHIELD_DEFAULT_BLOCKED_DAMAGE = 2;

    private int blockedDamage;

    public SoldierShieldDecorator(Soldier s) {
        super(s);
        blockedDamage = SHIELD_DEFAULT_BLOCKED_DAMAGE;
    }

    public int hit() {
        System.out.println("SoldierShieldDecorator hit!");
        return super.hit();
    }

    public boolean wardOff(int strength) {
        System.out.println("SoldierShieldDecorator ward off!");
        return super.wardOff(strength - this.blockedDamage);
    }
}
