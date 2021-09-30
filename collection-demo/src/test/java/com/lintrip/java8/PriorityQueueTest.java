package com.lintrip.java8;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 优先级队列自测
 *
 * @date 2021/8/20 17:31
 */
public class PriorityQueueTest {

    @Test
    public void testCase1() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(6);
        priorityQueue.add(7);
        priorityQueue.add(2);
        System.out.println(priorityQueue);
    }
}
