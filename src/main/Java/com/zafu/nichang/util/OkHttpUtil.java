package com.zafu.nichang.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.concurrent.TimeUnit;

/**
 * 解析html类
 *
 * @author 倪畅
 * @version 1.0 2019-01-16
 */
public class OkHttpUtil {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);
    /**
     * 获取html
     * @param url
     * @param cookie
     * @return
     * @throws Exception
     */
    public static String getHtmlByOkHttp(String url, String cookie) throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("cookie", cookie)
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "0852c936-5062-a3da-7472-94340ce9eca4")
                .build();
        Response response = client.newCall(request).execute();
        if(response.code()== HttpStatus.OK.value()){
            return response.body().string();
        }else{
            return null;
        }
    }

}
