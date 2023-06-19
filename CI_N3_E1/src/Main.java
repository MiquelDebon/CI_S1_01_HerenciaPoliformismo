import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Editor> listEditor = new ArrayList<Editor>();
    static final String STRING_AN_ERROR_HAS_OCCUR = "❌️ An error has occurred";
    static final String STRING_WRITE_VALID_VALUE = "❌ Select a valid value/option ✏️: ";


    public static void main(String[] args) {
        boolean exit = false;

        BasquetNew basquetNew1 = new BasquetNew("Titol", "  ", "Madrid");

        System.out.println(basquetNew1.getPrice());


        do{
            switch (menu()){
                case 0:
                    exit = true;
                    break;
                case 1:
                    introduirRedactor();
                    break;
                case 2:
                    deleteRedactor();
                    break;
                case 3:
                    introducirNoticiaRedactor();
                    break;
                case 4:
                    deleteNewByEditor();
                    break;
                case 5:
                    showNewByEditor();
                    break;
                case 6:
                    showAllNews();
                    break;
                case 7:
                    calculatePriceNew();
                    break;
            }

        }while(!exit);
        System.out.println("Bye!!");

    }


    static public int menu(){
        int option = -1;
        System.out.println( "--------------------------------MENU------------------------------------\n" +
                            "   1.Introduir Redactor                5.Mostrar noticies per redacor   \n" +
                            "   2.Eliminar Redactor                 6.Mostrar totes les noticies\n" +
                            "   3.Introduir noticia a Redactor      7.Calcular preu-noticia\n" +
                            "   4.Eliminar noticia(Redacor + titula) ");
        System.out.print("Chose your option ✏️: ");
        return option = inputReturnIntWhileBetweenRange(0,7);
    }

    static public void introduirRedactor(){
        String dni = "";
        String name = "";

        System.out.println("Introduce un Redactor");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("DNI: ");
        dni = scanner.nextLine();

        listEditor.add(new Editor(dni, name));
        System.out.println("Lisa de redactors nº" + listEditor.size() );
    }

    static public void deleteRedactor(){
        String dni = "";
        int index;
        boolean hayRedactor = listEditor.size() > 0;
        boolean rightDNI = false;

        if(hayRedactor){
            do{
                System.out.print("DNI: ");
                dni = scanner.nextLine();
                index = findRedactorByDNI(dni);
                rightDNI = index != -1;
            }while(!rightDNI);
            listEditor.remove(index);
        }else{
            System.out.println("There are no Writter");
        }
    }


    static void introducirNoticiaRedactor(){
        String dni = "";
        Editor editor = null;
        int index;
        boolean hayRedactor = listEditor.size() > 0;
        boolean rightDNI = false;

        if(hayRedactor){
            do{
                System.out.print("DNI: ");
                dni = scanner.nextLine();
                index = findRedactorByDNI(dni);
                rightDNI = index != -1;
            }while(!rightDNI);
            editor = listEditor.get(index);
            editor.setAddNews( createNew());
        }else{
            System.out.println("There are no Writter");
        }
    }

    static void deleteNewByEditor(){
        Editor editor = null;
        String dni = "";
        int index;
        int indexNew ;
        String title = "";
        boolean hayRedactor = listEditor.size() > 0;
        boolean hayNews = false;
        boolean rightDNI = false;
        boolean rightTitle = false;

        if(hayRedactor){
            do{
                System.out.print("DNI: ");
                dni = scanner.nextLine();
                index = findRedactorByDNI(dni);
                rightDNI = index != -1;
            }while(!rightDNI);
            editor = listEditor.get(index);
            hayNews = editor.getNews().size() > 0;
            if(hayNews){
                do{
                    System.out.println(editor.getNews());
                    System.out.print("Title:");
                    title = scanner.nextLine();
                    indexNew = findNewByEditor(editor, title);
                    rightTitle = indexNew != -1;
                }while(!rightTitle);
                editor.deleteNew(indexNew);
            }else{
                System.out.println("This Editor does not have news");
            }
        }else{
            System.out.println("There are no Writter");
        }
    }

    static void showNewByEditor(){
        Editor editor = null;
        String dni = "";
        int index;
        boolean hayRedactor = listEditor.size() > 0;
        boolean hayNews = false;
        boolean rightDNI = false;

        if(hayRedactor){
            do{
                System.out.print("DNI: ");
                dni = scanner.nextLine();
                index = findRedactorByDNI(dni);
                rightDNI = index != -1;
            }while(!rightDNI);
            editor = listEditor.get(index);
            hayNews = editor.getNews().size() > 0;
            if(hayNews){
                System.out.println(editor.getNews());
            }else{
                System.out.println("This Editor does not have news");
            }
        }else{
            System.out.println("There are no Writter");
        }
    }

    static New createNew(){
        int option  = -1;
        String title;
        String competition;
        String club;
        String player;
        String team;
        New freshNew = null;
        System.out.println( "There are these news:\n" +
                            "   1.Football      4.F1\n" +
                            "   2.Basquet       5.MotorBikes\n" +
                            "   3.Tenis");
        System.out.print("What new do you want to create? ");
        option = inputReturnIntWhileBetweenRange(1, 3);
        System.out.print("Title: ");
        title = scanner.nextLine();
        switch (option){
            case 1://Football
                System.out.print("Competition: ");
                competition = scanner.nextLine();
                System.out.print("Club: ");
                club = scanner.nextLine();
                System.out.print("Player: ");
                player = scanner.nextLine();
                freshNew = new FootballNew(title, competition, club, player);
                break;
            case 2://Basquet
                System.out.print("Competition: ");
                competition = scanner.nextLine();
                System.out.print("Club: ");
                club = scanner.nextLine();
                freshNew = new BasquetNew(title, competition, club);
                break;
            case 3://Tenis
                System.out.print("Competition: ");
                competition = scanner.nextLine();
                System.out.print("Player: ");
                player = scanner.nextLine();
                freshNew = new tenisNew(title, competition, player);
                break;
            case 4://F1
                System.out.print("Team: ");
                team = scanner.nextLine();
                freshNew = new F1New(title, team);
                break;
            case 5://Motorbike
                System.out.print("Team: ");
                team = scanner.nextLine();
                freshNew = new bikesNew(title, team);
                break;
        }
        return freshNew;
    }

    static void showAllNews(){
        Editor edit = null;
        New freshnew  = null;

        System.out.println("Show all news");
        for(int i=0; i<listEditor.size(); i++){
            edit = listEditor.get(i);
            for(int j=0; j<edit.getNews().size(); j++){
                freshnew = edit.getNews().get(j);
                System.out.println(freshnew);
            }
        }

    }

    static void calculatePriceNew(){
        Editor editor = null;
        String dni = "";
        int index;
        int indexNew ;
        String title = "";
        boolean hayRedactor = listEditor.size() > 0;
        boolean hayNews = false;
        boolean rightDNI = false;
        boolean rightTitle = false;

        if(hayRedactor){
            do{
                System.out.print("DNI: ");
                dni = scanner.nextLine();
                index = findRedactorByDNI(dni);
                rightDNI = index != -1;
            }while(!rightDNI);
            editor = listEditor.get(index);
            hayNews = editor.getNews().size() > 0;
            if(hayNews){
                do{
                    System.out.println(editor.getNews());
                    System.out.print("Title:");
                    title = scanner.nextLine();
                    indexNew = findNewByEditor(editor, title);
                    rightTitle = indexNew != -1;
                }while(!rightTitle);
                int price = (editor.getNews().get(indexNew).getPrice());
                int punctuation = editor.getNews().get(indexNew).getPuntuation();
                System.out.println("The actual price is " + price);
                System.out.println("The actual punctuation is " + punctuation);
            }else{
                System.out.println("This Editor does not have news");
            }
        }else{
            System.out.println("There are no Writter");
        }
    }



    static int findRedactorByDNI(String dni){
        int index = -1;
        for(int i=0; i<listEditor.size(); i++){
            if(listEditor.get(i).getDNI().equalsIgnoreCase(dni)){
                index = i;
                i = listEditor.size();
            }
        }
        return index;
    }

    static int findNewByEditor(Editor editor, String title){
        int index = -1;
        for(int i = 0; i<editor.getNews().size(); i++){
            String news = editor.getNews().get(i).getTitle();
            if(title.equalsIgnoreCase(news)){
                index = i;
                i = editor.getNews().size();
            }
        }
        return index;
    }


    public static int inputReturnIntWhileBetweenRange(int valorInferiorInclos , int valorSuperiorInclos) {
        int numero = 0;
        boolean correcto = false;

        do {
            try {
                numero = scanner.nextInt();
                correcto = (numero >= valorInferiorInclos && numero <= valorSuperiorInclos) ? true : false;
                if(!correcto){
                    System.out.print(STRING_WRITE_VALID_VALUE);
                }
            } catch (InputMismatchException ex) {
                System.out.print(STRING_WRITE_VALID_VALUE);
            }
            scanner.nextLine();
        } while (!correcto);
        return numero;
    }

}

/*
Class Redacctor
    -final int DNI
    -String nom
    -static int sou : base 1500;
    -ArrayList<Noticia>

Class Noticia
    -String titul
    -String text : buit al crear
    -int puntuacio
    -int preu

    Clase Futbol extend Noticia
        -String competicio
        -String club
        -String jugador

    Clase Basquet extend Noticia
        -String competicio
        -String club

    Clase Tenis extend Noticia
        -String competicio
        -String tenistes

    Clase F1 extend Noticia
        -String escuderia

    Clase Motociclisme
        -String equips

Interficie PreuNoticia
    calcularPreuNoticia()

Interficie CalcularPuntuacio

 */


