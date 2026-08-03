package multithreading;

public class ThreadLifeCycle {
    static void main() {

        // Reference to the currently executing thread (main thread)
        Thread mainThread = Thread.currentThread();

        Thread t4 = new Thread(() -> {
            System.out.println("Current thread name: " + Thread.currentThread().getName());
            System.out.println("Main thread state: " + mainThread.getState());
        });
        System.out.println("Current State: " + t4.getState());

        t4.start();
        // After start(), the thread becomes RUNNABLE.
        // Whether this print statement executes before, during,
        // or after the new thread depends entirely on the JVM's
        // thread scheduler.

        // At this moment, the thread may be:
        // RUNNABLE  -> waiting for CPU or currently executing.
        // TERMINATED -> if it has already finished execution. (The exact state depends on thread scheduling.)
        System.out.println("Current State: " + t4.getState());

        // Checking again.
        // Depending on timing, the state can still be RUNNABLE
        // or it may already have become TERMINATED.
        System.out.println("Current State: " + t4.getState());

        try {
            // System.out.println(Thread.currentThread().getState());
            // Calling getState() here returns RUNNABLE because the
            // current thread has not entered sleep() yet.
            // The thread changes to TIMED_WAITING only after
            // Thread.sleep() begins executing
            Thread.sleep(2000);
            // This pauses ONLY the main thread for 2 seconds.
            // During this time, the main thread enters the TIMED_WAITING state.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After 2 seconds, t4 has almost certainly completed,
        // so its state is usually TERMINATED.
        System.out.println(t4.getState());
    }
}
/*
Generally, after calling start(), the new thread does not finish immediately, so it usually executes
the next print statement, and it rarely prints terminated.
We called Thread.sleep(2000) on the main thread, so the main thread waits for
2 seconds. During this time, t4 completes its execution, so its state becomes
TERMINATED. */