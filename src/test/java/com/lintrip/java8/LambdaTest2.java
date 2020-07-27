package com.lintrip.java8;

import org.junit.Test;

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

}
