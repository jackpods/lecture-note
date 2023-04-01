/*
    1. main -> run
    2. 웹에서 뭔가를 만든다는 것은 웹 서버를 만드는 것이다.
        Web Server -> Web Application Sever
        중요한 것은 웹서버를 만들기 위해서
        com.sun.net.httpserver.HttpServer 패키지 사용; -> HttpServer 클래스 활용
    3. 패키지 이름 -> 큰 것부터 작은 것 순서로 나열
        ->도메인과는 반대
            => com.sun.net.httpserver.HttpServer
              ->sun.com 이란 도메인을 뒤집은 형태.
        ->ex) ahastudio.com -> 패키지 이름으로는 com.ahastudiio.makao.bank

    4.URL -> URI 과거불림/요즘불림
      http://localhost:8080/home  => http :// localhost : 8080 / home =>/부터 경로는 시작한다.

      프로토콜(protocol) + 호스트(host) + 포트(port) +경로(path)
     =>  http/https => local은 http를 사용 보안은 https를 사용,

         localhost 는 내 컴퓨터를 의미

         각 각의 프로그램을 구분하기 위해 포트를 사용

         프로토콜(protocol) + 호스트(host) + 포트(port) + 경로(path)

    5.웹 브라우저로 확인 -> http://localhost:8080/ => 요즘 브라우저는 끝에 있는 /를 안보여준다. 그러나 실제로는 있는 것이다.

    6.정확히는 httpExchange 인데 exchange 로만 사용 => 요청을 받거나, 응답을 하는 용도로 사용.

    7.HTTP Response(응답)을 하는데 두 가지를 챙겨야한다. -> Header + Body
        -Header -> 전체 content (bytes) size
        -Body   -> content (bytes)

    8.HTTP 응답 코드  ->
    - 200번대 => 200 (성공), 202 (잘 만들었다)

    - 300번대 => 어떤 특정페이로 접근했는데 다른데로 옮기는 것 => 리다이렉션.
    - 400번대 => 클라이언트 잘못. -> 404 (not found) -> path 오류
    - 500번대 => 서버 잘못. 500(서버에서 큰 일 났다.) -> internal error

    9.중복을 발견 -> 중복을 제거 -> 클래스라는 걸 이용(관심사를 분리)

    인사말 만들기와 내용을 전달하기를 구분한다.
    10.MessageGenerator -> 적절한 인사말 만들기
        -> 처리 완료 ! generator를 바꿔주기만 하면 여기쪽을 손대지 않고도 인사말들을 얼마든지 변경이 가능하다
    11.MessageWriter -> 메시지를 HTTP로 전달
 */

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import utils.MessageGenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class MakaoBank {
    public static void main(String[] args) throws IOException {
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() throws IOException {
        InetSocketAddress address = new InetSocketAddress(8000);

        HttpServer httpServer = HttpServer.create(address, 0);


        httpServer.createContext("/", (exchange) -> {
            MessageGenerator messageGenerator = new  MessageGenerator();

//            인사말 만들
            String content = messageGenerator.text(); //messageGenerator 에서 텍스트를 얻는다.

//            내용을 전달

            exchange.sendResponseHeaders(200,content.getBytes().length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(content.getBytes());
            outputStream.flush();

            outputStream.close();
        });

        httpServer.createContext("/ashal", (exchange) -> {
            MessageGenerator messageGenerator = new MessageGenerator("Asahal");

            String content = messageGenerator.text();

            exchange.sendResponseHeaders(200,content.getBytes().length);


            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(content.getBytes());
            outputStream.flush();

            outputStream.close();
        });

        httpServer.start();
    }
}