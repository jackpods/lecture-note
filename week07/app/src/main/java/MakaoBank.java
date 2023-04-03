/*
 마카오 뱅크의 기능
 1. 잔액 조회(/account)
    -> Account (계좌) -> 계좌 번호 필요함.
 2. 송금(/transfer)
    -> 여러 계좌 -> 어떻게 구분? => 계좌 번호
               -> 어떻게 관리? => Map
    -> Transaction 추가.
 3. 거래 내역 확인(transactions)
    -> Transaction (거래) -> 관리 => List

    잔액 조회
    1. Account 모델 만들기
    2. MessageGenerator -> PageGenerator 로 변경
        -> 추상적인 존재로 변경 => 타입으로만 잡는다. -> 추상적인 존재 -> abstract class  내용이 없는 것 -> abstract method => 항상 @Override를 해준다.
        -> text 를 돌려주는게 아닌 HTML 을 돌려주게 한다.
    3. PageGenerator 를 상속해서 AccountPageGenerator 만들기
        -> 구상/구체를 따로 만들어서 사용.
 */

import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.PageGenerator;
import utils.MessageWriter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBank {
    public static void main(String[] args) throws IOException {
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() throws IOException {
        InetSocketAddress address = new InetSocketAddress(8000);

        HttpServer httpServer = HttpServer.create(address, 0);

        httpServer.createContext("/", (exchange) -> {
//            1. 입력

            URI requestURI = exchange.getRequestURI();
            String path = requestURI.getPath();
//          account를 받았을 때 어떻게 하다가 필요

//            2. 처리
            PageGenerator pageGenerator = new GreetingPageGenerator(); // 기본을 인사로 설정

            if (path.equals("/account")) {
                Account account = new Account("1234", "jack", 3000);
                pageGenerator = new AccountPageGenerator(account);//PageGenerator 추상적인 존재로 변경 => 타입으로만 잡는다.
            }

            String content = pageGenerator.html();

//            3. 출력

            MessageWriter messageWriter = new MessageWriter(exchange);
            messageWriter.write(content);

            System.out.println("주소"+httpServer.getAddress());
        });
        httpServer.start();
    }
}
//PageGenerator TDD 로 알 수 있는게 없다. 그저 타입이기 때문에 -> 그렇기에 TDD 명을 변경해준다.
//기존에 작성 했던걸 다 없애거나 활용해야한다.
//활용하려고 복사하여 이름을 변경한다.
//GreetingPageGenerator Test로 변경했다.
//GreetingPageGenerator 은 사실 기존에 있는 페이지이기에 PageGenerator 를 복사해 GreetingPageGenerator 로 변경한다.
//상속받기에 extends를 해준다.
//상속 받기에 PageGenerator가 내용을 가지고 있지 않기에 다 지운다. 왜냐면 greeting 에게 넘겼기 때문이다.
//assertTrue(html.contains("계좌번호: 1234"));는 가지고 있는지에 대한 것이다.