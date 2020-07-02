package banking.services;

import banking.entity.Account;
import banking.entity.Bank;
import banking.entity.CreditCard;

import java.util.Scanner;

public class BankingService {
    private static final Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountService();
    private Bank bank = new Bank();

    public void start() {
        int input;
        boolean exit = false;
        do {
            displayMainMenu();
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    onAccountCreation();
                    break;
                case 2:
                    exit = onLoginSelected();
                    break;
            }

        } while (input != 0 && !exit);
    }

    private boolean onLoginSelected() {
        System.out.println("Enter your card number:");
        long creditCardNo = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int pinNo = scanner.nextInt();
        Account account = login(creditCardNo, pinNo);
        if (account == null) {
            System.out.println("Wrong card number or PIN!");
        } else {
            System.out.println("You have successfully logged in!");
            return accountService.loggedIn(account);
        }
        return false;
    }

    public void displayMainMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public void onAccountCreation() {
        Account account = accountService.createAccount();
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(account.getCreditCard().getCreditCardNumber());
        System.out.println("Your card PIN:");
        System.out.println(account.getCreditCard().getPinNumber());
        bank.getAccountList().add(account);
    }

    public Account login(long creditCardNo, int pinNo) {
        for (Account account : bank.getAccountList()) {
            CreditCard card = account.getCreditCard();
            if (card.getCreditCardNumber() == creditCardNo && card.getPinNumber() == pinNo) {
                return account;
            }
        }
        return null;
    }

}
