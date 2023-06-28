class Q{
    int i;
    boolean valueSet = false;
    synchronized void put(int i){
        while(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.i = i;
        valueSet = true;
        System.out.println("Put: "+ this.i);
        notify();
    }
    synchronized int get(){
        while(!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueSet = false;
        System.out.println("Got: "+ this.i);
        notify();
        return this.i;
    }
}
class Producer implements Runnable{
    Q q;
    Thread t;

    Producer(Q q){
        this.q = q;
        this.t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            q.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class Consumer implements Runnable{
    Q q;
    Thread t;

    Consumer(Q q){
        this.q = q;
        this.t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while(true){
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
public class ProducerConsumerThreads{
    public static void main(String[] args){
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        producer.t.start();
        consumer.t.start();

    }
}
