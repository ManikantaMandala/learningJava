public class test{
	public static void main(String[] args) {
	    Thread t1 = new Thread(new Runnable(){
	        public void run(){
	            System.out.println("A");
	            try{
	                System.out.println("B");
	            }
	            catch(Exception e){
	                System.out.println("C");
	            }
	        }
	    }, "Thread1");
	    Thread t2 = new Thread(new Runnable(){
	        public void run(){
	            System.out.println("D");
	            try{
	                t1.wait();
	            }
	            catch(Exception e){
	                System.out.println("E");
	            }
	            System.out.println("F");
	        }
	    }, "Thread2");
	    t1.start();
	    t2.start();
	    
	}
}
