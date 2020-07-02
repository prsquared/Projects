package banking.entity;

public class Account {
    private CreditCard creditCard;
    private long balance;

    public Account(CreditCard creditCard) {
        this.creditCard = creditCard;
        this.balance = 0;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
