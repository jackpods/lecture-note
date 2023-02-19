/*
* 1. (static)main, *(non-static)run
* 2. Swing -> window(JFrame) ->menu(buttons)
* 3.메뉴에 대한 기능 목록 = button list
*      1)잔액 조회
*      2)송금
*      3)거래 내역
*
* 4.여태까지 객체라는 것을 실제로 만질 수 있는 것 또는 명확히 보이는 것
* 실제로 그렇지 않은 것도 있었다. ex) Scanner 또는 애매한 것.
*                             Collection(다른 것들을 가지고 있는 객체)
*  버튼이라는 것을 가지고 있는 또다른 객체를 만들 수 있다.
* => List(타입)(추상)   구현으로 ArrayList (구현체)(구체_
* ex) 사람                선생님
*     사람                학생
*List<담을 아이템의 타입> 리스트 = new ArrayList<>;
*  */
import java.awt.FlowLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;


public class MakaoBank {
    private JFrame frame;  //JFrame에서 처리되고 복잡한것들 잊기 위해 필드로 뺀다.

    public static void main(String[] args){
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);

        initMenu(); //메뉴를 만들어줌

        frame.setVisible(true);
    }

    public void initMenu() {
        //버튼을 3개를 만들어줄껀데 패널을 만들어서 가로로 나열
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());//가로로
        frame.add(panel);

        List<JButton> buttons = new ArrayList<>();

        JButton button = new JButton("잔액 조회");
        panel.add(button);
        buttons.add(button); //버튼에 추가할 수 있다.

        JButton button2 = new JButton("송");
        panel.add(button2);

        JButton button3 = new JButton("거래 내역");
        panel.add(button3);
    }
}
