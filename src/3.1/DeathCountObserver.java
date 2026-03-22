public class DeathCountObserver implements BattleObserver {
    private int infantryDeaths = 0;
    private int horsemanDeaths = 0;

    @Override
    public void onSoldierDied(Soldier soldier) {
        Soldier base = unwrap(soldier);
        if (base instanceof Infantryman)
            infantryDeaths++;
        else if (base instanceof Horseman)
            horsemanDeaths++;
        else
            System.out.println("Unknown soldier type died: " + base.getClass().getSimpleName());
    }

    public void printReport() {
        System.out.println("=== Death Count Report ===");
        System.out.println("Infantrymen killed: " + infantryDeaths);
        System.out.println("Horsemen killed:    " + horsemanDeaths);
    }

    private Soldier unwrap(Soldier s) {
        if (s instanceof ProxySoldier) {
            s = ((ProxySoldier) s).getSoldier();
        }

        while (s instanceof SoldierBaseDecorator) {
            s = ((SoldierBaseDecorator) s).getWrappee();
        }

        return s;
    }
}