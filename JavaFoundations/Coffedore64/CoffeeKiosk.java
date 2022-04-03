import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item itemToAdd = new Item(name, price);
        this.menu.add(itemToAdd);
    }

    public void displayMenu(){
        for(Item item : this.menu){
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);

        // Show the user the menu, so they can choose items to add.
        this.displayMenu();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            if(Integer.parseInt(itemNumber) >= this.menu.size() || Integer.parseInt(itemNumber) < 0 ){
                System.out.println("Sorry, that is a not a valid item number!");
            } else {
                newOrder.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            }

        System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        newOrder.display();
        this.orders.add(newOrder);
        
    }
    
}
