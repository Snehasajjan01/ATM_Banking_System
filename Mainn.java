package java_anudip;

import java.util.ArrayList;
import java.util.Scanner;

// Class for validating account credentials
class Validation {

    static int accountNumber = 54321;
    static int password = 9876;

    boolean validate(int accNo, int pin) {
        System.out.println("\nPlease wait...");
        pause();

        if (accountNumber != accNo || password != pin) {
            System.out.println(
                "Account Number or Password is incorrect!"
            );
            return false;
        }

        System.out.println("Validation Successful!");
        return true;
    }

    static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Class for banking operations
class AccountOperation {

    private int balance = 0;
    private final ArrayList<String> statement = new ArrayList<>();

    // Deposit amount
    void deposit(int amount) {
        System.out.println("\nPlease wait...");
        Validation.pause();

        balance += amount;
        statement.add("Deposit = " + amount);

        System.out.println("Amount deposited successfully!");
        System.out.println("Balance = " + balance);
    }

    // Withdraw amount
    void withdraw(int amount) {
        System.out.println("\nPlease wait...");
        Validation.pause();

        if (amount <= balance) {
            balance -= amount;
            statement.add("Withdraw = " + amount);

            System.out.println("Please collect your amount!");
            System.out.println("Balance = " + balance);
        } else {
            System.out.println(
                "Insufficient balance. Withdrawal not possible."
            );
        }
    }

    // Change ATM PIN
    void changePin(int oldPin, int newPin) {
        System.out.println("\nChanging PIN...");
        Validation.pause();

        if (oldPin == Validation.password) {
            Validation.password = newPin;
            System.out.println("PIN changed successfully!");
        } else {
            System.out.println("Incorrect old PIN!");
        }
    }

    // Display mini statement
    void miniStatement() {
        System.out.println("\nGenerating Mini Statement...");
        Validation.pause();

        if (statement.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : statement) {
                System.out.println(transaction);
            }
        }

        System.out.println("Account Balance = " + balance);
    }

    // Display current balance
    void displayBalance() {
        System.out.println("Balance = " + balance);
    }
}

// Main class
public class Mainn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
        AccountOperation account = new AccountOperation();

        System.out.println("Welcome to ICICI Bank");

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter 4-Digit ATM PIN: ");
        int pin = sc.nextInt();

        if (!validation.validate(accNo, pin)) {
            sc.close();
            return;
        }

        while (true) {

            System.out.println("\nChoose an Operation");
            System.out.println("----------------------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Change PIN");
            System.out.println("4. Mini Statement");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();

                    if (depositAmount > 0 && depositAmount % 100 == 0) {
                        account.deposit(depositAmount);
                    } else {
                        System.out.println(
                            "Enter a positive amount in multiples of 100."
                        );
                    }
                    break;

                case 2:
                    account.displayBalance();

                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();

                    if (withdrawAmount > 0 && withdrawAmount % 100 == 0) {
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println(
                            "Enter a positive amount in multiples of 100."
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();

                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();

                    System.out.print("Confirm new PIN: ");
                    int confirmPin = sc.nextInt();

                    if (newPin < 1000 || newPin > 9999) {
                        System.out.println(
                            "PIN must contain exactly 4 digits."
                        );
                    } else if (newPin == confirmPin) {
                        account.changePin(oldPin, newPin);
                    } else {
                        System.out.println(
                            "New PIN and confirmation do not match."
                        );
                    }
                    break;

                case 4:
                    account.miniStatement();
                    break;

                case 5:
                    account.displayBalance();
                    break;

                case 6:
                    System.out.println("\nThank you! Visit again.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
