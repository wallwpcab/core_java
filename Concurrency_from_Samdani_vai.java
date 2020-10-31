package volatie.normalvarrinth;
class MyThread extends Thread {
    private volatile int testValue; // always primetives
    public MyThread(String str){
        super(str);
    }public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(getName() + " : "+i);
                if (getName().equals("Thread 1")){
                    testValue = 10;
                }if (getName().equals("Thread 2")){
                    System.out.println( "Test Value : " + testValue);
                }   Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
package volatie.normalvarrinth;
public class VoltileDemo {
	public static void main(String args[]) {
		new MyThread("Thread 1").start();
		new MyThread("Thread 2").start();
	}

}



packagae volatile.normalvarrinth;
class MyThread extends Thread{
	private volatile int testValue; // always primetivees
    public MyThread(String str){
      super(str);
    }
    public void run(){
      for(int i = 0; i < 3; i++){
         try{
            System.out.println(getName() + " : " +i);
            if(getname().equals("Thread 1") ){
               testValue = 10;
            }if(getname.equals("Thread 2")){
               System.out.println("Test Value :" + testValue);
            }
            Thread.sleep(1000);
            } catch (InterruptedException exception)
                  exception.printStackTrace();
            
         }
      }
    }

}
package volatile.normalvarrinth;
public class VolatileDeom{
    public static void main(String args[]){
        new MyThread("Thread 1").start();
        new MyThread("Thread 2").start();
        
    }
 }


package th.local.step2;
public class ThreadLocalDemo {
	public static void main(String[] args) {
		MyThread commonInstance = new MyThread();

	      Thread t1 = new Thread(commonInstance);
	      Thread t2 = new Thread(commonInstance);
	      Thread t3 = new Thread(commonInstance);
	      Thread t4 = new Thread(commonInstance);

	      t1.start();
	      t2.start();
	      t3.start();
	      t4.start();
		
		

	}

}
package th.local.step2;
public class MyThread implements Runnable {
	int count = 0;
	ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<Integer>();
	@Override
	public void run() {
		count++;
		System.out.println("Counter: " + count);
		System.out.println("threadLocalCounter: " + threadLocalCounter.get());
	}

}



package sema.pb.step2;
public class Connection {
	private static Connection instance = new Connection();
	private int connections = 0;
	Connection() {
		
	}public static Connection getInstance() {
		return instance;
	}public void connect() {
		synchronized (this) {
			connections++;
			System.out.println("Current Connections : " + connections);
		}try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}synchronized (this) {
			connections--;
		}

	}

}


package sema.pb.step2;
    class MyThread implements Runnable{
		public void run(){
			Connection.getInstance().connect();
    	// System.out.println("Client Thread");
    }
		
}


package sema.pb.step2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class SemaPhoreDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService sv = Executors.newCachedThreadPool();
		    for(int i=0;i<100;i++){
		        sv.submit(new MyThread());
		}sv.shutdown();
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
    }	
	@Override
    public void run() {
        // run by thread A
        if(this.getName().equals("A")){
            System.out.println("Starting " + threadName);
            try{
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");
                // acquiring the lock
                sem.acquire();
                System.out.println(threadName + " gets a permit.");
				// Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for(int i=0; i < 5; i++){
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);
                    // Now, allowing a context switch -- if possible.
                    // for thread B to execute
                    Thread.sleep(10);
                }} catch (InterruptedException exc) {
                    System.out.println(exc);
                }// Release the permit.
                System.out.println(threadName + " releases the permit.");
                sem.release();
        }// run by thread B
        else{
            System.out.println("Starting " + threadName);
            try{
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");
				// acquiring the lock
                sem.acquire();
				System.out.println(threadName + " gets a permit.");
				// Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for(int i=0; i < 5; i++){
                    Shared.count--;
                    System.out.println(threadName + ": " + Shared.count);
        
                    // Now, allowing a context switch -- if possible.
                    // for thread A to execute
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                    System.out.println(exc);
                }
                // Release the permit.
                System.out.println(threadName + " releases the permit.");
                sem.release();
        }
    }
}






