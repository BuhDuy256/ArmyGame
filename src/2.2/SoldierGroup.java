import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoldierGroup implements Soldier {
    private List<Soldier> soldiers;

    public SoldierGroup() {
        this.soldiers = new ArrayList<>();
    }

    public void addSoldier(Soldier s) {
        soldiers.add(s);
    }

    public void removeSoldier(Soldier s) {
        soldiers.remove(s);
    }

    public void addShield() {
        for (int i = 0; i < soldiers.size(); i++) {
            Soldier soldier = soldiers.get(i);

            if (soldier instanceof SoldierGroup) {
                ((SoldierGroup) soldier).addShield();
                continue;
            }

            ProxySoldier proxy = toProxySoldier(soldier);
            proxy.addShield();
            soldiers.set(i, proxy);
        }
    }

    public void addSword() {
        for (int i = 0; i < soldiers.size(); i++) {
            Soldier soldier = soldiers.get(i);

            if (soldier instanceof SoldierGroup) {
                ((SoldierGroup) soldier).addSword();
                continue;
            }

            ProxySoldier proxy = toProxySoldier(soldier);
            proxy.addSword();
            soldiers.set(i, proxy);
        }
    }

    public int hit() {
        return soldiers.stream().mapToInt(Soldier::hit).sum();
    }

    public boolean wardOff(int strength) {
        if (soldiers.isEmpty()) {
            return false;
        }

        int memberCount = soldiers.size();
        int baseDamage = strength / memberCount;
        int remainder = strength % memberCount;

        List<Soldier> survivors = new ArrayList<>();
        for (int i = 0; i < memberCount; i++) {
            Soldier soldier = soldiers.get(i);
            int distributedDamage = baseDamage + (i < remainder ? 1 : 0);
            if (soldier.wardOff(distributedDamage)) {
                survivors.add(soldier);
            }
        }

        soldiers = survivors;
        return !soldiers.isEmpty();
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
        for (Soldier soldier : soldiers) {
            soldier.accept(visitor);
        }
    }

    public List<Soldier> getSoldiers() {
        return Collections.unmodifiableList(this.soldiers);
    }

    private ProxySoldier toProxySoldier(Soldier soldier) {
        if (soldier instanceof ProxySoldier) {
            return (ProxySoldier) soldier;
        }

        return new ProxySoldier(soldier);
    }
}
