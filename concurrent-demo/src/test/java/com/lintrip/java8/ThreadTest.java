package com.lintrip.java8;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 线程基础单测
 *
 * @date 2021/9/30 11:41
 */
public class ThreadTest {

    private static int count = 0;

    @Test
    public void testBasic() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("name:" + Thread.currentThread().getName());
            });
            thread.start();
        }
        Thread.sleep(1000);
    }

    @Test
    public void testExecutorService() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                System.out.println("name:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                }
            });
        }
        Thread.sleep(1000);
        executorService.shutdown();
    }

    /**
     * 处理共享资源的方式1：增加 synchronized 关键字阻止并发操作
     */
    @Test
    public void testShareResource() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                addCount();
            });
        }
        Thread.sleep(1000);
        executorService.shutdown();
        System.out.println(count);
    }

    private synchronized static void addCount() {
        count++;
    }

    /**
     * 使用读写锁对于共享的资源进行加锁处理
     */
    @Test
    public void testWRLock() throws InterruptedException {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                Lock syncLock = lock.writeLock();
                syncLock.lock();
                addCount();
                syncLock.unlock();
            });
        }
        Thread.sleep(1000);
        executorService.shutdown();
        System.out.println(count);
    }
}
