package com.mr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yaodd on 2018/11/12.
 */
public class MyDateUtil {

    public static void main(String[] args) {
        System.out.println(getMyDateStr(new Date(), -3));
    }

    /**
     * 获取时间String类型
     * @return
     */
    public static String getMyDateStr(Date date , int n ){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        if(n >= 0){
            c.set(Calendar.DATE,day + n);
        }else{
            c.set(Calendar.DATE,day - Math.abs(n));
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return format;
    }

    /**
     * 获取时间date类型
     * @return
     */
    public static Date getMyDateD(Date date , int n ){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        if(n >= 0){
            c.set(Calendar.DATE,day + n);
        }else{
            c.set(Calendar.DATE,day - Math.abs(n));
        }
        return c.getTime();
    }

}
