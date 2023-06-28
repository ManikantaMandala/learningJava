import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedBlockMultipleLock {

    public Random random = new Random();

    public static List<Integer> list1 = new ArrayList<>();
    public static List<Integer> list2 = new ArrayList<>();

    public void stageOne() {
        synchronized(list1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized(list2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for(int i=0;i<1000;i++){
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting...");

        SynchronizedBlockMultipleLock obj = new SynchronizedBlockMultipleLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.process();
            }
        }, "Thread 1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.process();
            }
        }, "Thread 2");

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken: "+ (end-start));
        System.out.println("List1: "+ list1.size()+" List2: "+ list2.size());
    }
}
