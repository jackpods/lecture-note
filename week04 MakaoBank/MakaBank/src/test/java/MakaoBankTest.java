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
    }
}