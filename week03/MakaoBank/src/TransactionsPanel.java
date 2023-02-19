import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TransactionsPanel extends JPanel {
    TransactionsPanel(Account account){  //생성자가 됐다.
        this.setLayout(new GridLayout(1+account.transactionsSize(), 1));

        this.add(new JLabel("거래 내역"));

        List<String> transactions = account.getTransactions();
        transactions.add("해킹");

        for(String transaction : account.transactions()){
            this.add(new JLabel(transaction));
        }
    }
}
