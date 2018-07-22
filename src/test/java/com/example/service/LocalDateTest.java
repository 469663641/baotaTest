package com.example.service;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
}
