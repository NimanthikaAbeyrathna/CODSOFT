public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        balance += amount;
        return "Deposited $" + amount + ". New balance: $" + balance;
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient funds. Withdrawal failed.";
        } else {
            balance -= amount;
            return "Withdrew $" + amount + ". New balance: $" + balance;
        }
    }

    public String checkBalance() {
        return "Current balance: $" + balance;
    }
}

