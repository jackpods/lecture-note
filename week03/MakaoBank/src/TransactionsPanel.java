import javax.swing.*;

public class TransactionsPanel extends JPanel {
    TransactionsPanel(Account account){  //생성자가 됐다.
        JLabel label = new JLabel("거래 내역");
        this.add(label);

        for(String transaction : account.getTransactions()){
            JLabel transactionLabel = new JLabel(transaction);
            this.add(transactionLabel);
        }
    }
}
