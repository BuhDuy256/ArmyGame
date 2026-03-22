public class SciFiInfantryman implements EraInfantryman {
    @Override
    public String getWeapon() {
        return "Laser sword";
    }

    @Override
    public String getArmor() {
        return "Nano armor";
    }

    @Override
    public void describe() {
        System.out.println("[SciFi] Infantryman | Weapon: " + getWeapon() + " | Armor: " + getArmor());
    }
}