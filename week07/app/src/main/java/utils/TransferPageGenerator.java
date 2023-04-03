package utils;

import models.Account;

public class TransferPageGenerator extends PageGenerator {
    private Account account;

    public TransferPageGenerator(Account account) {
        super();

        this.account = account;
    }

    @Override
    public String html() {
        return "";
    }
}
