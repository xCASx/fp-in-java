package fp.in.java.resources.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locker {
    public static void runLocked(Lock lock, Runnable block) {
        lock.lock();

        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        runLocked(lock, () -> System.out.println("Some synchronized operation"));
    }
}
