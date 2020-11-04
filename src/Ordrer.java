import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordrer {
    static int counter = 0;
    int ordreID;
    int phone;
    LocalDateTime createTime;
    List<Buket> buketter;
    String status;

    public Ordrer() {
        this.ordreID = counter;
        this.createTime = LocalDateTime.now();
        this.buketter = new ArrayList<>();
        this.status = "CREATED";
        counter++;
    }

    public int getOrdreID() {
        return ordreID;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public List<Buket> getBuketter() {
        return buketter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addBuket(Buket buket) {
        this.buketter.add(buket);
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPrice() {
        int price = 0;
        for(Buket buket: buketter) {
            price += buket.getBasePrice();
        }
        return price;
    }

    public String toString() {
        int price = this.getPrice();
        String show = "";
        String buketterStr = "@";
        for(Buket buket: buketter) {
            buketterStr += buket.toString();
        }
        buketterStr += "@";
        //show = String.format("%d phone: %d, %s, price: %d, status: %s\n",ordreID,phone,buketterStr,price, status);
        show = String.format("%d;%d;%s;%d;%s",ordreID,phone,buketterStr,price, status);
        return show;
    }

}
