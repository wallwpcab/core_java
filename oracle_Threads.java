class primeThread extends Thread {
    long minPrime;
    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
       }
    public void run() {
       // compute primes larger than minPrime
       . . .
       }
       
     }
     
     PrimeThread p = new PrimeThread(143);
     p.start();
     
     
class PrimeRun implements Runnable{
       long minPrime;
          PrimeRun(long minPrime) {
            this.minPrime = minPrime;
          }
          
          public void run() {
             // compute primes larger than minPrime
          }
          
        }
        
class wali extends Thread{
  public void run(){
     System.out.println("The thread is running");
  }
  public static void main(String args[]){
     wali t1 = new wali();
     t1.start(); 
  }
}


class wali2 extends runnable{
   public void run(){
         System.out.println("The runnable thread is running ");
              
   }
   public static void main(String args[]){
     wali2 c1 = new wali2();
     Thread c2 = new Thread(c1);
     c2.start();
   }

}
      

class TestSleepMethod1 extends Thread {
   public void run() {
     for(int i = 1; i < 5; i++){
         try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
            }
          }
     public static void main(String args[]){
        TestSleepMethod t1 = new TestSleepMethid1();
        TestSleepMethod t2 = new TestSleepMethod1(); 
        
        t1.start();
        t2.start();
        }
    }
    
    

class TestSleepMethod1 extends Thread{  
   public void run(){  
      for(int i=1;i<5;i++){  
         try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
             System.out.println(i);  
       }  
 }  
 public static void main(String args[]){  
       TestSleepMethod1 t1=new TestSleepMethod1();  
           TestSleepMethod1 t2=new TestSleepMethod1();  
               t1.start();  
                  t2.start();  
        }  
}  


            
public class TestThreadTwice1 extends Thread{  
 public void run(){  
   System.out.println("running...");  
 }  
 public static void main(String args[]){  
  TestThreadTwice1 t1=new TestThreadTwice1();  
  t1.start();  
  t1.start();  
 }  
}  



class TestCallRun1 extends Thread{  
    public void run(){  
          System.out.println("running...");  
 }  
 public static void main(String args[]){  
      TestCallRun1 t1=new TestCallRun1();  
          t1.run();//fine, but does not start a separate call stack  
 }  
}  


class TestCallRun2 extends Thread{  
 public void run(){  
  for(int i=1;i<5;i++){  
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
    System.out.println(i);  
  }  
 }  
 public static void main(String args[]){  
  TestCallRun2 t1=new TestCallRun2();  
  TestCallRun2 t2=new TestCallRun2();  
   
  t1.run();  
  t2.run();  
 }  
}  


