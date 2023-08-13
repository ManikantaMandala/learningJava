import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueProducerConsumer {

    /*
     * All the synchronization is taken inside only
     * This ArrayBlockingQueue is a thread safe class
     * BlockingQueue is interface
     */
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Producer");
        Thread consumer = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Consumer");

        producer.start();consumer.start();

        producer.join();
        consumer.join();
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Integer value = random.nextInt(100);
            System.out.println("Value added: "+value);
            queue.put(value);
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 0) {
                Integer top = queue.take();
                System.out.println("Taken value " + top + "; Queue size is " + queue.size());
            }
        }
    }
}
