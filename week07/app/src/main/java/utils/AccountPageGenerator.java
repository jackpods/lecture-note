package utils;

import models.Account;

public class AccountPageGenerator extends PageGenerator {
    private Account account ;

    public AccountPageGenerator(Account account) {
        super();

        this.account = account;
    }

    @Override
    public String html() {
        return "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UFT-8\">\n" +
                "<title>MakakoBank</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>계좌번호: "+account.identifier() + "</p>\n" +
               "<p>이름: " + account.name() + "</p>\n" +
               "<p>잔액: " + account.amount() + "원</p>\n";
    }
}
