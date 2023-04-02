package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
//      필요한 것.
//      1.계좌번호
//      2.이름
//      3.잔액
//      4.거래내역
    @Test
    void creation(){
        Account account = new Account("1234", "jack", 3000);

        assertEquals("1234",account.identifier());
        assertEquals("jack",account.name());
        assertEquals(3000, account.amount());
    }

//    TODO:거래내역
}