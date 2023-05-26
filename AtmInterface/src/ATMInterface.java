import java.util.*;

public class ATMInterface {    
    private static List<String> transactionHistory = new ArrayList<>();
    private static double balance = 0; 

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your username: ");
        String username = s.nextLine();
        System.out.print("Enter your ATM pin ID: ");
        String pin = s.nextLine();

        while (true) {
            System.out.println("\nWelcome, " + username + "! Please choose an option:");
            System.out.println("1. Transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    transactionHistory();
                    break;               
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = s.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = s.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's username: ");
                    s.nextLine(); 
                    String recipient = s.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = s.nextDouble();
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
    private static void transactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }   
    private static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!!");
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
            System.out.println("Insufficient balance!!");
        } else {
            balance -= amount;
            System.out.println("Transferred: $" + amount + " to " + recipient);
            System.out.println("New balance is: $" + balance);
            transactionHistory.add("Transfer: $" + amount + " to " + recipient);
        }
    }

    
}
