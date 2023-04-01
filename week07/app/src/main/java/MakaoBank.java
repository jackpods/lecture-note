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
        HttpServer httpServer = new HttpServer() {
            @Override
            public void bind(InetSocketAddress addr, int backlog) throws IOException {

            }

            @Override
            public void start() {

            }

            @Override
            public void setExecutor(Executor executor) {

            }

            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void stop(int delay) {

            }

            @Override
            public HttpContext createContext(String path, HttpHandler handler) {
                return null;
            }

            @Override
            public HttpContext createContext(String path) {
                return null;
            }

            @Override
            public void removeContext(String path) throws IllegalArgumentException {

            }

            @Override
            public void removeContext(HttpContext context) {

            }

            @Override
            public InetSocketAddress getAddress() {
                return null;
            }
        }
    }
}
