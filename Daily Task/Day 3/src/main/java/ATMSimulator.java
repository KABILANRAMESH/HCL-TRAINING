import java.util.Scanner;

public class ATMSimulator {

    private static final int CORRECT_PIN = 1234;
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        boolean authenticated = false;

        // PIN verification using while loop
        while (attempts < MAX_ATTEMPTS) {

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            if (pin == CORRECT_PIN) {
                authenticated = true;
                System.out.println("PIN verified successfully.");
                break;
            }

            attempts++;

            if (attempts < MAX_ATTEMPTS) {
                System.out.println("Invalid PIN. Try again.");
                continue;
            }

            System.out.println("Maximum attempts reached.");
        }

        if (!authenticated) {
            System.out.println("Account locked.");
            scanner.close();
            return;
        }

        double balance = 10000.00;
        boolean running = true;

        // do-while menu
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Invalid deposit amount.");
                        continue;
                    }

                    balance += deposit;
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawal = scanner.nextDouble();

                    if (withdrawal <= 0) {
                        System.out.println("Invalid withdrawal amount.");
                        continue;
                    }

                    if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                        continue;
                    }

                    balance -= withdrawal;
                    System.out.println("Withdrawal successful.");
                    break;

               case 4:
    String[] transactions = {
        "Account opened",
        "Deposit: ₹5000",
        "Withdrawal: ₹1000"
    };

    System.out.println("\n===== MINI STATEMENT =====");

    // Enhanced-for loop
    for (String transaction : transactions) {
        System.out.println(transaction);
    }

    // Normal for loop + labelled break
    System.out.println("\nChecking transaction:");

    outer:
    for (int i = 0; i < transactions.length; i++) {
        System.out.println("Checking: " + transactions[i]);

        if (transactions[i].contains("Withdrawal")) {
            System.out.println("Withdrawal transaction found.");
            break outer;
        }
    }

    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (running);

        scanner.close();
    }
}