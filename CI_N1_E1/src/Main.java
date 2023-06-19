public class Main {

    public static void main(String[] args) {
        //Objectes instanciats normal per constuctor
        Percussio percussio = new Percussio("Tambo 2", 35); //Static block included
        Vent ventIntrument = new Vent("Flauta", 32);
        Corda cordaInstrument = new Corda("Guitara", 100);

        System.out.println(percussio.tocar());
        System.out.println(ventIntrument.tocar());
        System.out.println(cordaInstrument.tocar());

        Vent.metodeStatic();  //Objecte instancidada via metode static

    }
}
