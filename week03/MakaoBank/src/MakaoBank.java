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
    -> 생성자도 그냥 특별한 메서드에 불과하다. 반환(return)이 없다.
    -> 생성자도 parameters를 지정할 수 있다.
    -> 의존하는 객체를 받아서 쓸 수 있다. => 의존성 주입(Dependency Injection)    내가 다른걸 쓰면 걔한테 의존한다.
                                 => 제어의 역(IoC)
                                 => 관심사이의 분리
     -> 의존하는 객체를 바꾸는 일은 흔치 않아서 final로 지정.
 9. 통장/계좌/Account -> 실제로 은행에서 쓰는 용어.
                    -> 실제로 분야(도메인)에서 쓰는 개념들을 도메인 모델이라하고 , 용어들을 도메인 객체라고한다.
                    => 도메인 객체가 핵심이 되는 부분이다.

       프로그램 검증할 때
       1.각 부분들이 accout를 잘 반영해서 실행되는가\
       2. account라는 도메인 객체가 정말 잘 만들어졌는가?

 10. 가장 중요한 부분 = 도메인 객체를 테스트하자. 잘 봐서...
        -> 어떤 걸 실행하면, 어떤 결과가 나오는지 알고, 그대로 되는지 지켜본다.
*  */


import java.awt.*;
import javax.swing.*;

public class MakaoBank {
    private Account account;
    private JFrame frame;  //JFrame에서 처리되고 복잡한것들 잊기 위해 필드로 뺀다.
    private JPanel contentPanel; // 내용이 보이는 패널
    public static void main(String[] args){
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() {
        account = new Account();  //프로그램시작할 때 만든다.
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
            JPanel amountPanel = new AmountPanel(account);//이제 어마운트 패널에 뭔가 내용을 만들어줘야한다. 객체를 그냥 add를 할 수 있는ㄷ?
            showContentPanel(amountPanel);
        });//addAction을 해줘야하기에 introduce Method를 해준다.
        return button;  //new는 create와 비슷하기 에 사용한다.
    }

    public JButton createTransferButton() {
        JButton button = new JButton("송금");
        button.addActionListener(event->{
            JPanel transferPanel = new TransferPanel(account);//이제 어마운트 패널에 뭔가 내용을 만들어줘야한다. 객체를 그냥 add를 할 수 있는ㄷ?
            showContentPanel(transferPanel);
        });
        return button;
    }

    public JButton createTransactionsButton() {
        JButton button = new JButton("거레 내역");
        button.addActionListener(event->{
            JPanel transactionsPanel = new TransactionsPanel(account);//이제 어마운트 패널에 뭔가 내용을 만들어줘야한다. 객체를 그냥 add를 할 수 있는ㄷ?
            showContentPanel(transactionsPanel);
        });
        return button;
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        frame.add(contentPanel);
        //이제부터 각각 컨텐츠 패널 내용을 바꿔주기
    }

    public void showContentPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
        frame.setVisible(true);
    }
}
