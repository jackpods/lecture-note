import java.util.ArrayList;
import java.util.List;

public class Account {
    public String number = "123-456-778";//통장 번호

    private long amount = 1000;//잔액

    private List<String> transactions = new ArrayList<>() ;//거래 내역  =부터 생성자에서 만들어줘도됨.

    public String getNumber(){
        return number;
    }

    //getter!
    public long getAmount() {
        return amount;
    }

    //getter;
    public List<String> getTransactions() {
        return transactions;
    }

    //변형 getter! -> 이런 형태를 권장함.
    public int transactionsSize() {
        return transactions.size();
    }

    public void transfer(long transferAmount) {
        //돈이 빠져나감.
        amount -= transferAmount;

        //거래내력을 기록해줌. Transfer에서 할 필요 없음
        transactions.add("돈 보냈다~");  //이대로면 transactions가 지역변수라 실행하고나면 끝이다 그러니 필드로 보내야한다.
    }

}
