package com.example.service.thread;

import com.example.service.config.RedisTemplateService;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * title：TestRunable
 * description:
 *
 * @author yumengjie
 * @date 2019/12/13 14:27
 */

public class TestRunable {
    static class NumberWrapper {
        public int value = 1;
    }
    String ll= new String("Good");
    String kk=new String();
    public static void main(String[] args) {

        // 初始化可重入锁
        final Lock lock = new ReentrantLock();

        // 第一个条件当屏幕上输出到3
        final Condition reachThreeCondition = lock.newCondition();
        // 第二个条件当屏幕上输出到6
        final Condition reachSixCondition = lock.newCondition();

        // NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
        // 注意这里不要用Integer, Integer 是不可变对象
        final NumberWrapper num = new NumberWrapper();
//
        Thread thread=new Thread(()->{
                // 需要先获得锁
                lock.lock();
        try {
            System.out.println("threadA start write");
            // A线程先输出前3个数
            while (num.value <= 3) {
                System.out.println(num.value);
                num.value++;
            }
            // 输出到3时要signal，告诉B线程可以开始了
            reachThreeCondition.signal();
        } finally {
            lock.unlock();
        }
        lock.lock();
        try {
            // 等待输出6的条件
            reachSixCondition.await();
            System.out.println("threadA start write");
            // 输出剩余数字
            while (num.value <= 9) {
                System.out.println(num.value);
                num.value++;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }}
        );
        thread.start();
    }
}