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
      http://localhost:8080/home  ->http
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
    public static void main(String[] args) {
        MakaoBank application = new MakaoBank();
        application.run();
    }

    private void run() {
//         2. 기본으로 제공해주는 것이 있다.
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000),0);//(port)
    }
}
