import java.util.Scanner;

/*
 * This is a basic version of thread synchronization
 * Using volatile keyword
 */

/*
 * When a variable is declared as volatile,
 * it indicates that the variable may be accessed 
 * and modified by multiple threads, 
 * and the value of the variable should always be read from 
 * and written to the main memory rather than 
 * being cached in a thread's local cache.
 */

class Processor extends Thread{
    /*
     * If there is no volatile keyword in use 
     * with running variable then some of the JVM will 
     * cache the value into the RAM and that cached value 
     * will never change util the program completes it's 
     * execution.
     */

    /*
     * There will be copies of running variable in different 
     * threads created to synchronize the variable usage we 
     * use volatile so that it can be seen by all the threads
     */ 

    /*
     * If we use volatile keyword if we change in any other 
     * thread then it will change in all the thread that was 
     * created
     */
    private volatile boolean running = true;
    @Override
    public void run() {
        while(running){
            System.out.println("Running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running = false;
    }
}

public class VolatileKeyword{
    public static void main(String arg[]){
        Processor proccess = new Processor();
        proccess.start();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        proccess.shutdown();
        sc.close();
    }
}
