import javax.swing.*;

public class AmountPanel extends JPanel {
    AmountPanel(Account account){ // 생성자도 그냥 특별한 메서드에 불과하다. 반환(return)이 없다.
        long amount = account.getAmount();

        JLabel label = new JLabel("잔액: "+amount+"원");//AmountPanel은 잔액을 보여주는데 잔액쪽 어디가에서 오는데 그걸 Account페이지에서 가져온다.
        this.add(label);  //나 스스로한테 더해준다.
    }
}
