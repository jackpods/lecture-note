package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
    @Test
    void navigation() {
        PageGenerator pageGenerator = new PageGenerator() {
            @Override
            public String content() {
                return "";
            }
        };

        String html =  pageGenerator.html();
        //원하는건 어디론가 링크가 될텐데 세가지 home 누르면 홈으로 인사
        assertTrue(html.contains("홈으로"),"홈 메뉴 문제:  " + html);
        assertTrue(html.contains("잔액 조회"),"잔액 조회 메뉴 문제:  " + html);
        assertTrue(html.contains("송금"),"송금 메뉴 문제:  " + html);
    }
}