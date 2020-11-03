import java.util.List;

public interface ShopAPI {
    public List<Buket> getBuketter();
    public List<Ordrer> getAllOrders();
    public Ordrer getOrderById(int id);
    public void saveOrder(Ordrer ordrer);
    public void markOrderAsDone(Ordrer ordrer);
}
