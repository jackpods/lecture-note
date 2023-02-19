import javax.swing.*;

public class AmountPanel extends JPanel {
    AmountPanel(){
        Account account = new Account();

        long amount = account.getAmount();

        JLabel label = new JLabel("잔액: "+amount+"원");//AmountPanel은 잔액을 보여주는데 잔액쪽 어디가에서 오는데 그걸 Account페이지에서 가져온다.
        this.add(label);  //나 스스로한테 더해준다.
    }
}
