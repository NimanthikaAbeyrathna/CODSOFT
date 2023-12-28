import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("Enter your choice (1-3), or 'q' to quit: ");
    }

    public void run() {
        while (true) {
            displayOptions();
            String choice = scanner.next();

            if (choice.equals("q")) {
                System.out.println("Exiting ATM. Thank you!");
                break;
            } else if (choice.equals("1")) {
                System.out.println("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                String result = account.withdraw(amount);
                System.out.println(result);
            } else if (choice.equals("2")) {
                System.out.println("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                String result = account.deposit(amount);
                System.out.println(result);
            } else if (choice.equals("3")) {
                String result = account.checkBalance();
                System.out.println(result);
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }
    }




}
