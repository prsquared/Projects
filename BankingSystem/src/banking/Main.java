package banking;

import banking.services.BankingService;

public class Main {
    //test
    public static void main(String[] args) {
        System.out.println("Testing");
        BankingService service = new BankingService();
        service.start();
    }
}
