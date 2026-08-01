package multithreading;

class Mythread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadCreation2 {
    static void main() {
        Mythread mt = new Mythread();
        Thread t2 = new Thread(mt);
        t2.start();
        t2.run();
    }
}
