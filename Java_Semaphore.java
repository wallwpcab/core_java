package sema.pb.step2;
public class Connection {
     private static Connection instance = new Connection();
     private int connections = 0;
     Connection(){
     
     }
     
}
public static Connection getInstance(){
            return instance;
            }public void connect() {
            synchronized(this) {
               connections++;
               System.out.println("Current Conneections : " + connections);
               
            }  try {
                   Thread.sleep(4000);
                   
             
             } catch(InterruptedException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
             }synchronized(this) {
                connections--;
             }
     }
     
     
package sema.pb.step2;
class MyThread implements Runnable{
      public void run(){
        Connection.getInstance().connect();
         // System.out.println("Client Thread");
      }}
      


package sema.pb.step2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class SemaPhoreDemo2{
       public static void main(String[] args) throws InterruptedException {
            ExecutorService = Executors.newCachedThreadPool();
              for(int i = 0; i < 100; i++){
                 sv.submit(new MyThread());
              }     
              sv.shutdown();
              sv.awaitTermination(1, TimeUnit.DAYS);
       }



}



package sema.step1;
import java.util.concurrent.Semaphore;
class MyThread extends Thread{
    Semaphore sem;
    String threadName;
    public MyThread(Semaphore sem, String threadName){
       super(threadName);
       this.sem = sem;
       this.threadName = threadName;
         
    
    
    } @Override
    public void run(){
      if(this.getName().equals("A")){
        System.out.println("Starting" + threadName);
        try{
            System.out.println(threadName + " ");
            sem.acquire();
            System.out.println(threadName + "" );
            for(int i = 0; i < 10; i++){
               Shared.count++;
               System.out.println(threadName + ": " + Shared.count);
               Thread.sleep(10);
            }  
        } catch(InterruptedException exc) {
                 System.out.println(exc);
            }
            System.out.println(threadName + "");
            sem.release();
      }
      else{
          System.out.println("Starting" + threadName);
          try{
             System.out.println();
             sem.acquire();
             System.out.println();
             for(int i = 0; i < 5; i++){
                Shared.count--;
                System.out.println(threadName + ": " +  Shared.count);
                Thread.sleep(10);
             }
          } catch (InterruptedException exc){
                System.out.println(exc);
          }
          System.out.println(threadName + " release the permit");
          sem.release();
      }
    }



 }
 
 
package sema.step1;
import java.util.concurrent.Semaphore;
public class SemaphoreDemo{
    public static void main(String args[]) throws InterruptedException {
       Semaphore sem = new Semaphore(1);
         MyThread mt1 = new Semaphore(1);
         MyThread mt2 = new MyThread(sem, "A");
         mt1.start();
         mt2.start();
         
         mt1.join();
         mt2.join();
         System.out.println("count: " + Shared.count);
        
    
    
    
    }

  }