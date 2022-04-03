import java.text.DecimalFormat;
import java.util.ArrayList;
public class TestOrders {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Item item1 = new Item();
        item1.name = "Item 1";
        item1.price = 32.49;

        Item item2 = new Item();
        item2.name = "Item 2";
        item2.price = 1.34;

        Item item3 = new Item();
        item3.name = "Item 3";
        item3.price = 7.24;

        
        Order order1 = new Order();
        order1.name = "Order 1";

        order1.items = new ArrayList<Item>();
        order1.items.add(item1);
        order1.items.add(item2);
        order1.items.add(item3);

        order1.total = order1.getTotal();

        order1.ready = true;

        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", df.format(order1.total));
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
