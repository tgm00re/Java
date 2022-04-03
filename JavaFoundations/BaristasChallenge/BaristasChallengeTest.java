public class BaristasChallengeTest {
    public static void main(String[] args) {
        // Items
        Item item1 = new Item("drip coffee", 1.50);
        Item item2 = new Item("capuccino", 3.50);

        Order order1 = new Order();
        order1.addItem(item1);
        order1.addItem(item2);

        // order1.display();
        // System.out.println(order1.isReady());
        // System.out.println(order1.getStatusMessage());
        // order1.setReady(true);
        // System.out.println(order1.isReady());
        // System.out.println(order1.getStatusMessage());

        Order order2 = new Order("Jerry");
        order2.addItem(item1);
        order2.addItem(item2);

        order2.display();
    }
}
