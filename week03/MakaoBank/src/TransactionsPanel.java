import javax.swing.*;

public class TransactionsPanel extends JPanel {
    TransactionsPanel(Account account){  //생성자가 됐다.
        JLabel titleLabel = new JLabel("거래 내역");
        this.add(titleLabel);

        for(String transaction : account.getTransactions()){
            JLabel label = new JLabel(transaction);
            this.add(label);
        }
    }
}
