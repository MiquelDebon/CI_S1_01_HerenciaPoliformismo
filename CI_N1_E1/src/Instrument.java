public abstract class Instrument {

    private String name;
    private int preu;


    public Instrument(String name, int preu){
        this.name = name;
        this.preu = preu;
    }


    public String getName() {
        return this.name;
    }
    public int getPreu() {
        return this.preu;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setPreu(int preu) {
        this.preu = preu;
    }


    abstract String tocar();
}
