import netscape.javascript.JSObject;

public class Cotxe {
    private static final String marca = "BMW";  //S'ha d'assignar al moment - no es pot declarar al construcuctor xqe es statica final
    private static String model;                //Es pot declarar al constructor, pero cambiara cada cop que s'instancii un objecte
    private final int potencia;                 //Si que es pot declarar al constructor

    //https://www.tutorialspoint.com/can-we-initialize-static-variables-in-a-default-constructor-in-java
    //In this link you can find further information about it

    public Cotxe(int potencia){
        //Cotxe.model = "model"; Would affect to all objects
        this.potencia = potencia; //Te sentit
    }


    public static String getMarca(){
        return Cotxe.marca;
    }
    public static String getModel() {
        return Cotxe.model;
    }
    public int getPotencia() {
        return this.potencia;
    }


    public static void setModel(String model) {
        Cotxe.model = model;
    }


    public static void frenar(){
        System.out.println("El vehicle està frenant");
    }

    public void accelerar(){
        System.out.println("El vehicle està accelerant");
    }

}
