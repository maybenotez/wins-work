package com.wins.github.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CountTest {

    public static void main(String[] args) throws InterruptedException {

       // test(1,10000000);
       // test(4,10000000);
       // test(8,10000000);
        //test(16,10000000);
        test(32,10000000);
    }

    private static void test(int thread, int counts) throws InterruptedException {
        Count multiCount = new MultiCount();
        Count singleCount = new SingleCount();

        long start = System.currentTimeMillis();
        testCounts(multiCount, thread, counts);
        long mid = System.currentTimeMillis();
        System.out.println("thread:" + thread + "size:" + multiCount.size() + " multiCount time:"+(mid - start));
        testCounts(singleCount, thread, counts);
        long end = System.currentTimeMillis();
        System.out.println("thread:" + thread + "size:" + singleCount.size() + " singleCount time:"+(end - mid));
    }

    private static void testCounts(Count count,int thread, int times) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    count.addOne();
                }
            }
            ));
        }

        for (Thread t : threadList) {
            t.start();
        }

        for (Thread t : threadList) {
            t.join();
        }
    }
}
