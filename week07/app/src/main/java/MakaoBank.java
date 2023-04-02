/*
    1. 잔액 조회(/account)
        -> Account (계좌) -> 계좌 번호 필요함.

    2. 송금(/transfer)
        -> 여러 계좌 -> 어떻게 구분? -> 계좌 번호
                   -> 어떻게 관리? => Map
        -> Transaction 추가.
    3. 거래 내역 확인(/transactions)
       -> Transaction (거래) -> 관리 => List

잔액 조회
    1. Account 모델 만들기

    2. 세 가지 상황이 있기에 Generator 를 각 각 따로 만들어준다.
       더 이상 메세지가 아닌 특정 페이지로 만들어주는거다.
       MessageGenerator 를 PageGenerator 로 이름 바꾸기
        -> PageGenerator 를 추상적인 존재로 변경  -> 타입으로만 잡을거다.
            -> abstract class => abstract method => @Override
        -> HTML 을 돌려주게 한다.
    3. PageGenerator 를 상속해 AccountPageGenerator 만들기
        -> 구상/구체를 따로 만들어서 사용.

송금
    1.TransferPageGenerator -> HTML =>송금 UI
    2.송금 처리 -> POST
    3.송금 결과
*/

import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.*;

import javax.swing.text.Style;
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
//          1. 입력
            URI requestURI = exchange.getRequestURI();
            String path = requestURI.getPath();

//          2. 처리

            Account account = new Account("1234", "Ashal", 3000);

            PageGenerator pageGenerator = switch (path) {
                case "/account" -> new AccountPageGenerator(account);
                case "/transfer" -> new TransferPageGenerator(account);
                default -> new GreetingPageGenerator();
            };

            String content = pageGenerator.html();

//          3. 출력

            MessageWriter messageWriter = new MessageWriter(exchange);
            messageWriter.write(content);
        });

        httpServer.start();

        System.out.println("Sever is listening... http://localhost:8000/");
        System.out.println("Sever is listening... http://localhost:8000/account");
    }
}
// /account 일 때만 계좌 정보가 보이게 되야한다.