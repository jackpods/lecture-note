import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
    TransferPanel(){  //같은 이름 써주면 생성자가 된다.
        setLayout(new GridLayout(3,1));

        JLabel label = new JLabel("송금 하기");
        this.add(label);

        JTextField textField = new JTextField();
        this.add(textField);

        JButton button = new JButton("송금");
        this.add(button);
    }
}
