public class Percussio extends Instrument{
    public Percussio(String name, int preu) {
        super(name, preu);
    }



    @Override
    String tocar() {
        return "Està sonant un instrument de percussió";
    }

    {
        System.out.println("    Instance block: (Multiple times appears)\n");
    }

    static {
        System.out.println("Static block: Clase de Percussió (1 cop ha de apareixer)");
    }

}
