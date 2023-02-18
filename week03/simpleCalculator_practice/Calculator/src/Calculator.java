//12.Method의 parameter(매개변수)를 이용해서 하나의 메서드를 다르게 작동하게 함.
//  -> 넘겨주는 값은 argument(인자, 인수)라고 부름.
//최신 switch
import javax.swing.*;
import java.awt.*;

public class Calculator {
    private long currentNumber = 0;
    private JTextField textField;
    private JPanel panel;
    private long accumulator = 0;
    private String currentOperator = "";

    public static void main(String[] args){
        Calculator application = new Calculator();
        application.run();
    }

    private void run() {
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        textField = new JTextField(10);
        updateDisplay(currentNumber);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField, BorderLayout.PAGE_START);


        panel = new JPanel();
        panel.setLayout(new GridLayout(4,3));
        frame.add(panel);

        initNumberButtons();
        initOperatorButtons();
        frame.pack();
        frame.setVisible(true);
    }

    private void initNumberButtons() {
        for(int i=0; i<10;i+=1){
            int number = (i+1)%10;
            JButton button = new JButton(Integer.toString(number));
            button.addActionListener(event ->{
                currentNumber *= 10;
                currentNumber += number;
                updateDisplay(currentNumber);//인자 인수
            });
            panel.add(button);
        }
    }

    private void initOperatorButtons() {
        String[] operators = new String[]{"+","-","*","/","="};
        for(String operator : operators) {
            JButton button = new JButton(operator);
            button.addActionListener(event -> {
                switch (currentOperator){
                    case "":
                        accumulator = currentNumber;
                        break;
                    case "+":
                        accumulator += currentNumber;
                        break;
                    case "-":
                        accumulator -= currentNumber;
                        break;
                    case "*":
                        accumulator *= currentNumber;
                        break;
                    case "/":
                        accumulator /= currentNumber;
                        break;
                }
                currentOperator = operator;
                currentNumber=0;
                updateDisplay(accumulator);  //accumlator라는게 인자가 돼서 number라는 매개변수로 받아서 사용.

            });
            panel.add(button);
        }
    }

    //중복되는 값들만 넣어주려고 할 때
    public void updateDisplay(long number){//파라미터 매개변
        textField.setText(Long.toString(number));
    }
}