package sema.step1;
import java.util.concurrent.Semaphore;
    //Driver class
    public class SemaphoreDemo{
    public static void main(String args[]) throws InterruptedException{
     // creating a Semaphore object
     // with number of permits 1
     Semaphore sem = new Semaphore(1);
     // creating two threads with name A and B
     // Note that thread A will increment the count
     // and thread B will decrement the count
     MyThread mt1 = new MyThread(sem, "A");
     MyThread mt2 = new MyThread(sem, "B");
     // stating threads A and B
     mt1.start();
     mt2.start();
     // waiting for threads A and B
     mt1.join();
     mt2.join();
     // count will always remain 0 after
     // both threads will complete their execution
     System.out.println("count: " + Shared.count);
 }
}



package sema.step1;
//A shared resource/class.
class Shared{
  static int count = 0;
}



package sema.su.step2;
import java.util.concurrent.Semaphore;
public class Connection {
	private static Connection instance = new Connection();
	private Semaphore sema =new Semaphore(5); // limit access no of thread
	// Semaphores allow you to control how many threads can access a resource simultaneously; 
	private int connections = 0;
	Connection() {}
	public static Connection getInstance() {
		return instance;
	}public void connect() {
	    try {
			sema.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); }
			synchronized (this) {
			connections++;
			System.out.println("Current Connections : " + connections);
		}try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}synchronized (this) {
			connections--;
		}sema.release();

	}

}



package sema.su.step2;
class MyThread implements Runnable{
		public void run(){
        Connection.getInstance().connect();
    	// System.out.println("Client Thread");
    }
		
}



package sema.su.step2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class SemaPhoreDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService sv = Executors.newCachedThreadPool();
		    for(int i=0;i<100;i++){
		        sv.submit(new MyThread());
	    }sv.shutdown();
		sv.awaitTermination(1, TimeUnit.DAYS);

	}
}




package que.problem.step1;
class BlockHole {
	   private int contents;
	   private boolean available = false;
	   public synchronized int get() {
	      while (available == false) {
	         try {
	            wait();
	         } catch (InterruptedException e) {}
	      }
	      available = false;
	      notifyAll();
	      return contents;
	   }public synchronized void put(int value) {
	      while (available == true) {
	         try {
	            wait();
	         } catch (InterruptedException e) { } 
	      }
	      contents = value;
	      available = true;
	      notifyAll();
	   }
	}



package threadpool.step1;

public class PrintJob implements Runnable {

	String name;

	public PrintJob(String name) {

		this.name = name;
	}

	@Override
	public void run() {
		
		System.out.println(name+"job started : "+Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println(name+"job ended : "+Thread.currentThread().getName());

	}

}

package threadpool.step1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	 public static void main(String[] args) {
		
		 
		 PrintJob[] jobs=  {new PrintJob("masum5"),new PrintJob("masum4"),new PrintJob("masum3"),new PrintJob("masum2"),new PrintJob("masum1")};
		
		 
		 ExecutorService sv = Executors.newFixedThreadPool(2);
		 for(PrintJob job : jobs) {
			 sv.submit(job);
		 }
		 
		 sv.shutdown();
		 
		 
	}
}


package callfuture.step2;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

	int num=0;

	public MyCallable(int num) {

		this.num = num;
	}

	// this thread can return value 
	
	@Override
	public Object call() throws Exception {
		
		System.out.println(Thread.currentThread().getName()+"---is responisble first :"+num+"numbers");
		
		int sum =0;
		
		for(int i=1;i <= num;i++) {
			
			sum = sum + i;
		}
		
		
		return sum;
	}
	
	


}


package callfuture.step2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	 public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		 
		 MyCallable[] jobs=  {new MyCallable(10),new MyCallable(20),new MyCallable(30),new MyCallable(40),new MyCallable(50)};
		
		 
		 ExecutorService sv = Executors.newFixedThreadPool(2);
		 for(MyCallable job : jobs) {
			
			 
			 Future f = sv.submit(job);
			 
			 System.out.println(f.get());
		 }
		 
		 sv.shutdown();
		 
		 
	}
}


