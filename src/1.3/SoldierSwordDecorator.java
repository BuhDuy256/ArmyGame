public class SoldierSwordDecorator extends SoldierBaseDecorator {
    private static final int SWORD_DEFAULT_ADDED_DAMAGE = 1;
    private static final int SWORD_DEFAULT_DURABILITY = 10;

    private int addedDamage;
    private int durability;

    public SoldierSwordDecorator(Soldier s) {
        super(s);
        this.addedDamage = SWORD_DEFAULT_ADDED_DAMAGE;
        this.durability = SWORD_DEFAULT_DURABILITY;
    }

    @Override
    public int hit() {
        int baseDamage = super.hit();
        
        if (durability > 0) {
            durability--;
            baseDamage += addedDamage;
        } else {
            System.out.println("Sword was broken!");
        }
        
        return baseDamage;
    }

    @Override
    public boolean wardOff(int strength) {
        return super.wardOff(strength);
    }
}
