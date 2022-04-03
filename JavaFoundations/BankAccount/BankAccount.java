
public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private long accountNumber;
    public static int totalAccounts;
    public static double totalMoneyAcrossAccounts;

    public BankAccount(){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = this.getRandomAccountNumber();
        totalAccounts++;
    }


    private long getRandomAccountNumber(){
        return (long) Math.floor(Math.random() * (9999999999L - 1000000000 + 1)) + 1000000000;
    }

    // Adding Money
    public void addMoneyToCheckingAccount(double amount){
        addMoney("checking", amount);
    }

    public void addMoneyToSavingsAccount(double amount){
        addMoney("savings", amount);
    }

    private void addMoney(String accountType, double amount){
        if(accountType == "checking"){
            this.checkingBalance += amount;
        } else if(accountType == "savings"){
            this.savingsBalance += amount;
        } else {
            throw new IllegalArgumentException();
        }
        totalMoneyAcrossAccounts += amount;
    }


    //Withdrawing Money 

    public void withdrawalMoneyFromCheckingAccount(double amount){
        this.withdrawalMoney("checking", amount);
    }

    public void withdrawalMoneyFromSavingsAccount(double amount){
        this.withdrawalMoney("savings", amount);
    }


    private void withdrawalMoney(String accountType, double amount){
        if(accountType == "checking"){
            if(this.checkingBalance >= amount){
                this.checkingBalance -= amount;
            } else {
                System.out.println("Sorry, you don't have enough money in your account!");
            }
        } else if(accountType == "savings"){
            if(this.savingsBalance >= amount){
                this.savingsBalance -= amount;
            } else{
                System.out.println("Sorry, you don't have enough money in your account!");
            }
        } else{
            throw new IllegalArgumentException();
        }
        totalMoneyAcrossAccounts -= amount;
    }

    // Getters
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
    
}
