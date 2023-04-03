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

    송금처리
 1. TransferPageGenerator 를 만들어서 HTML 을 보여준다. => 송금 UI를 보여준다.
 2. 송금 처리 => POST를 이용해서 처리
 3. 송금 결과 보여줘야한다.
 4. Template method pattern 활 -> 일부만 바꿔서 쓸 때
 */

import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.*;

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

//            2. 처리

            Account account = new Account("1234", "Asahal", 3000);

            PageGenerator pageGenerator = switch (path) {
                case "/account" -> new AccountPageGenerator(account);
                case "/transfer" -> new TransferPageGenerator(account);
                default -> new GreetingPageGenerator();
            };

            String content = pageGenerator.html();

//            3. 출력

            MessageWriter messageWriter = new MessageWriter(exchange);
            messageWriter.write(content);

        });
        httpServer.start();

        System.out.println("Server is listening... http://localhost:8000/");
    }
}
//인텔리제이아이디어가 화면에 뭔가 출력해주거나 출력하는게 없으면 프로그램이 실행됐다는걸 인지 못한다.
//그렇기에 System.out.println 을 해준다.
//그럼 거의 바로 나온다.
