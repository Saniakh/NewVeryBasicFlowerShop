import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordrer {
    static int counter = 0;
    int ordreID;
    LocalDateTime createTime;
    List<Buket> buketter;
    String status;

    public Ordrer() {
        this.ordreID = counter;
        this.createTime = LocalDateTime.now();
        this.buketter = new ArrayList<>();
        this.status = "CREATED";
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
}
