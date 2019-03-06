package com.zafu.nichang.model;

import java.util.regex.Pattern;

/**
 * 常量类
 * @author 倪畅
 * @version 1.0 2019-01-16
 */
public class Constant {
    public static final Integer FUTURE_WEEK = 7;
    /**
     * 最大线程数：5
     */
    public static final Integer THREAD_COUNT = 5;

    /**
     * 产品名称
     */
    public static final String OTA_WEB_PRODUCT_REG = "(padding-left:5px;\">)([\\d\\D]{0,12})(<\\/td>)";
    /**
     * 产品属性(包含日期)
     */
    public static final String OTA_WEB_DETAIL_REG = "(<td>)([\\d\\D]{1,10})(<\\/td>)";
    /**
     * 产品块
     */
    public static final String OTA_WEB_HTML_BLOCK_REG = "(padding-left:5px;\">)([\\d\\D]{0,170})(<td><\\/td><\\/tr>)";
    /**
     * 最大页数
     */
    public static final String OTA_WEB_HTML_LAST_PAGE_REG = "(list\\/)([\\d\\D]{0,10})(.shtml\" title=\"尾页\">)";
    /**
     * 为了提高效率，进行重复调用的compile方法常量化
     */
    public static final Pattern OTA_WEB_PRODUCT_REG_PATTERN = Pattern.compile(OTA_WEB_PRODUCT_REG);
    public static final Pattern OTA_WEB_DETAIL_REG_PATTERN = Pattern.compile(OTA_WEB_DETAIL_REG);
    public static final Pattern OTA_WEB_HTML_BLOCK_REG_PATTERN = Pattern.compile(OTA_WEB_HTML_BLOCK_REG);
    public static final Pattern OTA_WEB_HTML_LAST_PAGE_REG_PATTERN = Pattern.compile(OTA_WEB_HTML_LAST_PAGE_REG);

}
