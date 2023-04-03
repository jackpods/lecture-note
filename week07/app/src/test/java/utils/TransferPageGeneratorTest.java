package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
    @Test // transfer 하기 위한 form
    void form() {
        Account account = new Account("1234","Ashal", 3000);

        PageGenerator pageGenerator = new TransferPageGenerator(account);

        //뭔가 그려주려면
        String html = pageGenerator.html();

        assertTrue(html.contains("잔액: 3000원"), "잔액 문제:" +html);
        assertTrue(html.contains("보낼 계좌: <input"), "계좌 입력 문제:" +html);
        assertTrue(html.contains("보낼 금액: <input"), "금액 입력 문제:" +html);
        assertTrue(html.contains("<button type=\"submit\">확인</button>"),
                "확인 버튼 문제:" + html);
    }
}