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

	}public void run() {
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
			} catch (InterruptedException e) {}
			lk.unlock();
			}else {
			System.out.println(Thread.currentThread().getName()+"... unable to get lock and perform alternative operation");
		}}}





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
	         }lock.readLock().lock();
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
