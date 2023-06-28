/*
 * Threads are independent path of execution within a program.
 * It consists of a sequence of instructions that can run 
 * concurrently with other threads.
 * In Java, you can create threads by extending the Thread class 
 * or implementing the Runnable interface.
 */

/*
 * Using extension of Thread class
 */
class Runner1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class CreatingThreads {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        /*
         * This will execute the run() method
         * creating a new thread
         */
        runner1.start();
        /*
         * This will execute the run() method
         * but In the 'MAIN THREAD'
         */
        runner1.run();

        /*
         * To create a new thread using
         * a class implementing Runnable interface
         * we need to pass the object of the class
         * as a parameter of Thread() constructor
         */
        Thread t1 = new Thread(new Runner2());
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
    }
}
