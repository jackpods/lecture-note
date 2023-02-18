import javax.swing.*;
import java.awt.*;

/*  1.main 메서드 만들기
    2.HelloToYou 타입의 객체 만들기-> run 메서드 활용
    3.JFrame -> window 띄우기
    4.JLabel -> 인사 텍스트 보여주
    5.JTextField -> 입력 컨트롤(control)
                    control = UI 화면에서 보이는 각 요소들
    6.마지막 컨트롤만 보이는 문제! -> 레이아웃(Flow,Grid)을 잡아줘야한다.
    7.JButton -> 버튼 컨트롤 ->Action(버튼 누를시 ) ->Event=>Listener(반응)
    8.Lambda: 매개변수(parameters) ->{}
    9. 변수의 종류ㅣ
        1) 지역 변수
        2) 매개 변수(parameters)
* */
public class HelloToYou {
    public static void main(String[] args){
        HelloToYou application =  new HelloToYou();
          application.run();
    }

    public void run() {

        JFrame frame = new JFrame("Hello to You");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));//행과 열을 잡을 수 있다.
        /*
                column 1 column 2 column 3
            row1 인사
            row2 입력 컨트록
            row3 버
        * */
        //변수에 있던걸 다시 가져온다. 아래와 같은 방식이다. cmd+option+n
        //ex_   int width = 400;
        //      int height = 300;
        //    frame.setSize(width,height);
        frame.setSize(400,300);

        JLabel label = new JLabel("Hello, world!");
        frame.add(label);

        JTextField textField = new JTextField(10);
        frame.add(textField);

        JButton button = new JButton("확인");
        button.addActionListener(event ->{
        //매개변수\
            String name = textField.getText();  // textField에서 글을 가지고 온다 . getText를 얻은다음 setText에 넣는다.
            label.setText("Hello, " +name +"!");//텍스트를 바꿔주는.원래 label이 가지고 있던 "Hello, world"대신에 다른걸 넣을 수 있다.
        });
        frame.add(button);

        frame.setVisible(true);
    }
}
