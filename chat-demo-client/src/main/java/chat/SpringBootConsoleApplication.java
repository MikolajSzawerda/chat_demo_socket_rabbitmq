package chat;

import org.apache.tomcat.websocket.WsWebSocketContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.jetty.JettyWebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    @Autowired
    private WebSocketStompClient webSocketStompClient;
    @Autowired
    private StompSessionHandler stompSessionHandler;
    private static Logger LOG = LoggerFactory
            .getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws ExecutionException, InterruptedException {
        LOG.info("EXECUTING : command line runner");
        webSocketStompClient.start();
        var stompSession = webSocketStompClient.connect("ws://localhost:8080/chat", stompSessionHandler).get();
        LOG.info(stompSession.getSessionId());
        while (true){
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            stompSession.send("/app/exchange", line);
            LOG.info("Msg sent");
        }
    }
}
