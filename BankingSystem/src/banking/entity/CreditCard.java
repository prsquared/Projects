package banking.entity;

public class CreditCard {
    private int miiIdentifier;
    private int binNo;
    private int accountIdentifier;
    private int checkSum;
    private long creditCardNumber;
    private int pinNumber;

    public int getMiiIdentifier() {
        return miiIdentifier;
    }

    public void setMiiIdentifier(int miiIdentifier) {
        this.miiIdentifier = miiIdentifier;
    }

    public int getBinNo() {
        return binNo;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setBinNo(int binNo) {
        this.binNo = binNo;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(int accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }
}
