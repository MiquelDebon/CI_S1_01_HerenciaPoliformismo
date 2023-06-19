public class Corda extends Instrument {
    public Corda(String name, int preu) {
        super(name, preu);
    }

    @Override
    String tocar() {
        return "Està sonant un instrument de corda";
    }
}
