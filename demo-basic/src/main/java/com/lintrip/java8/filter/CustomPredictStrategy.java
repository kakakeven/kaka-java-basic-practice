package com.lintrip.java8.filter;

/**
 * Custom Predict
 *
 * @param <T>
 */
public interface CustomPredictStrategy<T> {

    /**
     * 是否匹配
     *
     * @param t
     * @return
     */
    boolean match(T t);
}
