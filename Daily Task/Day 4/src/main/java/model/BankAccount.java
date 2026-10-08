package model;

import java.util.Objects;

public class BankAccount {

    private static int accountCounter = 1000;

    private final int accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor 1
    public BankAccount() {
        this("Unknown");
    }

    // Constructor 2
    public BankAccount(String accountHolder) {
        this(accountHolder, 0.0);
    }

    // Constructor 3
    public BankAccount(String accountHolder, double initialBalance) {

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative."
            );
        }

        this.accountNumber = ++accountCounter;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException(
                    "Account holder name cannot be empty."
            );
        }

        this.accountHolder = accountHolder;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient balance."
            );
        }

        // INTENTIONAL BUG — we will find this using the debugger
        balance -= amount;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof BankAccount other)) {
            return false;
        }

        return accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}';
    }
}