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
        return "<P>잔액: " + account.amount() +"원</p>" +
               "<form method=\"POST\">\n" +  //=> port 뒤에 get으로 전달된게 나온다.
                                            // -> POST로 나오게해야한다.
                                            // 왜??
                                            // -> 개발자 도구에 payload를
                                            // 받아서 쓸 수 있게 한다.
               "<P>보낼 계좌: <input type = \"text\" name =\"to\" /></p>" +
               "<P>보낼 금액: <input type = \"number\" name =\"amount\" /></p>" +
               "<p><button type=\"submit\">확인</button></p>" +
               "</form>";

    }
}
//중복이 발생한다.