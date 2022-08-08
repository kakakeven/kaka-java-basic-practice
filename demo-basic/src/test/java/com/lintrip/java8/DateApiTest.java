package com.lintrip.java8;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateApiTest {

    @Test
    public void testNow() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    @Test
    public void testGetMonth(){
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());

        LocalDate day = LocalDate.of(2022,05,27);
        System.out.println(day.equals(now));

        day.isLeapYear();

        MonthDay monthDay = MonthDay.of(5,27);
        System.out.println(monthDay);

        LocalDate after100 = day.plusDays(100);
        System.out.println(after100);

        LocalDate afterOneWeek = day.plus(1, ChronoUnit.WEEKS);
        System.out.println(afterOneWeek);
    }

    @Test
    public void testClock(){
        Clock clock1 = Clock.systemUTC();
        Clock clock2 = Clock.systemDefaultZone();
        long timestamp = System.currentTimeMillis();
        System.out.println(clock1.millis() + "   " + clock1.getZone());
        System.out.println(clock2.millis() + "   " + clock2.getZone());
        System.out.println(timestamp);
    }

    @Test
    public void testZone(){
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localDateAndTime, america);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }

    @Test
    public void testBetween(){
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2018, 12, 14);

        Period periodToNextJavaRelease = Period.between(java8Release, today);
        System.out.println("Months left between today and Java 8 release : "
            + periodToNextJavaRelease.getYears());
    }

    @Test
    public void testFormatAndParse(){
        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
            DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+"  格式化后的日期为:  "+formatted);

        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String str = date.format(format1);

        System.out.println("日期转换为字符串:"+str);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDate date2 = LocalDate.parse(str,format2);
        System.out.println("日期类型:"+date2);
    }
}
