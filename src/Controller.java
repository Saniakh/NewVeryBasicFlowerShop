import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements ShopAPI{
    Scanner sc = new Scanner(System.in);
    List<Buket> buketter = new ArrayList<>();

    public void runProgram(){
        buketter = getBuketter();
        int choice = 0;
        printMainMenu();
        while (choice != 9) {
            // få brugerens valg
            choice = sc.nextInt();
            // switch på valget
            switch (choice) {
                case 1:visBuketter();break;
                case 2:bestilBuketter();break;
                case 3:visAktiveBestillinger();break;
                case 9:exit();break;
                default: exit();
            }


        }
        // vis buketter
        // få kundens valg (1 eller flere)
        // få kundens nr
        // vis en pris
        // få kundens accept
        // gem ordren i en liste af aktive ordre
        // vis en liste af aktive ordrer
        // markér en ordre som udført
        // gem den udførte ordre i en fil
        // hent dagens ordre ud i en liste


    }

    private void printMainMenu() {
        System.out.println("1) vis buketter");
        System.out.println("2) bestil buketter");
        System.out.println("3) vis/rediger aktive bestillinger");
        System.out.println("4) hent dagens bestillinger");
        System.out.println("9) exit");
    }

    private void visBuketter() {
        for (Buket buket: buketter ) {
            System.out.println(buket);
        }
    }

    private void exit() {
    }

    private void visAktiveBestillinger() {
    }

    private void bestilBuketter() {
    }




    @Override
    public List<Buket> getBuketter() {
        Buket buket = null;
        List<Buket> buketter = new ArrayList<>();
        buket = new Buket(1,"Arranger selv bundt",225);
        buketter.add(buket);
        buket = new Buket(2,"Unika blomsterbuket",325);
        buketter.add(buket);
        buket = new Buket(3,"Trendy efterårsbuket",275);
        buketter.add(buket);

        return buketter;
    }

    @Override
    public List<Ordrer> getAllOrders() {
        return null;
    }

    @Override
    public Ordrer getOrderById(int id) {
        return null;
    }

    @Override
    public void saveOrder(Ordrer ordrer) {

    }

    @Override
    public void markOrderAsDone(Ordrer ordrer) {

    }
}
