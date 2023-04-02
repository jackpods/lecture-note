package utils;

import models.Account;

public class AccountPageGenerator extends PageGenerator {
    private Account account ;

    public AccountPageGenerator (Account account) {
        super();

        this.account = account;
    }

    @Override
    public String html() {
        return  "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"UFT-8\">" +
                "<title>MakakoBank</title>" +
                "</head>" +
                "<body>" +
                "<p>계좌번호: "+account.identifier() + "</p>" +
                "<p>이름: " + account.name() + "</p>" +
                "<p>잔액: " + account.amount() + "원</p>" +
                "</body>" +
                "</html>";
    }
}
