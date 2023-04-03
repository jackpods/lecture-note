package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void creation(){
        Account account = new Account("1234","jack", 3000);
        //계좌 번호
        //이름
        //잔액
        assertEquals("1234", account.identifier());
        assertEquals("jack", account.name());
        assertEquals(3000, account.amount());

        //거래 내역 TODO

    }
}