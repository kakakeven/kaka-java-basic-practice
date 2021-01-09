package com.lintrip.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Stack 概述：
 * 1 基于 Vector实现，底层数据结构为数组；
 * 2 扩展了 Vector，新增了 pop/push/peek/search 四个方法；
 * 3 pop和peek都会返回栈顶元素，pop 会移除栈顶元素；
 */
public class StackTestCase {

    /**
     * 验证栈的进出栈操作，Stack 基于线程安全的 Vector 实现
     */
    @Test
    public void stackCase1() {
        Stack<Integer> numStack = new Stack<>();
        // 入栈操作 1
        numStack.push(1);
        Assert.assertTrue(1 == numStack.peek());
        Assert.assertFalse(numStack.empty());
        // 入栈操作 2
        numStack.push(2);
        Assert.assertTrue(2 == numStack.peek());
        // 出栈操作 1
        Integer topNum = numStack.pop();
        Assert.assertTrue(2 == topNum);
        Assert.assertTrue(1 == numStack.peek());
    }

    /**
     * 栈的 search 操作基于 lastIndexOf()，表示从栈顶到元素的顺序
     */
    @Test
    public void stackCase2() {
        Stack<Integer> numStack = new Stack<>();
        numStack.push(1);
        numStack.push(2);
        numStack.push(3);
        numStack.push(4);
        numStack.push(5);
        Assert.assertTrue(1 == numStack.lastIndexOf(2));
        Assert.assertTrue(4 == numStack.search(2));
    }
}
