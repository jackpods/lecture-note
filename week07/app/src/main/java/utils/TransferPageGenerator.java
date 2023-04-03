package utils;

import models.Account;

public class TransferPageGenerator extends PageGenerator {
    private Account account;

    public TransferPageGenerator(Account account) {
        super();

        this.account = account;
    }

    @Override
    public String content() {
        return "<P>잔액: " + account.amount() +"원</p>"+
               "<P>보낼 계좌: <input type = \"text\" name =\"to\" /></p>" +
               "<P>보낼 금액: <input type = \"number\" name =\"amount\" /></p>" +
               "<p><button type=\"submit\">확인</button></p>";

    }
}
//중복이 발생한다.