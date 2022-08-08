package com.lintrip.java8;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTest {

    @Test
    public void testMove() {
        int a = 4;
        int b = a >> 1;
        Assert.assertEquals(2, b);
        int c = a << 2;
        Assert.assertEquals(16, c);
    }

    @Test
    public void testCompute() {
        int a = 3;
        int b = a & 0x1;
        Assert.assertEquals(1,b);
        int c = a | 0x1;
        Assert.assertEquals(3,c);
    }
}
