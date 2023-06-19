public class Telefon {
    private String marca;
    private String model;


    public Telefon(String marca, String model){
        this.marca = marca;
        this.model = model;
    }


    public void trucar(String numero){
        System.out.printf("S'està trucant al número rebut \n", numero);
    }
}
