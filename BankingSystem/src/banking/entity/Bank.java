package banking.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
