package com.lintrip.java8;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * BigInteger 测试
 *
 * @date 2021/9/27 10:13
 */
public class BigIntegerTest {

    @Test
    public void testToString() {
        long a = System.currentTimeMillis();
        System.out.println(a);
        BigInteger abc = new BigInteger("2021092710151632708977116");
        System.out.println(abc.toString(36));
        String str36 = abc.toString(36);
        BigInteger origin = new BigInteger(str36, 36);
        System.out.println(origin.toString());

        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            System.out.println(r.nextInt(100));
        }
    }

}
