/*
 * Synchronized block will make the code inside it 
 * Atomic meaning only one Thread can access the code 
 * at once.
 */

/*
 * The Atomic operation is the one appears to  occur instantaneously 
 * and cannot be interrupted by other threads.
 */

/*
 * This uses some locks to give access to the first comer thread.
 *
 * Locking an Object: Intrinsic locks are acquired by threads to 
 * gain exclusive access to a synchronized block or method.
 * When a thread encounters a synchronized block or method,
 * it attempts to acquire the lock associated with the object
 * on which the block or method is synchronized.
 *
 * Mutual Exclusion: Intrinsic locks enforce mutual exclusion,
 * meaning that only one thread can hold the lock for 
 * a particular object at any given time.
 * Other threads that try to acquire the same lock will be blocked 
 * and wait until the lock is released.
 *
 * Object-Level Locks: Intrinsic locks are associated with objects,
 * not methods or classes. When a synchronized block or method is encountered,
 * the lock being acquired is tied to the object 
 * on which the block or method is synchronized.
 * If multiple threads are accessing different instances of the same object,
 * they can still execute synchronized blocks 
 * or methods concurrently because each instance has its own lock.
 *
 * Reentrant Locking: Intrinsic locks support reentrant locking,
 * also known as recursive locking. 
 * This means that a thread can acquire the lock multiple times 
 * without causing a deadlock. Reentrant locking allows a thread 
 * to reenter synchronized code if it already holds the lock for that object,
 * preventing self-blocking.
 *
 * To release to lock we can use wait() which temporarily gives 
 * up the lock to other threads
 */
public class IntrinsicLock {
    private int count = 0;

    public static void main(String[] args) {
        IntrinsicLock sb = new IntrinsicLock();
        sb.doWork();
    }

    public synchronized void increament() {
        // if(count<=100){
        // // System.out.println(" I'm recursively"+
        // // " calling this increament() using ReentrantLock");
        // increament();
        // }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                increament();
            }

        }, "Thread 1");
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                increament();
            }

        }, "Thread 2");
        t1.start();
        t2.start();

        try {
            /*
             * thread.join() method is for waiting util this thread 
             * terminates.
             */
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
