package com.wins.github.work;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一种 高效并发计数器 并且线程安全
 */
public class MultiCount implements Count{

    private AtomicInteger[] counts;

    public MultiCount(){
        counts = new AtomicInteger[Runtime.getRuntime().availableProcessors()];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = new AtomicInteger(0);
        }
    }
    @Override
    public void addOne() {
        long id = Thread.currentThread().getId();
        int index = (int) (id % counts.length);
        counts[index].incrementAndGet();
    }

    @Override
    public int size() {
        int size = 0;
        for (AtomicInteger count : counts) {
            size += count.get();
        }
        return size;
    }





}
