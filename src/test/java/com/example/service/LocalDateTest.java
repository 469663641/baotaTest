package com.example.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by duguangquan on 2018/7/23.
 */
public class LocalDateTest {


    @Test
    public void convertLocalDateToDate(){

        //获取该时间点在该时区上的时间日期信息
        LocalDateTime now = LocalDateTime.now();
        //获取当前系统所在的时区
        ZoneId zoneId = ZoneId.systemDefault();
        //带有时区的时间
        ZonedDateTime zonedDateTime = now.atZone(zoneId);

        Date date = Date.from(zonedDateTime.toInstant());
        System.err.println(date);
    }

    @Test
    public void convertDateToLocalDate(){

        Date now = new Date();
        Instant instant = now.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);

        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.err.println(localDateTime);
    }

    @Test
    public void betweenDays(){

        LocalDate localDateStart = LocalDate.now();
        LocalDateTime localDateTime = localDateStart.atStartOfDay();

        ZonedDateTime zonedDateTime = localDateStart.atStartOfDay(ZoneId.systemDefault());

        Date startDate = Date.from(zonedDateTime.toInstant());

        LocalDate localDateEnd = localDateStart.plusDays(2L);

        long epochDayStart = localDateStart.toEpochDay();

        long epochDayEnd = localDateEnd.toEpochDay();

        System.err.println(epochDayEnd - epochDayStart);
    }

    @Test
    public void localDateTest(){

        //localDate
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        int dayOfWeek = now.getDayOfWeek().getValue();
        //构造日期
        LocalDate localDate = LocalDate.of(2018, 4, 12);
        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
        endOfFeb.minusDays(2L);

        //localTime
        LocalTime localTime = LocalTime.now();
        localTime.plusHours(2l);
        int hour = localTime.getHour();
        LocalTime now2 = LocalTime.now().withNano(0); // 11:09:09
        //构造时间
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00


    }

    @Test
    public void dateUtilsTest(){

        Date date = new Date();

        Date truncate = DateUtils
                .truncate(DateUtils.addDays(date, 2), Calendar.DATE);

        String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        String format2 = DateFormatUtils.format(new Date(), "yyyyMMdd");
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");

        String format1 = sdf.format(date);


    }
}
