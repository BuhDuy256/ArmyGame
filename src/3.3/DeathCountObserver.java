public class DeathCountObserver implements BattleObserver {
    private static DeathCountObserver instance;

    private int infantryDeaths = 0;
    private int horsemanDeaths = 0;

    private DeathCountObserver() {
    }

    public static DeathCountObserver getInstance() {
        if (instance == null) {
            instance = new DeathCountObserver();
        }
        return instance;
    }

    @Override
    public void onSoldierDied(Soldier soldier) {
        Soldier base = unwrap(soldier);
        if (base instanceof Infantryman)
            infantryDeaths++;
        else if (base instanceof Horseman)
            horsemanDeaths++;
    }

    public void printReport() {
        System.out.println("=== Death Count Report ===");
        System.out.println("Infantrymen killed: " + infantryDeaths);
        System.out.println("Horsemen killed:    " + horsemanDeaths);
    }

    private Soldier unwrap(Soldier s) {
        if (s instanceof ProxySoldier)
            s = ((ProxySoldier) s).getSoldier();
        while (s instanceof SoldierBaseDecorator)
            s = ((SoldierBaseDecorator) s).getWrappee();
        return s;
    }
}