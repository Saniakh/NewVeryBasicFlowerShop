import java.util.List;
import java.util.Scanner;

public class Controller implements ShopAPI{
    Scanner sc = new Scanner(System.in);

    public void runProgram(){
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

    private void exit() {
    }

    private void visAktiveBestillinger() {
    }

    private void bestilBuketter() {
    }

    private void visBuketter() {
    }

    private void printMainMenu() {
    }


    @Override
    public List<Buket> getBuketter() {
        return null;
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
