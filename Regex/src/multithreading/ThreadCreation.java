package multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadCreation {
    static void main() {
        MyThread t1 = new MyThread();
        t1.start();   // creates a new thread, run() executes on that new thread
        t1.run();    // does NOT create a new thread — just a normal method call, runs on the main thread itself
    }
}
