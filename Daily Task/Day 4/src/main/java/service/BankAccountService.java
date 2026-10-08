package service;

import model.BankAccount;

public class BankAccountService {

    public void performWithdrawal(BankAccount account, double amount) {

        System.out.println("Before withdrawal: " + account.getBalance());

        account.withdraw(amount);

        System.out.println("After withdrawal: " + account.getBalance());
    }
}
