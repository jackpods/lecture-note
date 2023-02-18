/*  1.static main, non-static run 메서드 만들기
*   2.Jpanle -> 일정한 부분 따로 만들 수 있음.
*   3.나머지 구하기 (%) => x % 10 =>0~9사이 수
*   4.정수를 문자열로 변환:  Integer.toString(숫자)
* */
import javax.swing.*;
import java.awt.*;

public class simpleCalculator {
    private int currentNumber = 0;  //

    public static void main(String[] args){
        simpleCalculator application = new simpleCalculator();
        application.run();
    }

    private void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JTextField textField = new JTextField(10);
        //맨위에 입력하는 창을 만들지만 입력은  못하게 한다.
        textField.setText(Integer.toString(currentNumber));
        textField.setEditable(false);
        //계산기 오른쪽에 0이 나오게
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField, BorderLayout.PAGE_START);//맨 위에만 달라붙.

        //레이아웃을 잡아서 별도로 놓고싶다. 밑에 한 부분을 잡아준다.
        JPanel panel = new JPanel();
        //1 2 3
        //4 5 6
        //7 8 9
        //0
        panel.setLayout(new GridLayout(4,3));
        frame.add(panel);

        //int currentNumber = 0; // 내가 관리하고 있는 번호

        for(int i = 0; i<10;i+=1){
            int number = (i+1) % 10;
            JButton button = new JButton(Integer.toString(number));
            //숫자-> 문자열 1. ""+string
            //           2. Integer.toString()
            button.addActionListener(event->{
                currentNumber = number;
                textField.setText(Integer.toString(currentNumber));
            });
            panel.add(button);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
