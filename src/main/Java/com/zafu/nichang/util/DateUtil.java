package com.zafu.nichang.util;

import com.zafu.nichang.model.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 倪畅
 * @version 1.0 2019-01-16
 */
public class DateUtil {


    /**
     * 得到未来一周的日期列表
     * @return
     */
    public List<String> getFutureDateList() {
        List<String> futureDateTime = new LinkedList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for(int i = 0; i< Constant.FUTURE_WEEK; i++){
            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
            futureDateTime.add(simpleDateFormat.format(date));
        }
        return futureDateTime;
    }
}
