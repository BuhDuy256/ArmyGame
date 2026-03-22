public class Main {
    public static void main(String[] args) {
        // EraFactory factory = new MedievalFactory();
        // EraFactory factory = new WorldWarFactory();
        EraFactory factory = new SciFiFactory();

        EraInfantryman inf = factory.createInfantryman();
        EraHorseman hor = factory.createHorseman();

        inf.describe();
        hor.describe();
    }
}