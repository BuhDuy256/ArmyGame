public class SciFiFactory implements EraFactory {
    @Override
    public EraInfantryman createInfantryman() {
        return new SciFiInfantryman();
    }

    @Override
    public EraHorseman createHorseman() {
        return new SciFiHorseman();
    }
}