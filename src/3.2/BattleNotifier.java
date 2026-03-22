import java.util.ArrayList;
import java.util.List;

public class BattleNotifier {
    private final List<BattleObserver> observers = new ArrayList<>();

    public void addObserver(BattleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BattleObserver observer) {
        observers.remove(observer);
    }

    public void notifySoldierDied(Soldier soldier) {
        for (BattleObserver observer : observers) {
            observer.onSoldierDied(soldier);
        }
    }
}