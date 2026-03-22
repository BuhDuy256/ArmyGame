import java.util.ArrayList;
import java.util.List;

public class DisplayVisitor implements SoldierVisitor {
    private final List<String> entries;

    public DisplayVisitor() {
        this.entries = new ArrayList<>();
    }

    @Override
    public void visit(SoldierGroup group) {
    }

    @Override
    public void visit(Infantryman infantryman) {
        entries.add("Infantryman | Equipment: None");
    }

    @Override
    public void visit(Horseman horseman) {
        entries.add("Horseman | Equipment: None");
    }

    @Override
    public void visit(ProxySoldier proxySoldier) {
        Soldier baseSoldier = unwrapBase(proxySoldier.getSoldier());
        String typeName = resolveType(baseSoldier);

        List<String> equipments = new ArrayList<>();
        if (proxySoldier.hasShield()) {
            equipments.add("Shield");
        }
        if (proxySoldier.hasSword()) {
            equipments.add("Sword");
        }

        String equipmentInfo = equipments.isEmpty() ? "None" : String.join(", ", equipments);
        entries.add(typeName + " | Equipment: " + equipmentInfo);
    }

    public void printReport() {
        System.out.println("DisplayVisitor Report");
        if (entries.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ". " + entries.get(i));
        }
    }

    private Soldier unwrapBase(Soldier soldier) {
        Soldier current = soldier;
        while (current instanceof SoldierBaseDecorator) {
            current = ((SoldierBaseDecorator) current).getWrappee();
        }

        return current;
    }

    private String resolveType(Soldier soldier) {
        if (soldier instanceof Infantryman) {
            return "Infantryman";
        }

        if (soldier instanceof Horseman) {
            return "Horseman";
        }

        return soldier.getClass().getSimpleName();
    }
}
