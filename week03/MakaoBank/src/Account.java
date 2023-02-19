import java.util.ArrayList;
import java.util.List;

public class Account {
    public String number;//통장 번호

    private long amount ;//잔액

    private List<String> transactions = new ArrayList<>() ;//거래 내역  =부터 생성자에서 만들어줘도됨.

    //핵심 도메인 객체를 검증!
    public static void main(String[] args){//검증 main들어 가 있는걸 특별하게 써 왔는데 그렇지 않다. account랑 별로 상관없이 동 떨어진 애다. main의 존재를 찾아서 실행한다.
        Account account = new Account();
        System.out.println("Amount: "+account.getAmount());
        //-> 1000 나와야 함.
        account.transfer(100);

        System.out.println("Amount: "+account.getAmount());
        //-> 950 나와야 함.
        account.transfer(50);

        System.out.println("Amount: "+account.getAmount());
        //-? 850 나와야 함.
        for(String transaction : account.transactions()){
            System.out.println(transaction);
        }
        //-> 송금 100, 50 이렇게 나와야 함.
    }

    public Account(String number, long amount) {//컨트롤 엔터 눌러서 만들어서 한명 더 만들기
        this.number = number;
        this.amount = amount;
    }

    public String getNumber(){
        return number;
    }

    //getter!
    public long getAmount() {
        return amount;
    }

    //변형 getter! -> 이런 형태를 (약간)권장
    public List<String> transactions() {//안에 있는 객체를 얻은게 아니라 새로운 걸 얻었다.

        return new ArrayList<>(transactions);
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
