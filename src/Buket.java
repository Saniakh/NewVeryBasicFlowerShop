public class Buket {
    int id;
    String name;
    int basePrice;

    public Buket(int id, String name, int basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String show = "";
        show = String.format("%d,%s,%d",id,name,basePrice);
        return show;
    }
}
