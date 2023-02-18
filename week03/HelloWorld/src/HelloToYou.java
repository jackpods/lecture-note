import javax.swing.*;

/*  1.main 메서드 만들기
    2.HelloToYou 타입의 객체 만들기-> run 메서드 활용
    3.JFrame -> window 띄우기
    4.JLabel -> 인사 텍스트 보여주
    5.JTextField -> 입력 컨트롤(control)
                    control = UI 화면에서 보이는 각 요소들
    6.마지막 컨트롤만 보이는 문제! -> 레이아웃(Flow,Grid)을 잡아줘야한다.
* */
public class HelloToYou {
    public static void main(String[] args){
        HelloToYou application =  new HelloToYou();
          application.run();
    }

    public void run() {
        JFrame frame = new JFrame("Hello to You");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        JLabel label = new JLabel("Hello, world!");
        frame.add(label);

        JTextField textField = new JTextField(10);
        frame.add(textField);

        frame.setVisible(true);
    }
}
