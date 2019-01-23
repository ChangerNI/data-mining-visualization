package com.zafu.nichang.util;

import com.zafu.nichang.enums.ProductEnums;
import com.zafu.nichang.model.ParseHtmlBlockTask;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 倪畅
 * @version 1.0 2019-01-16
 */
public class StartWebspiderUtil {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(StartWebspiderUtil.class);

    private static final Integer THREAD_COUNT = 5;

    public static ExecutorService htmlParserExecutorService = Executors.newFixedThreadPool(THREAD_COUNT,
            new BasicThreadFactory.Builder().namingPattern("html-parser-%d").daemon(true).build());

    /**
     * 爬虫开关入口
     *
     * @throws Exception
     */
    public void startSpider() {
        try {
            // 是否需要 Cookie对象？？
            String cookie = "";

            // 等待子线程结束
            CountDownLatch waiter = new CountDownLatch(THREAD_COUNT);

            // 开启多线程 执行
            for (ProductEnums productEnums : ProductEnums.values()) {
                ParseHtmlBlockTask parseHtmlBlockTask = new ParseHtmlBlockTask(productEnums, cookie, waiter);
                htmlParserExecutorService.submit(parseHtmlBlockTask);
            }

            waiter.await();
            logger.info("子线程结束！");
        } catch (Exception e) {
            logger.info("error：", e);
        }
    }

    /**
     * 获得产品属性列表
     * 弃用
     *
     * @param pattern
     * @param htmlBlocks
     * @return
     */
    @Deprecated
    private static LinkedList<String> mapToParamList(Pattern pattern, List<String> htmlBlocks) {
        return htmlBlocks.stream()
                .map(htmlBlock -> RegUtil.getRegInfoDetails(pattern, htmlBlock))
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}