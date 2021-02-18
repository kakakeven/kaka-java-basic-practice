package com.lintrip.java8;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    @Test
    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i< 5;i++) {
            new Thread(() -> {
                try {
                    System.out.println("开始执行并阻塞，当前阻塞线程数目:" + cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                    System.out.println("开始执行任务,执行时间:" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("执行完毕");
    }
}
