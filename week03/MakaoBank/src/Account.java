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
         List<String> copy = new ArrayList<>(transactions);  //사이즈가 안맞아서 이상하게 작동 될 수 있다. 그래서 실제로 돌려준 것과 간직하고 있는게 다르게 하기 위해서 복사본을 준다.
        return copy;
    }

    //변형 getter! -> 이런 형태를 권장함.
    public int transactionsSize() {
        return transactions.size();
    }

    public void transfer(long transferAmount) {
        //돈이 빠져나감.
        amount -= transferAmount;

        //거래내력을 기록해줌. Transfer에서 할 필요 없음
        transactions.add("송금: "+transferAmount+"원");  //이대로면 transactions가 지역변수라 실행하고나면 끝이다 그러니 필드로 보내야한다.
    }

}
