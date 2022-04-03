public class BankAccountTest {
    public static void main(String[] args) {


        BankAccount myBankAccount = new BankAccount();
        System.out.println(myBankAccount.getAccountNumber());  
        // System.out.println(BankAccount.totalAccounts);
        BankAccount bankAccountTwo = new BankAccount();
        // System.out.println(BankAccount.totalAccounts);

        // System.out.println(myBankAccount.getCheckingBalance());
        // System.out.println(myBankAccount.getSavingsBalance());

        myBankAccount.addMoneyToSavingsAccount(100.0);
        myBankAccount.withdrawalMoneyFromSavingsAccount(50.0);

        System.out.println(BankAccount.totalMoneyAcrossAccounts);

        // System.out.println(myBankAccount.getSavingsBalance());

        myBankAccount.addMoneyToCheckingAccount(125.0);
        myBankAccount.withdrawalMoneyFromCheckingAccount(50.0);

        System.out.println(BankAccount.totalMoneyAcrossAccounts);

        // System.out.println(myBankAccount.getCheckingBalance());



    }
}
