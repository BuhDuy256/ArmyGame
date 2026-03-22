public class Main {
    public static void main(String[] args) {
        BattleNotifier notifier = new BattleNotifier();

        notifier.addObserver(DeathCountObserver.getInstance());
        notifier.addObserver(DeathNotifierObserver.getInstance());

        SoldierGroup army = new SoldierGroup(notifier);
        SoldierGroup vanguard = new SoldierGroup(notifier);
        SoldierGroup cavalryWing = new SoldierGroup(notifier);

        vanguard.addSoldier(new Infantryman());
        vanguard.addSoldier(new Infantryman());

        cavalryWing.addSoldier(new Horseman());
        cavalryWing.addSoldier(new Horseman());

        army.addSoldier(vanguard);
        army.addSoldier(cavalryWing);
        army.addSoldier(new Infantryman());

        army.addShield();
        army.addSword();

        System.out.println("Army hit power: " + army.hit());

        army.wardOff(100);
        vanguard.wardOff(50);
        cavalryWing.wardOff(50);
        DeathCountObserver.getInstance().printReport();
        DeathNotifierObserver.getInstance().printReport();
    }
}