class TestJoinMethod1 extends Thread{
  public void run(){
     for(int i = 1; i <= 5; i++){
        try{
           Thread.sleep(500);
        }catch(Exception e){ 
            System.out.println(e);
                System.out.println(i);
        }
      }
      
      
public static void main(String args[]){
   TestJoinMethod1 t1 = new TestJoinMethod1();
   TestJoinMethod1 t2 = new TestJoinMethod1();
   TestJoinMethod1 t2 = new TestJoinMethod1();
   t1.start();
   try{
      t1.join();
   }catch(Exception e){System.out.println(e);
   t2.start();
   t3.start();
   }
}


class TestJoinMethod2 extends Thread{
   public void run(){
      for(int i = 1; i <= 5; i++) {
          try{
             Thread.sleep(500);
               }catch(Exception e){System.out.println(e);
               System.out.println(i); 
             }
           }
          public static void main(String args[]){
           TestJoinMethod2 t1 = new TestJoinMethod2();
            TestJoinMethod2 t2 = new TestJoinMethod2();
             TestJoinMethod2 t2 = new TestJoinMethod2();
              t1.start();
              
           try{ t1.join(1500);}
            catch(Exception e){System.out.println(e);}
              t2.start();
              t3.start();
             }
               }    
               
               



class TestJoinMethod3 extends Thread{  
  public void run(){  
   System.out.println("running...");  
  }  
 public static void main(String args[]){  
    TestJoinMethod3 t1=new TestJoinMethod3();  
      TestJoinMethod3 t2=new TestJoinMethod3();  
        System.out.println("Name of t1:"+t1.getName());  
          System.out.println("Name of t2:"+t2.getName());  
             System.out.println("id of t1:"+t1.getId());  
  
  t1.start();  
  t2.start();  
  t1.setName("Sonoo Jaiswal");  
  System.out.println("After changing name of t1:"+t1.getName());  
 }  
}  




class TestJoinMethod4 extends Thread{  
 public void run(){  
  System.out.println(Thread.currentThread().getName());  
 }  
 }  
 public static void main(String args[]){  
  TestJoinMethod4 t1=new TestJoinMethod4();  
  TestJoinMethod4 t2=new TestJoinMethod4();  
  
  t1.start();  
  t2.start();  
 }  
}  


class ThreadExample extends Thread {
  public void run() {
    MultiThreading.task("Thread");
  }
 }
class RunnableExample implements Runnable{
  public void run() {
    MultiThreading.task("Runnable");
   }
}
public class MultiThreading {
  public static void task(String TaskName){
    for(int i = 1; i <= 10; i++){
       System.out.println("");
         try{
           Thread.sleep(new Random().nextInt(10));
         } 
         catch(InterruptedException e){
             e.printStackTrace(); 
        }   
    }
  }
}
public static void main(String args[]){
  ThreadExample thr1 = new ThreadExample();
     thr1.start();
       RunnableExample run1 = new RunnableExample();
          new Thread(run1).start();
              ThreadExample thr2 = new ThreadExample();     
                 thr2.start();
                    RunnableExample();
                       new Thread(run2).start();  
 }                
 



startButton.addActionListener{ 
  new ActionListener() {
     public void actionPerformed(ActionEvent evt){
         this.stop = false;
           for(int i = 0; i < 100000; i++) {
              if( this.stop) break;
                 tfCount.setText("" + countValue);
                   countValue++;
           }
     }
     });


Runnable runnable = new NewState();
Thread t = new Thread(runnable);
Log.info(t.getState());


Runnable runnable = new NewState();
Thread t = new Thread(runnable);
t.start();
Log.info(t.getState());



btnStart.addActionListener(new ActionListener) {
  public void actionPerformed(ActionEvent evt){
     this.stop = false;
       Thread counter = new CounterThread();
          counter.start();
      }
   });


Inner class
class CounterThread extends Thread {
  public void run() {
     for (int i = 0; i < 100000; i++) {
          if(this.stop) {break;}
          tfCount.setText("" + countValue);
          countValue++;
          try{
             sleep(10);
            }catch(InterruptedException e)
          }
  }
}
  

btnStart.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent){
     this.stop = false;
        new Thread() {
          public void run() {
             for(int i = 0; i < 100000; i++) {
                if(this.stop) {
                   tfCount.setText("" + countValue);
                      countValue++;
                         try{
                            sleep(1000);
                         } catch(Interrupted Exception ex) {}
                }
             }
          } .start();
        }
        });
  }
  
  
class Nakh implements Runnable {
   static int counter = 0;
      public void run(){
         System.out.println(++counter);
      }

}

public class NakhKeshi {
   public static void main(String[] args){
       for(int i = 1; i < 8; i++){
           new Thread(new Nakh()).start();
       }
   }
 }
 
 
public class BankAccount{
   private float balance;
     public synchronized void deposit (float amount){
        balance += amount;
     }
     public synchronized void withdraw(float amount){
        balance -= amount;
     }
}

class Waiter implements Runnable{
   CountDownLatch latch = null;
   public Waiter(CountDownLatch latch){
      this.latch = latch;
    }
    public void run() {
      try {
        latch.await();
      } catch(InterruptedException e){
          e.printStackTrace();
      }
      System.out.println("Waiter released");
       
    }
   }
   
   
class Decrementer implements Runnable{
   CountDownLatch latch = null;
     public Decrementer(CountDownLatch latch){
       this.latch = latch;
     }
     public void run() {
       try{
          Thread.sleep(1000);
          this.latch.countDown();
          Thread.sleep(1000);
          this.latch.countDown();
          Thread.sleep(1000);
          this.latch.countDown();
       }  catch(InterruptedException e) {
           e.printStackTrace();
       }
}


