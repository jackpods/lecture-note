//12.Method의 parameter(매개변수)를 이용해서 하나의 메서드를 다르게 작동하게 함.
//  -> 넘겨주는 값은 argument(인자, 인수)라고 부름.
//최신 switch
//static -> 사실은 따로 있는 것. 다른 친구들과 같이 쓰려고.
//static final -> constant(상수) -> 대문자로 표기
//표기법
//  - camelCase -> 전부 소문자, 단어 연결부를 대문자로 표기
//  - snake_case ->전부 소문자, 단어 연결부를 밑줄로 나눔 -> Java에선 안씀
//  - SCREAMING_SNAKE_CASE -> 전부 대문자, 단어 연결부를 밑줄로 나눔.
//  - PascalCase -> camelCase의 특수한 형태. 첫 글자가 대문자.
//                 -> Class 이름에 사용. HelloWorld
//관심사의 분리를 아주 극단적으로.
// 클래스 단위로 분리!
//상태는 볼 수 없다(가시성). 행위(메소드)는 볼 수 있다.
//꼭 상태를 알고 싶다면 ,getter를 만들어 써라(추천은 아니지만 관례)

import javax.swing.*;
import java.awt.*;

public class Calculator {

    //GUI 요소
    private JTextField textField;
    private JPanel panel;

    //핵심 프로그램 요소  -> 상태에서 객체로 분리가 됐다.
    private CoreCalculator coreCalculator;


    //Entry point(객체와 무관하게 따로 존재)
    public static void main(String[] args){
        Calculator application = new Calculator();
        application.run();
    }

    private void run() {
        coreCalculator = new CoreCalculator();


        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        textField = new JTextField(10);
        updateDisplay(coreCalculator.getCurrentNumber());
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

    public void initNumberButtons() {
        for(int i=0; i<10;i+=1){
            int number = (i+1)%10;
            JButton button = new JButton(Integer.toString(number));
            button.addActionListener(event ->{
                coreCalculator.addnumber(number);
                updateDisplay(coreCalculator.getCurrentNumber());//인자 인수
            });
            panel.add(button);
        }
    }

    public void initOperatorButtons() {

        for(String operator :CoreCalculator.OPERATORS) {
            JButton button = new JButton(operator);
            button.addActionListener(event -> {
                coreCalculator.calculate();
                coreCalculator.updateOperator(operator);
                updateDisplay(coreCalculator.getAccumulator());  //accumlator라는게 인자가 돼서 number라는 매개변수로 받아서 사용.
            });
            panel.add(button);
        }
    }

    public void updateDisplay(long number){//파라미터 매개변
        textField.setText(Long.toString(number));
    }


    //중복되는 값들만 넣어주려고 할 때

}
