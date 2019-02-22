package com.zafu.nichang.config;

import com.zafu.nichang.handler.WebSocketTransformHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

/**
 * @author 倪畅
 * @date 2019/2/22 10:53
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(),"/websocket")
                                .withSockJS();
    }
    @Bean
    public WebSocketTransformHandler myHandler(){
        return new WebSocketTransformHandler();
    }
}