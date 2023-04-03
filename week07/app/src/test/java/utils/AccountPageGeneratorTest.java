//  1. account 받아서 생성
//  2. account 의 정보 출력 -> 텍스트로..이것도 HTML 이다

package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
//    TODO: AccountPageGenerator 테스트 추가 필요함.
    @Test
    void html(){
        Account account = new Account("1234", "jack", 3000);

        PageGenerator pageGenerator = new AccountPageGenerator(account);

        String html = pageGenerator.html();

        assertTrue(html.contains("계좌번호: 1234"), "계좌번호 문제:" + html);
        assertTrue(html.contains("이름: jack"),"이름 문제: " + html);
        assertTrue(html.contains("잔액: 3000원"),"잔액 문제: " + html);

     }
}