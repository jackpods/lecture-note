import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
    TransactionsPanel(Account account){  //생성자가 됐다.
        this.setLayout(new GridLayout(1+account.transactionsSize(), 1));

        this.add(new JLabel("거래 내역"));

        for(String transaction : account.getTransactions()){
            this.add(new JLabel(transaction));
        }
    }
}
