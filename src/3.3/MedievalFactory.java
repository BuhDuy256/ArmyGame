public class MedievalFactory implements EraFactory {
    @Override
    public EraInfantryman createInfantryman() {
        return new MedievalInfantryman();
    }

    @Override
    public EraHorseman createHorseman() {
        return new MedievalHorseman();
    }
}