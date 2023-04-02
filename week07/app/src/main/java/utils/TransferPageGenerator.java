package utils;

import models.Account;

public class TransferPageGenerator extends PageGenerator {
    private Account account;

    public TransferPageGenerator(Account account) {
        super();
    }

    @Override
    public String html() {
        return "잔액: " + account.amount() + "";
    }
}
