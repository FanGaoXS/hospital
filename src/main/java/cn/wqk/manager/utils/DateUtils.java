package cn.wqk.manager.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/23/19:53
 * @Description: Date日期工具类
 */
public class DateUtils {
    /**
     *  获取系统时间并且转换为能存入MySQL的datetime的格式
     * @return
     */
    public static Timestamp nowDateTime(){
        //获取系统当前时间，格式：Tue Jun 23 19:57:59 CST 2020
        Date date = new Date();
        //获取系统当前时间的时间戳，格式：1592913479942
        long dataTime = date.getTime();
        //把时间戳转换为能够存入MySQL的datetime的时间格式
        Timestamp timestamp = new Timestamp(dataTime);
        return timestamp;
    }


    /**
     *  获取今天是这周的星期几
     * @return 星期几
     */
    public static int nowDayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        int day=i-1;
        return day;
    }

    /**
     *  获取本周星期一到星期五的日期
     * @return Map<星期几,日期>
     */
    public static Map<Integer,Date> dateOfWeek(){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        Map<Integer,Date> weekMap=new HashMap<>();
        weekMap.put(1,new Date(System.currentTimeMillis()-(day-1)*1000*60*60*24));
        weekMap.put(2,new Date(System.currentTimeMillis()-(day-2)*1000*60*60*24));
        weekMap.put(3,new Date(System.currentTimeMillis()-(day-3)*1000*60*60*24));
        weekMap.put(4,new Date(System.currentTimeMillis()-(day-4)*1000*60*60*24));
        weekMap.put(5,new Date(System.currentTimeMillis()-(day-5)*1000*60*60*24));
        return weekMap;
    }
}
