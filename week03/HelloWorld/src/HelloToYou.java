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
        3) 멤버 변수(Instance Field) = 객체와 생명주기를 같이 한다.
                -> 무조건 private .public을 할 수는 있지만 하지 않는다.
    10.중복발견 ->패턴 발견 -> 중복 제거
    11.Refactor 도구-> Extract method
    12. Extract method를 사용하기 전 메서드는 Method : public/private + static/non-static + 반환 타입(return type) + 메서드 이름
            -> 추상화(abstraction) => 중복 제거/재사용 , 이름 붙일 수 있다. => 메서드 greetingMessage에서 hi라고 바꿔도 전혀 상관없다.
            -> 관심사의 분리
* */
public class HelloToYou {
    private String name="World";

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


        JLabel label = new JLabel(greetingMessage());
        frame.add(label);

        JTextField textField = new JTextField(10);
        frame.add(textField);

        JButton button = new JButton("확인");
        button.addActionListener(event ->{
        //매개변수이다


            name = textField.getText();  // textField에서 글을 가지고 온다 . getText를 얻은다음 setText에 넣는다.
            //String message = greetingMessage();
            //label.setText(message);  //중복 제거
            label.setText(greetingMessage());//텍스트를 바꿔주는.원래 label이 가지고 있던 "Hello, world"대신에 다른걸 넣을 수 있다.
        });
        frame.add(button);

        frame.pack(); //사이즈 자동조절
        frame.setVisible(true);
    }

    private String greetingMessage() {//void가 없기에 반환을 해줄 수 있다.  String.message = scaner.nextline과 똑같다.
        return "Hello, " + name + "!";
    }


}
