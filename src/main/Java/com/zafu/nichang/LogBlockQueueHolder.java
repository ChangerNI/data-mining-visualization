package com.zafu.nichang;

import com.zafu.nichang.entity.dto.LogDTO;
import com.zafu.nichang.service.impl.WebSpiderServiceImpl;

import java.util.StringJoiner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 倪畅
 * @date 2019/2/22 15:53
 */
public class LogBlockQueueHolder {

    private static final LogBlockQueueHolder INSTANCE = new LogBlockQueueHolder();
    private static final LinkedBlockingQueue<LogDTO> LOG_QUEUE = new LinkedBlockingQueue<>();

    public static LogBlockQueueHolder getInstance(){
        return INSTANCE;
    }
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
                .add(String.valueOf(WebSpiderServiceImpl.maxSize))
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
