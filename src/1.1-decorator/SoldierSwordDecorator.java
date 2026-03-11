public class SoldierSwordDecorator extends SoldierBaseDecorator {
    private static final int SWORD_SWORD_DEFAULT_ADDED_DAMAGE = 1;

    private int addedDamage;

    public SoldierSwordDecorator(Soldier s) {
        super(s);
        this.addedDamage = SWORD_SWORD_DEFAULT_ADDED_DAMAGE;
    }

    public int hit() {
        System.out.println("SoldierSwordDecorator hit!");
        return super.hit() + addedDamage;
    }

    public boolean wardOff(int strength) {
        System.out.println("SoldierSwordDecorator ward off!");
        return super.wardOff(strength);
    }
}
