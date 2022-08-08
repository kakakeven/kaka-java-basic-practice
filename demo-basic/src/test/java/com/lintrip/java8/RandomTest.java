package com.lintrip.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomTest {

    private static final Random random = new Random();

    @Test
    public void testRandom(){
        int targetCount = 10;
        List<String> list = new ArrayList<>();
        for (int i = 0;i < 20;i++) {
            list.add(UUID.randomUUID().toString().replace("-",""));
        }
        for (int i = 0;i <20;i++) {
            random(list,targetCount);
        }
    }

    private void random(List<String> list,int targetCount){
        int num;
        int count = 0;
        int randomCount = 0;
        List<String> result = new ArrayList<>();
        while (true) {
            randomCount++;
            num = random.nextInt(list.size());
            if (!result.contains(list.get(num))) {
                result.add(list.get(num));
                count++;
                if (count == targetCount) {
                    break;
                }
            }
        }
        System.out.println(randomCount);
    }
}
