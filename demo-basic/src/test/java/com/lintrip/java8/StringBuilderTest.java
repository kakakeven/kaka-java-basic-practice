package com.lintrip.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StringBuilderTest {

    @Test
    public void testBuilder1() {
        List<String> randomStrList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            randomStrList.add(UUID.randomUUID().toString());
        }
        Long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : randomStrList) {
            stringBuilder.append(s).append(",");
        }
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(stringBuilder);
    }

    @Test
    public void testBuilder2() {
        List<String> randomStrList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            randomStrList.add(UUID.randomUUID().toString());
        }
        Long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : randomStrList) {
            stringBuilder.append(stringBuilder).append(",");
        }
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(stringBuilder);
    }

}
