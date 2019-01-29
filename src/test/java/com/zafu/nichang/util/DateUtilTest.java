package com.zafu.nichang.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 日期测试类
 * @author 倪畅
 * @date 2019/1/29 14:05
 */
public class DateUtilTest {

    private DateUtil dateUtil = new DateUtil();

    @Test
    public void getFutureDateList() {
        List<String> dateList = dateUtil.getFutureDateList();
        System.out.println(dateList);
    }
}