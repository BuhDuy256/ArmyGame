public class SciFiHorseman implements EraHorseman {
    @Override
    public String getWeapon() {
        return "Plasma rifle";
    }

    @Override
    public String getArmor() {
        return "Nano armor";
    }

    @Override
    public void describe() {
        System.out.println("[SciFi] Horseman | Weapon: " + getWeapon() + " | Armor: " + getArmor());
    }
}