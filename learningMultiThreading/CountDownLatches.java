import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
    private final CountDownLatch latch;

    Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // Simulating some work
            Thread.sleep(1000);

            System.out.println("Worker thread completed its task.");

            // Worker thread signals that it has completed its task
            latch.countDown();
            System.out.println("The current count: " + latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatches {

    public static void main(String[] args) throws InterruptedException {
        int workerCount = 5;
        CountDownLatch latch = new CountDownLatch(workerCount);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < workerCount; i++) {
            Thread worker = new Thread(new Worker(latch));
            worker.start();
        }
        long endTime = System.currentTimeMillis();
        // Main thread waits for all workers to complete
        latch.await();

        System.out.println("All workers have completed their tasks. Main thread resumes.");
        System.out.println("Time taken: " + (endTime-startTime));
    }

}
