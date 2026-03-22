public class MedievalHorseman implements EraHorseman {
    @Override
    public String getWeapon() {
        return "Lance";
    }

    @Override
    public String getArmor() {
        return "Chain mail";
    }

    @Override
    public void describe() {
        System.out.println("[Medieval] Horseman | Weapon: " + getWeapon() + " | Armor: " + getArmor());
    }
}