package reentrant.step3;
class ThreadDemo {
	public static void main(String args[]) {
		MyThread t1 = new MyThread( "masum");
		MyThread t2 = new MyThread( "morad");
		t1.start();
		t2.start();

	}

}


package reentrant.step3;

import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread {

	static ReentrantLock lk= new ReentrantLock();


	MyThread( String name) {
		
	super(name);

	}

	public void run() {
		
		
		if(lk.tryLock()) {
			
			System.out.println(Thread.currentThread().getName()+"... Get lock and perform safe operation");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			
			lk.unlock();
			
		}else {
			System.out.println(Thread.currentThread().getName()+"... unable to get lock and perform alternative operation");
		}
		
		
	}

}


package reentrant.step2;

class ThreadDemo {

	public static void main(String args[]) {

		Display d =new  Display();

		MyThread t1 = new MyThread(d, "masum");

		MyThread t2 = new MyThread(d, "morad");

		t1.start();
		t2.start();

	}

}


package reentrant.step2;

class MyThread extends Thread {

	Display d;
	String name;

	MyThread(Display d, String name) {

		this.d = d;
		this.name = name;

	}

	public void run() {
		d.wish(name);
	}

}



package reentrant.step2;

import java.util.concurrent.locks.ReentrantLock;

class Display {

	ReentrantLock lk= new ReentrantLock();
	
	public void wish(String name) {
      lk.lock();
		for (int i = 0; i <= 10; i++) {

			System.out.print("\nGood Morning :");
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				

			}
			System.out.print(name);
		}
		lk.unlock();
	}

}




package reentrant.step1;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlock2 {
	
	public static void main(String[] args) {
		
		ReentrantLock  lk=new ReentrantLock();
		lk.lock();
		lk.lock();
		System.out.println(lk.isLocked());
		System.out.println(lk.isHeldByCurrentThread());
		System.out.println(lk.getQueueLength());
		lk.unlock();
		System.out.println(lk.getHoldCount());
		System.out.println(lk.isLocked());
		lk.unlock();
		System.out.println(lk.isLocked());
		System.out.println(lk.isFair());
		
		
	}

}



package readwrite.lock.step4;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	   private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	   private static String message = "masum";

	   public static void main(String[] args) throws InterruptedException {
	      Thread t1 = new Thread(new WriterA());
	      t1.setName("Writer A");
	      
	      Thread t2 = new Thread(new WriterB());
	      t2.setName("Writer B");
	      
	      Thread t3 = new Thread(new Reader());
	      t3.setName("Reader");
	      t1.start();
	      t2.start();
	      t3.start();
	      t1.join();
	      t2.join();
	      t3.join();
	   }
	   static class Reader implements Runnable {
	      public void run() {
	         if(lock.isWriteLocked()) {
	            System.out.println("Write Lock Present.");
	         }
	         lock.readLock().lock();
	         try {
	            Long duration = (long) (Math.random() * 10000);
	            System.out.println(Thread.currentThread().getName() 
	               + "  Time Taken " + (duration / 1000) + " seconds.");
	            
	            Thread.sleep(duration);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         } finally {
	            System.out.println(Thread.currentThread().getName() +": "+ message );
	            lock.readLock().unlock();
	         }
	      }
	   }
	   static class WriterA implements Runnable {
	      public void run() {
	         lock.writeLock().lock();
	         try {
	            Long duration = (long) (Math.random() * 10000);
	            System.out.println(Thread.currentThread().getName() 
	               + "  Time Taken " + (duration / 1000) + " seconds.");
	            
	            Thread.sleep(duration);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         } finally {
	            message = message.concat("a");
	            lock.writeLock().unlock();
	         }
	      }
	   }
	   static class WriterB implements Runnable {
	      public void run() {
	         lock.writeLock().lock();
	         try {
	            Long duration = (long) (Math.random() * 10000);
	            System.out.println(Thread.currentThread().getName() 
	               + "  Time Taken " + (duration / 1000) + " seconds.");
	            
	            Thread.sleep(duration);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         } finally {
	            message = message.concat("b");
	            lock.writeLock().unlock();
	         }
	      }
	   }
	}
	
	
	
