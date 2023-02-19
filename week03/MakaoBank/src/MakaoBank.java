/*
 1. (static)main, *(non-static)run
 2. Swing -> window(JFrame) ->menu(buttons)
 3.메뉴에 대한 기능 목록 = button list
      1)잔액 조회
      2)송금
      3)거래 내역

 4.여태까지 객체라는 것을 실제로 만질 수 있는 것 또는 명확히 보이는 것
 실제로 그렇지 않은 것도 있었다. ex) Scanner 또는 애매한 것.
                             Collection(다른 것들을 가지고 있는 객체)
  버튼이라는 것을 가지고 있는 또다른 객체를 만들 수 있다.
 5.=> List(타입)(추상)   구현으로 ArrayList (구현체)(구체_
 ex) 사람                선생님
     사람                학생
    *List<담을 아이템의 타입> 리스트 = new ArrayList<>;
 6. 실제로 내용이 보이는 Content 변경 -> 3가지가 준비되고, 버튼 누르면 바꿔서 보여줌
 7.우리만의 Panel -> 실제로도 JPanel과 같은 것이길 바람.
                -> JPanel이란 타입이길 바라는거랑 같은 말이다.
   타입(추상) 범용) -> 구현(구체)(상세하다)(덧붙임) (확장 = extends = 상속)
   extends해서 나만의 패널을 만든다.
 8. 생성자(new 하면 실행되는 메서드)

*  */


import java.awt.*;
import javax.swing.*;

public class MakaoBank {
    private JFrame frame;  //JFrame에서 처리되고 복잡한것들 잊기 위해 필드로 뺀다.
    private JPanel contentPanel; // 내용이 보이는 패널
    public static void main(String[] args){
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);

        initMenu(); //메뉴를 만들어줌
        initContentPanel();

        frame.setVisible(true);
    }

    public void initMenu() {
        //버튼을 3개를 만들어줄껀데 패널을 만들어서 가로로 나열
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());//가로로
        frame.add(panel, BorderLayout.PAGE_START);//이러면 나머지 내용들이 밑으로 자동으로 붙는다.

        //밑에 나온느 내용들을 일정한 패널들로 만들어서 관리를 한다.

        panel.add(createAmountButton());//버튼들이 행동을 해야하니 다시 분리한다.
        panel.add(createTransferButton());
        panel.add(createTransactionsButton());

    }

    public JButton createAmountButton() {
        JButton button = new JButton("잔액 조회");
        button.addActionListener(event->{
            AmountPanel amountPanel = new AmountPanel();//이제 어마운트 패널에 뭔가 내용을 만들어줘야한다. 객체를 그냥 add를 할 수 있는ㄷ?
            contentPanel.add(amountPanel); // 컨텐츠패널에 어마운트 패널을 만들어준다.
                                        //7.
            frame.setVisible(true);
        });//addAction을 해줘야하기에 introduce Method를 해준다.
        return button;  //new는 create와 비슷하기 에 사용한다.
    }

    public JButton createTransferButton() {
        JButton button = new JButton("송금");
        button.addActionListener(event->{
            //컨텐츠 패널 내용을 바꿔주기
        });
        return button;
    }

    public JButton createTransactionsButton() {
        JButton button = new JButton("거레 내역");
        button.addActionListener(event->{
            //컨텐츠 패널 내용을 바꿔주기
        });
        return button;
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        frame.add(contentPanel);
        //이제부터 각각 컨텐츠 패널 내용을 바꿔주기
    }
}