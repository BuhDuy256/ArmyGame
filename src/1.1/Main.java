public class Main {
    public static void main(String[] args) {
        Soldier infantryman = new SoldierShieldDecorator(new SoldierSwordDecorator(new Infantryman()));
        infantryman.hit();
    }
}