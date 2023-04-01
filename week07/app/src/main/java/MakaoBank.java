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

 */

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
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

        HttpServer httpServer = HttpServer.create(address,0);//(port)
        // 서버를 만들려고 할 때 포트를 중복으로 사용할 수가 없다. 어떤 경우에는 서버를 띄울 수가 없다.
        // 그렇기에 실패하면 실패한다고 예외가 발생한다.

        httpServer.createContext("/", (exchange) ->{
            System.out.println("Hello, world!"); //사용자는 알 수 없고 볼 수 지만 서버에서는 반응이 있다.
        }); // 어떤 경로로 접근했을 때 어떤 식으로 우리가 응답을 해줄 수 있는지.
                                        // 뭐가 됐던간에 /로 시작하기만 하면 모조리 다 실행한다.

        httpServer.start();
    }
}
