package NumberGame;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private final BankAccount account;
    private final Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using the ATM!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Current balance: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    account.deposit(scanner.nextDouble());
                    System.out.println("Deposit successful. New balance: Rs. " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    if (account.withdraw(scanner.nextDouble())) {
                        System.out.println("Withdrawal successful. New balance: Rs. " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        new ATM(userAccount).start();
    }
}

