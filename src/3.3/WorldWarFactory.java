public class WorldWarFactory implements EraFactory {
    @Override
    public EraInfantryman createInfantryman() {
        return new WorldWarInfantryman();
    }

    @Override
    public EraHorseman createHorseman() {
        return new WorldWarHorseman();
    }
}