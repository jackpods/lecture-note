package utils;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class MessageWriter {
    public void write(String content) {

    }

    public static void write(HttpExchange exchange, String content) throws IOException { 
        exchange.sendResponseHeaders(200, content.getBytes().length);

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(content.getBytes());
        outputStream.flush();

        outputStream.close();
    }
}
