public class WorldWarInfantryman implements EraInfantryman {
    @Override
    public String getWeapon() {
        return "Rifle";
    }

    @Override
    public String getArmor() {
        return "Steel helmet";
    }

    @Override
    public void describe() {
        System.out.println("[WorldWar] Infantryman | Weapon: " + getWeapon() + " | Armor: " + getArmor());
    }
}