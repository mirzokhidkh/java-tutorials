package com.mk.concurrency.daemon;

public class DaemonThread extends Thread{

    private final int n;

    public DaemonThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(Thread.currentThread().getName()+" -> "+i);
        }
//        System.out.println(Thread.currentThread().getThreadGroup());

    }


    public static void main(String[] args) throws InterruptedException {

        DaemonThread t1 = new DaemonThread(10);
        DaemonThread t2 = new DaemonThread(50);

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup());
//        t1.setDaemon(true);
        t1.start();
        t1.join();

        System.out.println(Thread.currentThread().getName());

//        t2.setDaemon(true);
        t2.start();
//        t2.join();

    }
}
