public class Main {

    public static void main(String[] args) {
        Percussio percussio = new Percussio("Tambo 2", 35);
        Vent ventIntrument = new Vent("Flauta", 32);
        Corda cordaInstrument = new Corda("Guitara", 100);

        System.out.println(percussio.tocar());
        System.out.println(ventIntrument.tocar());
        System.out.println(cordaInstrument.tocar());

        Vent.metodeStatic();

    }
}
