package com.zafu.nichang.service.impl;

import com.zafu.nichang.LogBlockQueueHolder;
import com.zafu.nichang.handler.WebSocketTransformHandler;
import com.zafu.nichang.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 倪畅
 * @date 2019/3/6 15:36
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    private LogBlockQueueHolder logBlockQueueHolder= LogBlockQueueHolder.getInstance();
    @Autowired
    private WebSocketTransformHandler webSocketTransformHandler;

    @Override
    public void sendMessage() {
        try {
            while (!logBlockQueueHolder.isEmpty()) {
                Thread.sleep(320);
                webSocketTransformHandler.sendMessageToAllUser(logBlockQueueHolder.takeMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error("发送数据发生异常：", e);
        }
    }
}
