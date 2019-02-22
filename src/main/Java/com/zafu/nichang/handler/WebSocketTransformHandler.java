package com.zafu.nichang.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 倪畅
 * @date 2019/2/22 14:50
 */
@Slf4j
public class WebSocketTransformHandler extends AbstractWebSocketHandler {

    private static CopyOnWriteArrayList<WebSocketSession> websocket = new CopyOnWriteArrayList<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        websocket.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("Hello Websocket!"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        websocket.remove(session);
    }


    public void sendMessageToAllUser(String message) throws IOException {
        log.info("message info {}", message);
        for (WebSocketSession webSocketSession : websocket) {
            webSocketSession.sendMessage(new TextMessage(message));
        }
    }

}
