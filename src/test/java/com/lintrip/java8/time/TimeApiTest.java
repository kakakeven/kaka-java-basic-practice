package com.lintrip.java8.time;

import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TimeApiTest {

    @Test
    public void testInstant() {
        Instant now = Instant.now();
        System.out.println(now);

        Instant current = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant nano = Instant.ofEpochSecond(System.currentTimeMillis() / 1000);
        System.out.println(current);
        System.out.println(nano);
    }

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate special = LocalDate.of(2017, 7, 22);
        System.out.println(special);


    }

    @Test
    public void testDateConvertStr() {
        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(formatter.format(localDateTime1));

        // 将字符串日期解析成 LocalDateTime
        String timeStr = "2020-09-29 15:34:11";
        LocalDateTime localDateTime2 = LocalDateTime.parse(timeStr, formatter);
        System.out.println(localDateTime2);
    }

    @Test
    public void testDuration(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String timeStr = "2020-10-01";
        LocalDate specialDay = LocalDate.parse(timeStr, formatter);
        LocalDate now = LocalDate.now();
        Period period = Period.between(specialDay,now);
        System.out.println(period);
    }

}