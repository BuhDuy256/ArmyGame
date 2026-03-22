public class CountVisitor implements SoldierVisitor {
    private int infantryCount;
    private int horsemanCount;

    @Override
    public void visit(SoldierGroup group) {
    }

    @Override
    public void visit(Infantryman infantryman) {
        infantryCount++;
    }

    @Override
    public void visit(Horseman horseman) {
        horsemanCount++;
    }

    @Override
    public void visit(ProxySoldier proxySoldier) {
        Soldier base = unwrapBase(proxySoldier.getSoldier());
        if (base instanceof Infantryman) {
            infantryCount++;
            return;
        }

        if (base instanceof Horseman) {
            horsemanCount++;
        }
    }

    public int getInfantryCount() {
        return infantryCount;
    }

    public int getHorsemanCount() {
        return horsemanCount;
    }

    public void printReport() {
        System.out.println("CountVisitor Report");
        System.out.println("Infantryman count: " + infantryCount);
        System.out.println("Horseman count: " + horsemanCount);
    }

    private Soldier unwrapBase(Soldier soldier) {
        Soldier current = soldier;
        while (current instanceof SoldierBaseDecorator) {
            current = ((SoldierBaseDecorator) current).getWrappee();
        }

        return current;
    }
}
