class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter valid amount");
            return false;
        } else {
            balance += amount;
            System.out.println("Amount Deposited...");
            return true;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter valid amount");
            return;
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawal Successful...");
        }
    }

    public void showBalance() {
        System.out.println("Balance is " + balance);
    }

    public void printDetails() {
        System.out.println("Acc No.: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);

    }
}

public class BankAccountOOPS {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("7896541230", "Harsh", 100);
        b1.deposit(500);
        b1.withdraw(200);
        b1.showBalance();
        b1.printDetails();
    }
}
