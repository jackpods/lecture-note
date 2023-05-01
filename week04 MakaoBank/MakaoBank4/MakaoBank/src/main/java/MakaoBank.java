//1.처리 하려는게 무엇인가? -> 객체
//-> 객체지향프로그램
//계좌(통장),거래,거래결과 => 도메인 모델
//
//1) 계좌가 거래 내역을 가지고 있을 것인가?
//Account account = readFile(); -> 내역 가지고 있다.
//
//toString -> 이 객체의 정보를 내가 원하는 문자열로 출력할 수 있음.

import models.Account;
import models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MakaoBank {
    public static void main(String[] args) {
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() {
        //준비
        Account account = new Account(); //account 준비
        //입력
        List<Transaction> transactions = loadTransactions(); //transaction 불러옴
        //처리
//        계좌모델,거래모델
//        List<TransactionResult>transactionResult = account.process(transactions); 내역 적용해서 구한다
        //출력
//        saveTransactionResults(transactionResults); 저장
    }

    public List<Transaction> loadTransactions() {//매개 변수에 Account account 안 넣는 이유는 거래 내역을 따로 관리하기로 했기 때문이다.
        List<Transaction> transactions = new ArrayList<>(); //null은 아니지만 비어있다!

        Transaction transaction = new Transaction("잔액", 100);
//        transactions 비어있기 때문에 뭐라도넣어주자
        transactions.add(transaction);

        return transactions;
    }
}