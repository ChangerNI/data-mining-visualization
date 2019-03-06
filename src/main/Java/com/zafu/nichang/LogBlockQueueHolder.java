package com.zafu.nichang;

import com.zafu.nichang.entity.dto.LogDTO;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 倪畅
 * @date 2019/2/22 15:53
 */
@Component
public class LogBlockQueueHolder {


    private static final LinkedBlockingQueue<LogDTO> LOG_QUEUE = new LinkedBlockingQueue<>();

    public void putMessage(LogDTO logDTO) throws InterruptedException {
        LOG_QUEUE.put(logDTO);
    }

    public String takeMessage() throws InterruptedException {
        return getMessageDetail(LOG_QUEUE.take());
    }
    private String getMessageDetail(LogDTO logDTO){
        StringJoiner stringJoiner = new StringJoiner("-", "[", "]");
        return stringJoiner.add(logDTO.getTimestamp())
                .add(logDTO.getLevel())
                .add(logDTO.getThreadName())
                .add(logDTO.getClassName())
                .add(logDTO.getMessage()).toString();
    }

    public Integer getSize() {
        return LOG_QUEUE.size();
    }

    public boolean isEmpty() {
        return LOG_QUEUE.isEmpty();
    }

}
