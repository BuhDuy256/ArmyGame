import java.util.ArrayList;
import java.util.List;

public class DeathNotifierObserver implements BattleObserver {
    private static DeathNotifierObserver instance;

    private final List<String> fallen = new ArrayList<>();

    private DeathNotifierObserver() {
    }

    public static DeathNotifierObserver getInstance() {
        if (instance == null) {
            instance = new DeathNotifierObserver();
        }
        return instance;
    }

    @Override
    public void onSoldierDied(Soldier soldier) {
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
        if (s instanceof ProxySoldier)
            s = ((ProxySoldier) s).getSoldier();
        while (s instanceof SoldierBaseDecorator)
            s = ((SoldierBaseDecorator) s).getWrappee();
        if (s instanceof Infantryman)
            return "Infantryman";
        if (s instanceof Horseman)
            return "Horseman";
        return s.getClass().getSimpleName();
    }

    private void sendCondolenceEmail(String name) {
        System.out.println("[EMAIL] Apology sent for: " + name);
    }
}