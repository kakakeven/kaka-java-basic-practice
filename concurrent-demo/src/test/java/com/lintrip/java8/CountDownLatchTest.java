package com.lintrip.java8;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    @Test
    public void testCountDownLatch() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int sleepMillSecond = new Random().nextInt(1000);
                    try {
                        Thread.sleep(sleepMillSecond);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("线程执行时间:" + System.currentTimeMillis());
                    latch.countDown();
                }
            },"worker线程-" + i).start();
        }
        latch.await(1, TimeUnit.SECONDS);
        System.out.println("工作线程执行完毕");
    }
}
