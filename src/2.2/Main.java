public class Main {
    public static void main(String[] args) {
        SoldierGroup army = new SoldierGroup();
        SoldierGroup vanguard = new SoldierGroup();
        SoldierGroup cavalryWing = new SoldierGroup();

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

        DisplayVisitor displayVisitor = new DisplayVisitor();
        army.accept(displayVisitor);
        displayVisitor.printReport();

        CountVisitor countVisitor = new CountVisitor();
        army.accept(countVisitor);
        countVisitor.printReport();
    }
}