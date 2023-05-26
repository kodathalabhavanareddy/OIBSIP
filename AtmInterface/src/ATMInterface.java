import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMInterface {
    private static double balance = 0; // Initial balance
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your ATM pin ID: ");
        String pinId = scanner.nextLine();

        while (true) {
            System.out.println("\nHello, " + username + "! Please select an option:");
            System.out.println("1. Transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;               
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's username: ");
                    scanner.nextLine(); 
                    String recipient = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    transfer(recipient, transferAmount);
                    break;                
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    private static void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }   
    private static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance is: $" + balance);
            transactionHistory.add("Withdrawal: $" + amount);
        }
    }
    private static void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        System.out.println("New balance is: $" + balance);
        transactionHistory.add("Deposit: $" + amount);
    }

    private static void transfer(String recipient, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Transfer canceled.");
        } else {
            balance -= amount;
            System.out.println("Transferred: $" + amount + " to " + recipient);
            System.out.println("New balance is: $" + balance);
            transactionHistory.add("Transfer: $" + amount + " to " + recipient);
        }
    }

    
}
