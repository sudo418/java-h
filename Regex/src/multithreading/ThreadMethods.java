package multithreading;

class Myt implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ThreadMethods {
    static void main() {

        System.out.println("Current thread reference: " + Thread.currentThread());

        System.out.println("Current thread name: " + Thread.currentThread().getName());

        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        t.setName("Main worker");
        System.out.println("Current thread changed name: " + t.getName());

        Thread t1 = new Thread(() -> {
            System.out.println("Thread is running!"); // explanation in md file
            System.out.println("Name of this thread: " + Thread.currentThread().getName());
        });
        t1.start();

        Myt myt = new Myt();

        Thread t9 = new Thread(myt);
        t9.setName("Worker - 1");
        t9.start();

        Thread t10 = new Thread(myt);
        t10.setName("Worker - 2");
        t10.start();

        Thread t11 = new Thread(myt);
        t11.setName("Worker - 3");
        t11.start();
    }
}