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

    7. HTTP Response(응답)을 하는데 두 가지를 챙겨야한다. -> Header + Body
        -Header -> 전체 content (bytes) size
        -Body   -> content (bytes)
 */

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

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
//         2. 기본으로 제공해주는 것이 있다.
        InetSocketAddress address = new InetSocketAddress(8000);

        HttpServer httpServer = HttpServer.create(address, 0);//(port)
        // 서버를 만들려고 할 때 포트를 중복으로 사용할 수가 없다. 어떤 경우에는 서버를 띄울 수가 없다.
        // 그렇기에 실패하면 실패한다고 예외가 발생한다.

        httpServer.createContext("/", (exchange) -> {
            String content = "Hello, world!"; //1. content -> 어떤 내용을 보내줄거야

            OutputStream outputStream = exchange.getResponseBody();//2. 사용자들에게 어떤걸 전달해줄 수 있는 stream 을 받게 된다.

            outputStream.write(content.getBytes()); //바이트로 다뤄야지 사용이 가능하다.
            outputStream.flush(); //데이터를 한꺼번에 막 전달하는게 아닌 모아놨다가 flush 라는 작업을 통해 한꺼번에 내보낸다.
                                  //write 을 여러번 하더라도 flush 할 때만 보낼 수 있게 만들었다.
            outputStream.close(); //응답이 끝나면 클로우즈한다.
        });


//      사용자가 웹브라우저에 접속했더니 서버에 뭔가가 일어나는구나를 알고싶은게 목적이 아닌 사용자가 hello world를 보게하는게 목적이기 때문에
//      1.'hello world를 extract한다.
//      2.exchage는 우리가 받거나 주거나 둘 다 할 수 있다.
        httpServer.start();
    }
}