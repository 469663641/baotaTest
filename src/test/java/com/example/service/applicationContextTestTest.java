package com.example.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by baota on 2018/2/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class applicationContextTestTest {

    @Test
    public void lambdaTest() {

        long startTime = System.currentTimeMillis();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        BigDecimal reduce = list.stream().map(n -> new BigDecimal(n)).reduce(BigDecimal.ZERO, BigDecimal::add);
        //reduce是对结果的聚合sum，avg,count
        //Integer reduce = list.stream().filter(number -> number > 2).reduce(0, Integer::sum);
        System.err.println(reduce);

    }

    @Test
    public void dateTest(){

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);

        Date time = c.getTime();
        Date truncate = DateUtils.truncate(DateUtils.addDays(time, 2), Calendar.DATE);

        String format = DateFormatUtils.format(truncate, "yyyy-MM-dd");
        System.err.println(format);
    }
}
