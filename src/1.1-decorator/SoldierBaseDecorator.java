public class SoldierBaseDecorator implements Soldier {
    private Soldier wrappee;

    public SoldierBaseDecorator(Soldier s) {
        this.wrappee = s;
    }

    @Override
    public int hit() {
        return this.wrappee.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return this.wrappee.wardOff(strength);
    }
}