  Exchanger exchanger = new Exchanger();
  ExchangerRunnable exchangerRunnable1 = 
         new ExchangerRunnable(exchanger, "A");
   
  ExchangerRunnable exchangerRunnable2 = 
         new ExchangerRunnable(exchanger, "B");   
  new Thread(exchangerRunnable1).start();
  new Thread(exchangerRunnable2).start();        
  


class ExchangerRunnable implements Runnable{
   Exchanger exchanger = null;
   Object object = null;
   public ExchangerRunnable(Exchanger exchanger, Object object){
      this.exchanger = exchanger;
         this.object = object;
   }
   public void run() {
     try{
         int sleep = (int) (Math.random() * 10000);
         Thread.sleep(sleep);
         System.out.println("[" + new Date()+") wake up
         Object previous = this.object;
         this.object = this.exchanger.exchange(this.object);  
         System.out.println("[" + new Date() + "]" + 
                   
                   Thread.currentThread().getName() + "exchanged" + previous + "for" + this.object
                   
          );
          
       } catch (InterruptedException e){ e.printStackTrace();}
   }



}  


Runnable barrierAction = new Runnable() {
  public void run() {System.out.println("");}
  
};
Runnable barrier2Action = new Runnable() {
  public void run() {System.out.println("");}
};

  CyclicBarrier barrier1 = new CyclicBarrier(2, );
  CyclicBarrier barrier1 = new CyclicBarrier(2, );
  CyclicBarrierRunnable barrierRunnable1 = 
      new CyclicBarrierRunnable(barrier1, barrier2);
  
  CyclicBarrierRunnable barrierRunnable2 = 
      new CyclicBarrierRunnable(barrier1, barrier2);
      
  new Thread(barrierRunnable1).start();
  new Thread(barrierRunnable2).start();    
   
   
class CyclicBarrierRunnable implements runnable{
    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;
    public CyclicBarrierRunnable(CyclicBarrier barrrier1, CyclicBarrier barrier2){
       this.barrier1 = barrier1; 
           this.barrier2 = barrier2;
    }
    public void run() {
       try{
          Thread.sleep((long) )
       }
    }
    
}   



class TestMultiPriority1 extends Thread{
   public void run(){
      System.out.println("running thread name is:"+Thread.currentThread().getName());
      System.out.println("running thread name is:"+Thread.currentThread().getName());
      
   }
   public static void main(String args[]){
      TestMultiPriority m1 = new TestMultiPriority1();
      TestMultiPriority m1 = new TestMultiPriority1();
      m1.setPriority(Thread.MIN_PRIORITY);
      m2.setPriority(Thread.MAX_PRIORITY);
      m1.start();
      m2.start();
      
   }
}


class TestDaemonThread2 extends Thread{
  public void run(){
    System.out.println("");
       System.out.println("");
  }
  
  public static void main(String[] args){
    TestDaemonThread2 t1 = new TestDaemonThread2();
    TestDaemonThread2 t2 = new TestDaemonThread2();
    t1.start();
    t1.setDaemon(true);
    t2.start();
  }
}


// WorkerThread.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class WorkerThread implements Runnable{
  private String message;
    public WorkerThread(String s){
      this.message = s;
    }
    public void run(){
      System.out.println(Thread.currentThread().getName());
      processmessage();
      System.out.println(Thread.currentThread().getName() + ("End"));
    }
    private void processmessage(){
      try{
         Thread.sleep(2000);
      } catch(InterruptedException e) { e.printStackTrace(); } 
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class WorkerThread implements Runnable{
  private String message;
    public WorkerThread(String s){
      this.message = s;
    }
    public void run(){
      System.out.println(Thread.currentThread());
      processmessage();
      System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name 
      
    }
    
    private void processmessage(){
      try{
          Thread.sleep(2000);
       } catch(InterruptedException e) { e.printStackTrace(); } 
    }

}


public class TestThreadPool{
  public static void main(String[] args){
    ExecutorService executor = Executors.newFixedThreadPool(5);
       for(int i = 0; i < 10; i++){
          Runnable worker = new WorkerThread("" + i);
          executor.execute(worker);
       }
       executor.shutdown();
       while(!executor.isTerminated()) { }
       System.out.println("Finished all threads");
    
  }

}