import java.util.ArrayList;
import java.util.List;

public class DeathNotifierObserver implements BattleObserver {
    private final List<String> fallen = new ArrayList<>();

    @Override
    public void onSoldierDied(Soldier soldier) {
        // Give each soldier an identity for the log
        String name = resolveName(soldier);
        fallen.add(name);
        sendCondolenceEmail(name);
    }

    public void printReport() {
        System.out.println("=== Death Notifier Report ===");
        for (String name : fallen)
            System.out.println("Fallen: " + name);
    }

    private String resolveName(Soldier s) {
        Soldier base = s;
        while (base instanceof SoldierBaseDecorator)
            base = ((SoldierBaseDecorator) base).getWrappee();
        if (base instanceof Infantryman)
            return "Infantryman";
        if (base instanceof Horseman)
            return "Horseman";
        return base.getClass().getSimpleName();
    }

    private void sendCondolenceEmail(String soldierName) {
        // Simulated — replace with real email logic later
        System.out.println("[EMAIL] Sending apology to friends of: " + soldierName);
    }
}