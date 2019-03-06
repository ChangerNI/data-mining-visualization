package com.zafu.nichang.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.zafu.nichang.LogBlockQueueHolder;
import com.zafu.nichang.entity.dto.LogDTO;
import com.zafu.nichang.model.ParseHtmlBlockTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author 倪畅
 * @date 2019/2/22 15:46
 */
@Slf4j
@Component
public class LogFilter extends Filter<ILoggingEvent> {

    private static final String PARSE_HTML_BLOCK_TASK = ParseHtmlBlockTask.class.getName();

    private LogBlockQueueHolder logBlockQueueHolder = new LogBlockQueueHolder();

    @Override
    public FilterReply decide(ILoggingEvent event) {
        // 判断
        if(PARSE_HTML_BLOCK_TASK.equals(event.getLoggerName())) {
            LogDTO logDTO = LogDTO.builder()
                    .message(event.getFormattedMessage())
                    .timestamp(convertTimeToString(event.getTimeStamp()))
                    .level(event.getLevel().levelStr)
                    .threadName(event.getThreadName())
                    .className(event.getLoggerName())
                    .build();
            try {
                logBlockQueueHolder.putMessage(logDTO);
            } catch (InterruptedException e) {
                log.error("消息生成异常：", e);
            }
        }
        return FilterReply.ACCEPT;
    }
    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    private static String convertTimeToString(Long time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }
}
