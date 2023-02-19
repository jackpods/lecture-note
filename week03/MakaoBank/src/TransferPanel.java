import javax.swing.*;

public class TransferPanel extends JPanel {
    TransferPanel(){  //같은 이름 써주면 생성자가 된다.
        JLabel label = new JLabel("송금 하기");
        this.add(label);

        JTextField textField = new JTextField();
        this.add(textField);
    }
}
