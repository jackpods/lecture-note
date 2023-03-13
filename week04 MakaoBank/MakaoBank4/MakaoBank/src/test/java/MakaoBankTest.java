import models.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
    @Test
    void loadTransactions(){
        MakaoBank makaoBank = new MakaoBank();

        List<Transaction> transactions = makaoBank.loadTransactions();

        assertNotNull(transactions);

//        Transaction transaction = transactions.get(0);

//        assertEquals("잔액:1000",transaction); 이럴 수는 없으니 이게 되려면 Transaction을 제대로 만들어야겠다.
    }

}