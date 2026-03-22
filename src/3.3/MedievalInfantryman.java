public class MedievalInfantryman implements EraInfantryman {
    @Override
    public String getWeapon() {
        return "Sword";
    }

    @Override
    public String getArmor() {
        return "Iron armor";
    }

    @Override
    public void describe() {
        System.out.println("[Medieval] Infantryman | Weapon: " + getWeapon() + " | Armor: " + getArmor());
    }
}