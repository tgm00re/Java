import java.util.ArrayList;
public class Order {
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items;


    public double getTotal(){
        double total = 0;
        for(Item item : this.items){
            total += item.price;
        }
        return total;
    }
}
