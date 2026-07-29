package Multithreading;

// 1st way of creating a thread
/*
class Mythread extends Thread {
    // Instance method
    void show() {
        System.out.println("Show method inside class Mythread");
    }

    @Override
    public void run() {
        System.out.println("run() method executed");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(4000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}   */

// 2nd way of creating a thread
class Mythread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("run() method executed");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(4000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threads {
    static void main() {
//        Mythread mythread = new Mythread();
//        mythread.start();
//        mythread.run();     // not thread class method its MyThread2 class method

        System.out.println("Using implements");

        Mythread2 mythread2 = new Mythread2();
        Thread th = new Thread(mythread2);
        th.start();
    }
}
