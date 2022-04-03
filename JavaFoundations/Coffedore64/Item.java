
public class Item {

    // Fields
    private String name;
    private double price;
    private short index;

    private static short totalItems;
    
    //Constructor
    public Item(String name, double price){
        this.name = name;
        this.price = price;
        this.index = totalItems;
        totalItems++;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    //Getters    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public short getIndex() {
        return index;
    }
}
