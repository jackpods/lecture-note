//1. 거래 정보 만들기
//2. 거래 정보 비교하기
//3. 잔액 변동?
//4. 잔액 변하게 한 결과 도출?

package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
   @Test//잘 모르겠으니 뭔가 만드는걸 해보자
    void creation(){
       Transaction transaction = new Transaction("입금",1000);
   }

//   2. 거래 정보 비교하기
    @Test
    void equals(){
       Transaction transaction1 = new Transaction("입금",1000);
       Transaction transaction2 = new Transaction("입금",1000);

       assertEquals(transaction1,transaction2);
    }
}