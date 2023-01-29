package com.lintrip.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author kakakeven
 * @date 2022/8/19 17:51
 */
public class BlockingQueueTest {

    @Test(expected = IllegalStateException.class)
    public void testAdd() {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(2);

        blockingQueue.add("1");
        blockingQueue.add("2");
        System.out.println("blockingQueue  size:" + blockingQueue.size());

        blockingQueue.add("3");
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove() {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(2);

        blockingQueue.add("1");
        System.out.println("remove  element:" + blockingQueue.remove());

        blockingQueue.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testElement() {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(1);
        blockingQueue.element();
    }

    @Test
    public void testOffer() {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(2);

        blockingQueue.add("1");
        blockingQueue.add("2");
        System.out.println("blockingQueue  size:" + blockingQueue.size());

        boolean result = blockingQueue.offer("3");
        Assert.assertFalse(result);
    }

    @Test
    public void testPoll() {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(2);

        blockingQueue.add("1");
        System.out.println("remove  element:" + blockingQueue.poll());

        Assert.assertNull(blockingQueue.poll());
    }

    @Test
    public void testPeek() {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(1);
        blockingQueue.peek();
        Assert.assertNull(blockingQueue.peek());
    }

    @Test
    public void testPut() throws InterruptedException {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(2);

        blockingQueue.put("1");
        blockingQueue.put("2");
        System.out.println("[0]blockingQueue  size:" + blockingQueue.size());
        blockingQueue.put("3");
        System.out.println("[1]blockingQueue  size:" + blockingQueue.size());
    }

    @Test
    public void testTake() throws InterruptedException {
        BlockingQueue<String> blockingQueue =
            new ArrayBlockingQueue<>(2);

        blockingQueue.put("1");
        System.out.println("element is:" + blockingQueue.take());
        blockingQueue.take();
        System.out.println("[0]blockingQueue  size:" + blockingQueue.size());
    }
}
