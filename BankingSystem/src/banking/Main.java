package banking;

import banking.services.BankingService;

public class Main {

    public static void main(String[] args) {
        BankingService service = new BankingService();
        service.start();
    }
}
