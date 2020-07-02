package banking.services;

import banking.entity.Account;
import banking.entity.CreditCard;

import java.util.Scanner;

public class AccountService {
    private static final Scanner scanner = new Scanner(System.in);
    CreditCardService creditCardService = new CreditCardService();

    public Account createAccount() {
        CreditCard creditCard = creditCardService.generateCreditCard();
        Account account = new Account(creditCard);
        return account;
    }


    public boolean loggedIn(Account account) {
        int input;
        do {
            displayAccountMenu();
            input = scanner.nextInt();
            if(input==1){
                System.out.println(account.getBalance());
            }
        } while (input != 2 && input != 0);
        return input == 0;
    }

    public void displayAccountMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
    }
}
