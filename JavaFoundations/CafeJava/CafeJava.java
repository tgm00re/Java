import java.text.DecimalFormat;


public class CafeJava {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double coffeePrice = 3.73;
        double vanillaMochaPrice = 2.99;
        double waterPrice = 99.98;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Jerry";
        String customer3 = "Katelyn";
        String customer4 = "Arthur";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder1){
            System.out.println(customer1 + ", your order is ready!");
        }
        if(isReadyOrder2){
            System.out.println(customer2 + ", your order is ready!\nYour total is: " + coffeePrice);
        }

        System.out.println(customer3 + ", your total is: " + (vanillaMochaPrice*2));
        if(isReadyOrder3){
            System.out.println(customer3 + ", your order is ready!");
        }

        System.out.println("Sorry, " + customer4 + ", we didn't mean to charge you for a vanilla mocha!\nYour new total is :" + df.format(waterPrice - vanillaMochaPrice));
        
    }
}
