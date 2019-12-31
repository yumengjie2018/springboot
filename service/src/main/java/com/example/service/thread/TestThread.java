package com.example.service.thread;

/**
 * title：TestThread
 * description:
 *
 * @author yumengjie
 * @date 2019/12/13 10:06
 */

public class TestThread {

    public static void main(String[] args) {
        MySyn mySyn=new MySyn();
        Thread t1=new Thread(mySyn,"线程1输出");
        Thread t2=new Thread(mySyn,"线程2输出");
        Thread t3=new Thread(mySyn,"线程3输出");

        t1.start();
        t2.start();
        t3.start();
    }
}
class MySyn implements Runnable {

    int tick = 10;

    @Override
    public void run() {
        while(true){
            synchronized (this) {
                if(tick>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + tick--);
                }
            }
        }
    }
}