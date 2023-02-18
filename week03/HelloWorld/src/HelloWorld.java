/*1. main 메서드 만들기
  2.GUI( Graphic User Interface)를 위해서 Swing 이라는 것을 이용 (JFC 라이브러리에 속함)
  3.Library -> 누군가 만들어 놓은 걸 가져다 쓸 수 있다. ex) Scanner
  Scanner x = new Scanner();를 사용할 때
  x라는 이름을 가진 무언가는 Scanner라는 타입의 객체라고 부른다.
  4.인스턴스 => 특정 타입의 *객체(Object)* ex)객체 = 사람, 사물 등 무언가. System.out.pritln()에서 out도 객체이다.
  5.모호하기에 JFrame(Java/Swing에서 붙여준 이름 +Frame)화면에 보여주는 fram  ->Window 창 뜨는거/ 객체를 만들어서 사용
  6.객체로만 이루어진 것이 아닌 +Primitive Type도 있다.(숫자에 가까운 것들)  Primitive Type(숫자에 가까운 것들)+Object Type(String ,Scanner등)
  7.메서드는 -> public/private(가시성) +static/없거나 (main일 때문 static사용) + 반환 타입(void) + 메서드이름
  8.메서드로 나누면  어떤 작업을 추상화(abstrraction)한다. ->이름 붙이  ex) int age =3 에서 3이 중요한게 아니라 age가 중요
    알아서 되게 하는
  9.Extract Method -> 메서드로 추출하기  코드들을 run으로 옮기는 행위
* */

import javax.swing.*;

public class HelloWorld {//HelloWorld라는 타입
    public static void main(String[] args){
        HelloWorld helloWorld = new HelloWorld();

        //크기를 찾아준다.
        JFrame frame = new JFrame("Hello, World!");  //JFrame이라는 타입
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        //만들어주고
        JLabel label = new JLabel("Hello");
        frame.add(label); //아무 대나 방치면 화면에 보이지 않는다. 그래서 frame에 추가해준다.

        //보여준다.
        frame.setVisible(true);
    }
}
