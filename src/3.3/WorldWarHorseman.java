public class WorldWarHorseman implements EraHorseman {
    @Override
    public String getWeapon() {
        return "Grenade";
    }

    @Override
    public String getArmor() {
        return "Steel helmet";
    }

    @Override
    public void describe() {
        System.out.println("[WorldWar] Horseman | Weapon: " + getWeapon() + " | Armor: " + getArmor());
    }
}