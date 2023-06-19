public class Vent extends Instrument{
    public Vent(String name, int preu) {
        super(name, preu);
    }

    @Override
    String tocar() {
        return "Està sonant un instrument de vent";
    }

    /*
    public static void metodeStatic(){
        System.out.println("Static bloc: La classe Percussió s'ha inicialitzat/carregat!");
    }
     */
}
