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
 1. TransferPageGenerator 를 만들어서 HTML 을 보여준다. => 송금 UI를 보여준다. => 반응이 있게 하려면 form을 사용해야한다. <form>만들기
 2. 송금 처리 => POST를 이용해서 처리 => form을 만들어서 POST로 처리.그럴려면 주소가 필요하다.
    1) /transfer => 같은 주소 활용 =? method 를 확인해야한다.
    2) /transfer-process => 앞에와 같이 다른 주소 사
 3. 송금 결과 보여줘야한다.
 4. Template method pattern 활 -> 일부만 바꿔서 쓸 때
 5. GET 과 POST 처리 나눔.
    -> 삼항연산자 활용 => 조건 ? true 일 때 : false 일 때
    -> 처리하는 부분과 결과 보여주는 부분도 나눔.
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

            String method = exchange.getRequestMethod(); //http에서 쓰는 메소드

//            2. 처리

            Account account = new Account("1234", "Asahal", 3000);

                //진짜 처리?

                PageGenerator pageGenerator = switch (path) {
                    case "/account" -> new AccountPageGenerator(account);
                    case "/transfer" -> method.equals("GET")
                            ? new TransferPageGenerator(account)
                            : new TransferProcessPageGenerator(account);
                    default -> new GreetingPageGenerator();
                };

                //진짜 처리?

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

//처리 부분이 전부 GET에 관한 것이기에 POST에 관한 것을 넣어주자.