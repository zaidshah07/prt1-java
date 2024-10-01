public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount() {
        this.accountHolder = "";
        this.balance = 0.0;
    }

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount + " rupees");
        } else {
            System.out.println("Invalid amount to deposit");
        }
    }

    public void deposit(double amount, String currency) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount + " " + currency);
        } else {
            System.out.println("Invalid amount to deposit");
        }
    }

    public void displayAccountInfo(){
        System.out.println("Account  holder name: "+this.accountHolder);
        System.out.println("Balance: "+this.balanc e );
    }

    public static void displayBankName() {
        System.out.println("Welcome to XYZ Bank");
    }

    public static void main(String args[]) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount("Seema");
        BankAccount b3 = new BankAccount(" Reena", 2500.0);
        BankAccount.displayBankName();
        b1.deposit(1000);
        b2.deposit(1500, "USD");
        b1.displayAccountInfo();
        b2.displayAccountInfo();
        b3.displayAccountInfo();
    }
}
