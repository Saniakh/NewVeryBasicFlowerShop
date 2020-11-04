import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements ShopAPI{
    Scanner sc = new Scanner(System.in);
    List<Buket> buketter = new ArrayList<>();
    List<Ordrer> bestillinger = new ArrayList<>();

    public void runProgram(){
        buketter = getBuketter();
        int choice = 0;
        printMainMenu();
        while (choice != 9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:visBuketter();break;
                case 2:bestilBuketter();break;
                case 3:visAktiveBestillinger();break;
                case 4:visDagensOrdrer();break;
                case 9:exit();break;
                default: exit();
            }
        }
    }

    private void visDagensOrdrer() {
        // TODO:hent fra fil og lav stat
        File file = new File("resources/bestillinger.csv");
        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!=null) {
                String[] lineArr = line.split(";");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
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
        printMainMenu();
    }

    private void bestilBuketter() {
        Ordrer ordrer = new Ordrer();
        List<Buket> buketter = new ArrayList<>();
        int phone = 0;
        int choice = 0;
        boolean verify = false;
        int buketId = 0;
        Buket buket = null;
        System.out.println("Telefonnummer?");
        phone = sc.nextInt();
        ordrer.setPhone(phone);
        while(buketId != 99) {
            System.out.println("Buket nr (99 for exit)");
            buketId = sc.nextInt();
            if (buketId != 99) {
                try {
                    buket = getBuketById(buketId);
                    ordrer.addBuket(buket);
                } catch (NoSuchBuketException e) {
                    e.printStackTrace();
                    choice = 99;
                }
            }
        }
        while(!verify) {
            verify = editOrder(ordrer);
        }
        bestillinger.add(ordrer);
        printMainMenu();
    }

    private boolean editOrder(Ordrer ordrer) {
        boolean retval = true;
        return  retval;
    }

    private void exit() {
        System.out.println("Exiting ..");
    }

    private void visAktiveBestillinger() {
        int choice = 0;
        System.out.println("Pick orderid to mark as done (99 to skip)");
        // TODO:filtrer på status
        for (Ordrer ordrer: bestillinger ) {
            System.out.println(ordrer);
        }
        choice = sc.nextInt();
        if (choice != 99) {
            try {
                Ordrer order = getOrderById(choice);
                order.setStatus("DONE");
                saveOrder(order);
            }catch (IOException e) {
                e.printStackTrace();
            }catch (NoSuchOrderException e) {
                e.getMessage();
            }
        }
        printMainMenu();
    }

    @Override
    public List<Buket> getBuketter() {
        List<Buket> buketter = new ArrayList<>();
        Buket buket = null;
        File file = new File("resources/fc");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int counter = 1;
            while((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");
                buket = new Buket(counter,lineArr[0],Integer.parseInt(lineArr[1]));
                buketter.add(buket);
                counter++;
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
        return buketter;
    }

    @Override
    public Ordrer getOrderById(int id) throws NoSuchOrderException {
        Ordrer retVal = null;
        for(Ordrer ordrer:bestillinger) {
            if (ordrer.getOrdreID() == id) {
                return ordrer;
            }
        }
        if (retVal == null) {
            throw new NoSuchOrderException("No order by id " + id);
        }
        return retVal;
    }

    @Override
    public Buket getBuketById(int id) throws NoSuchBuketException {
        Buket buket = null;
        try {
            buket = buketter.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchBuketException ("Buket findes ikke");
        }
        if (buket == null) {
            throw new NoSuchBuketException ("Buket findes ikke");
        }
        return buket;
    }

    @Override
    public void saveOrder(Ordrer ordrer) throws IOException {
        File file = new File("resources/bestillinger.csv");
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ordrer.toString());
        bw.newLine();
        bw.close();
        fw.close();
    }
}
