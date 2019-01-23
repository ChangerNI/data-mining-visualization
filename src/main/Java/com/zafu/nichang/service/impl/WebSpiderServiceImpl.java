package com.zafu.nichang.service.impl;

import com.zafu.nichang.enums.ProductEnums;
import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.Constant;
import com.zafu.nichang.model.ParseHtmlBlockTask;
import com.zafu.nichang.service.WebSpiderService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class WebSpiderServiceImpl implements WebSpiderService {


    @Autowired
    private ProductMapper productMapper;

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(WebSpiderServiceImpl.class);

    public static ExecutorService htmlParserExecutorService = Executors.newFixedThreadPool(Constant.THREAD_COUNT,
            new BasicThreadFactory.Builder().namingPattern("html-parser-%d").daemon(true).build());

    @Override
    public void executeSpiderProductFromWeb() {
        try {
            // 是否需要 Cookie对象？？
            String cookie = "";

            // 等待子线程结束
            CountDownLatch waiter = new CountDownLatch(Constant.THREAD_COUNT);

            // 开启多线程 执行
            for (ProductEnums productEnums : ProductEnums.values()) {
                ParseHtmlBlockTask parseHtmlBlockTask = new ParseHtmlBlockTask(productEnums, cookie, waiter);
                parseHtmlBlockTask.setProductMapper(productMapper);
                htmlParserExecutorService.submit(parseHtmlBlockTask);
            }

            waiter.await();
            logger.info("子线程结束！");
        } catch (Exception e) {
            logger.info("error：", e);
        }
    }


}
