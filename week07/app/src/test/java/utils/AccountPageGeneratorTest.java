//  1. account 를 생성할 때부터 받아서 처리
//  2. account 의 정보 출력 -> 텍스트로 -< HTML

package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
    // TODO: AccountPageGenerator 테스트 추가 필요함.
    @Test
    void html(){
        Account account = new Account("1234", "Ashal", 3000);

        PageGenerator pageGenerator = new AccountPageGenerator(account);

        String html = pageGenerator.html();

        assertTrue(html.contains("계좌번호: 1234"), "계좌번호 문제: " + html);
        assertTrue(html.contains("이름: Ashal"), "이름 포함 안 됨: " + html);
        assertTrue(html.contains("잔액: 3000"), "잔액 문제: " + html);
    }
}