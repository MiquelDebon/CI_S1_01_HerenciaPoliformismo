import java.util.ArrayList;

public class Editor {
    private final String DNI;
    private final String name;
    private static int salary = 1500;
    private ArrayList<New> news;


    public Editor(String DNI, String name){
        this.DNI = DNI;
        this.name = name;
        this.news = new ArrayList<New>();
    }


    public String getDNI() {
        return this.DNI;
    }
    public String getName() {
        return this.name;
    }
    public static int getSalary() {
        return Editor.salary;
    }
    public ArrayList<New> getNews() {
        return this.news;
    }
    public void deleteNew(int index){
        this.news.remove(index);
    }


    public static void setSalary(int salary) {
        Editor.salary = salary;
    }
    public static void increaseSalary(int rise){
        Editor.salary = Editor.salary + rise;
    }
    public void setAddNews(New news) {
        this.news.add(news);
    }


    @Override
    public String toString() {
        return String.format("Name '%s', DNI: %s, Salary: %d\n",
                this.name, this.DNI, Editor.salary);
    }
}
