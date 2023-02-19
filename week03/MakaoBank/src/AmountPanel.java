import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
    private final Account account; // 밑에서 account가 필요 없으려면

    AmountPanel(Account account){ // 생성자도 그냥 특별한 메서드에 불과하다. 반환(return)이 없다.;
        this.account = account;

        setLayout(new GridLayout(2,1));  // 두 줄로 바뀜

        //AmountPanel은 잔액을 보여주는데 잔액쪽 어디가에서 오는데 그걸 Account페이지에서 가져온다.
        this.add(new JLabel(accountNumber()));
        //AmountPanel은 잔액을 보여주는데 잔액쪽 어디가에서 오는데 그걸 Account페이지에서 가져온다.
        this.add(new JLabel(amount()));  //나 스스로한테 더해준다.
    }

    private  String amount() {
        return "잔액: " + account.getAmount() + "원";
    }

    private  String accountNumber() {
        return "계좌번호: " +  account.getNumber();
    }
}
