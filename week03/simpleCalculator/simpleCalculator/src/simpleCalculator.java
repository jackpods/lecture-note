/*  1.static main, non-static run 메서드 만들기
*   2.Jpanle -> 일정한 부분 따로 만들 수 있음.
*   3.나머지 구하기 (%) => x % 10 =>0~9사이 수
*   4.정수를 문자열로 변환:  Integer.toString(숫자)
*   5.중복 발견 -> 중복 제거 =>메서드로! (Extract Method)
*   6.int-> 32bits / long -> 64bits
*   7.연산:+,-,*,/
*   8.for 쉽게 쓰기 -> for(타입 변수 : 배열)
* */
import javax.swing.*;
import java.awt.*;

public class simpleCalculator {
    private JTextField textField;
    private JPanel panel;

    private long currentNumber = 0;  //
    private long accumulator = 0; // 누른 값이나 결과 등 을 저장하는 곳

    public static void main(String[] args){
        simpleCalculator application = new simpleCalculator();
        application.run();
    }

    private void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(10);
        //맨위에 입력하는 창을 만들지만 입력은  못하게 한다.
        updateDisplay();//Extract Method를 하면 textfield가 딸려 들어간다.textfiedl가 지역변수이기 ㄱ떄문.
        textField.setEditable(false);
        //계산기 오른쪽에 0이 나오게
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField, BorderLayout.PAGE_START);//맨 위에만 달라붙.

        //레이아웃을 잡아서 별도로 놓고싶다. 밑에 한 부분을 잡아준다.
        panel = new JPanel();
        //1 2 3
        //4 5 6
        //7 8 9
        //0
        panel.setLayout(new GridLayout(4,3));
        frame.add(panel);

        //int currentNumber = 0; // 내가 관리하고 있는 번호

        initNumberButtons();
        initOperatorButtons();

        frame.pack();
        frame.setVisible(true);
    }

    public void initNumberButtons() {
        for(int i = 0; i<10;i+=1){
            int number = (i+1) % 10;
            JButton button = new JButton(Integer.toString(number));
            //숫자-> 문자열 1. ""+string
            //           2. Integer.toString()
            button.addActionListener(event->{
                currentNumber *= 10;
                currentNumber += number;
                updateDisplay();
            });
            panel.add(button);
        }
    }

    public void updateDisplay() {
        textField.setText(Long.toString(currentNumber));  // long으로 바꿔줄 때 원래는 하나하나 다 바꿔줘야하는데  한 곳으로
                                                          //몰아줬기 때문에 한번에 바꿔줄 수 있다=>재사용을 하게되고 관심사 분리.
    }
    public void initOperatorButtons(){
        String[] operators = new String[]{"+","-","*","/","="};

        for (String operator : operators) {//0~9를 사용하지 않는다.
            JButton button = new JButton(operator);
            button.addActionListener(event ->{
                //연산자를 누르면 숫자를 다시 새로 입력하게 된다.->여태까지 누른걸 어딘가에 보관해야한다.->누산한다
                accumulator = currentNumber;
                currentNumber = 0;
            });
            panel.add(button);
        }
    }
}
