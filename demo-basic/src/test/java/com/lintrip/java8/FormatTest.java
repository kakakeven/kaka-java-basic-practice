package com.lintrip.java8;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author kakakeven
 * @date 2022/8/10 14:36
 */
public class FormatTest {

    @Test
    public void testDecimalFormat(){
        double a = 3.84;
        double b = 3.20;
        double c = 3.00;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(a));
        System.out.println(decimalFormat.format(b));
        System.out.println(decimalFormat.format(c));
        DecimalFormat decimalFormat2 = new DecimalFormat("#.#");
        double d = 13.92;
        double e = 133.92;
        double f = 1300.96;
        double g = 1300.00;
        System.out.println(decimalFormat2.format(d));
        System.out.println(decimalFormat2.format(e));
        System.out.println(decimalFormat2.format(f));
        System.out.println(decimalFormat2.format(g));
    }

}
