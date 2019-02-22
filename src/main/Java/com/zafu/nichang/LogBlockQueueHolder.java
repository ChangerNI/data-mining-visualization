package com.zafu.nichang;

import com.zafu.nichang.entity.dto.LogDTO;
import com.zafu.nichang.model.ParseHtmlBlockTask;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 倪畅
 * @date 2019/2/22 15:53
 */
@Component
public class LogBlockQueueHolder {

    private static final String PARSE_HTML_BLOCK_TASK = ParseHtmlBlockTask.class.getName();
    private static final LinkedBlockingQueue<LogDTO> LOG_QUEUE = new LinkedBlockingQueue<>();

    public void putMessage(LogDTO logDTO) throws InterruptedException {
        if(PARSE_HTML_BLOCK_TASK.equals(LOG_QUEUE.take().getClassName())){
            LOG_QUEUE.put(logDTO);
        }
    }

    public String takeMessage() throws InterruptedException {
        return getMessageDetail(LOG_QUEUE.take());
    }
    private String getMessageDetail(LogDTO logDTO){
        StringJoiner stringJoiner = new StringJoiner("]", "[", "-");
        return stringJoiner.add(logDTO.getTimestamp())
                .add(logDTO.getLevel())
                .add(logDTO.getThreadName())
                .add(logDTO.getClassName())
                .add(logDTO.getMessage()).toString();
    }



}
