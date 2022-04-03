import java.text.DecimalFormat;
import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this("Guest");
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    
    // ORDER METHODS
    public void addItem(Item itemToAdd){
        this.items.add(itemToAdd);
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready!";
        }
        return "Your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total = 0;
        for(Item item : this.items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: " + this.name);
        for(Item item : this.items){
            System.out.println(item.getName() + " - $" + df.format(item.getPrice()));
        }
        System.out.println("Total: $" + df.format(this.getOrderTotal()));

    }
    
    
    // GETTERS
    public String getName() {
        return name;
    }

    public boolean isReady() {
        return ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
}

