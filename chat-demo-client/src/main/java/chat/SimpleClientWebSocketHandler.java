package chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.user.SimpUserRegistry;

import java.lang.reflect.Type;


public class SimpleClientWebSocketHandler implements StompSessionHandler{
    Logger logger = LoggerFactory.getLogger("Handler");

    private StompSession session;
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        this.session = session;
//        session.send("app/messages", "Hello world");
        this.session.subscribe("/topic/messages", this);
        this.session.subscribe("/app/hello", this);
        logger.info("Session established");

    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {

    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        String msg = payload.toString();
        logger.info("I'm here");
        logger.info(msg);
    }
}
