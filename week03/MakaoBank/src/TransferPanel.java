import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
    TransferPanel(){  //같은 이름 써주면 생성자가 된다.
        Account account =  new Account();  // 돈이 빠져나가는걸 만들어야하기 떄문에
        setLayout(new GridLayout(3,1));

        JLabel label = new JLabel("송금 하기");
        this.add(label);

        JTextField textField = new JTextField();
        this.add(textField);

        JButton button = new JButton("송금");
        button.addActionListener(event->{
            long amount = Long.parseLong(textField.getText());
            account.transfer(amount);  //이렇게만 쓰면 안되고 어딘가로 누구한테 준다도 있어야됨.
        });
        this.add(button);
    }
}
