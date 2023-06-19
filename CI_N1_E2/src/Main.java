public class Main {
    public static void main(String[] args) {

        //Metode frenar - Sense instanciar un Ctoxe puc inicialitzar el metode
        Cotxe.frenar();

        //Metode accelear - Requereix instanciar un objecte de la clase Cotxe
        Cotxe cotxe1 = new Cotxe(33);
        cotxe1.accelerar();


    }
}
