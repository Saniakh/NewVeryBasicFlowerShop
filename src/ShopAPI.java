import java.io.IOException;
import java.util.List;

public interface ShopAPI {
    public List<Buket> getBuketter();
    public Ordrer getOrderById(int id) throws NoSuchOrderException;
    public Buket getBuketById(int id) throws NoSuchBuketException;
    public void saveOrder(Ordrer ordrer) throws IOException;
}