package lock.step5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionLockDemo {
   public static void main(String[] args) throws InterruptedException {
      ItemQueue itemQueue = new ItemQueue(10);

      //Create a producer and a consumer.
      Thread producer = new Producer(itemQueue);
      Thread consumer = new Consumer(itemQueue);

      //Start both threads.
      producer.start();
      consumer.start();

      //Wait for both threads to terminate.
      producer.join();
      consumer.join();
   }
   static class ItemQueue {
      private Object[] items = null;
      private int current = 0;
      private int placeIndex = 0;
      private int removeIndex = 0;

      private final Lock lock;
      private final Condition isEmpty;
      private final Condition isFull;

      public ItemQueue(int capacity) {
         this.items = new Object[capacity];
         lock = new ReentrantLock();
         isEmpty = lock.newCondition();
         isFull = lock.newCondition();
      }
      public void add(Object item) throws InterruptedException {
         lock.lock();

         while(current >= items.length)
            isFull.await();

         items[placeIndex] = item;
         placeIndex = (placeIndex + 1) % items.length;
         ++current;

         //Notify the consumer that there is data available.
         isEmpty.signal();
         lock.unlock();
      }

      public Object remove() throws InterruptedException {
         Object item = null;

         lock.lock();

         while(current <= 0) {
            isEmpty.await();
         }
         item = items[removeIndex];
         removeIndex = (removeIndex + 1) % items.length;
         --current;

         //Notify the producer that there is space available.
         isFull.signal();
         lock.unlock();

         return item;
      }
      public boolean isEmpty() {
         return (items.length == 0);
      }
   }
   static class Producer extends Thread {
      private final ItemQueue queue;
      
      public Producer(ItemQueue queue) {
         this.queue = queue;
      }
      @Override
      public void run() {
         String[] numbers =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
         
         try {
            for(String number: numbers) {
               System.out.println("[Producer]: " + number);
            }
            queue.add(null);
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         } 
      }
   }
   static class Consumer extends Thread {
      private final ItemQueue queue;
      
      public Consumer(ItemQueue queue) {
         this.queue = queue;
      }
      @Override
      public void run() {
         try {
            do {
               Object number = queue.remove();
               System.out.println("[Consumer]: " + number);

               if(number == null) {
                  return;
               }
            } while(!queue.isEmpty());
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         }
      }
   }
}


package forkjoin.step1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestThread {
   public static void main(final String[] arguments) throws InterruptedException, 
      ExecutionException {
      
      int nThreads = Runtime.getRuntime().availableProcessors();
      System.out.println(nThreads);
      int[] numbers = new int[1000]; 

      for(int i = 0; i < numbers.length; i++) {
         numbers[i] = i;
      }
      
      ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
      Long result = forkJoinPool.invoke(new Sum(numbers,0,numbers.length));
      System.out.println(result);
   }  
   static class Sum extends RecursiveTask<Long> {
      int low;
      int high;
      int[] array;

      Sum(int[] array, int low, int high) {
         this.array = array;
         this.low   = low;
         this.high  = high;
      }
      protected Long compute() {
         if(high - low <= 10) {
            long sum = 0;
            
            for(int i = low; i < high; ++i) sum += array[i];
            return sum;
         } else {	    	
            int mid = low + (high - low) / 2;
            Sum left  = new Sum(array, low, mid);
            Sum right = new Sum(array, mid, high);
            left.fork();
            long rightResult = right.compute();
            long leftResult  = left.join();
            return leftResult + rightResult;
         }
      }
   }
}


package atom.solution.step2;

import java.util.concurrent.atomic.AtomicInteger;

class ProcessingThread03 implements Runnable {
	  private AtomicInteger count = new AtomicInteger();
	@Override
	public  void run() {

		   count.incrementAndGet();

		System.out.println("Name : " + Thread.currentThread().getName()
				+ "value : " + count);

	}

}
