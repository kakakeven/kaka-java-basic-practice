package com.lintrip.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda 表达式范例
 */
public class LambdaTest2 {

    /**
     * 无参无返回值
     */
    @Test
    public void testNoParamNoResult() {
        Runnable runnable = () -> System.out.println("Hello World!");
        new Thread(runnable).start();
    }

    @Test
    public void testMapReduce(){
        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("bc");
        list.add("cd");

        String result = list.stream().map(word -> word + " ")
            .reduce((a,b) -> a + "+" +b)
            .get();
        System.out.println(result);
    }
}
