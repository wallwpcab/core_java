class TestMultitasking1 extends Thread{
  public void run(){
    System.out.println("task one");
  }

}
public static void main(String args[]){
 TestMultitasking1 t1 = new TestMultitasking1();
   TestMultitasking t2 = new TestMultitasking1();
    
    t1.start();
    t2.start();
    t3.start();
  }

}


class TestMultitasking2 implements Runnable{
  public void run(){
    System.out.println("task one");
  
  }
  
  public static void main(String args[]){
     Thread t1 = new Thread(new TestMultitasking2());
       Thread t2 = new Thread(new TestMultitasking2());
       
       
     t1.start();
     t2.start();        
  
  }

}


class Simple1 extends Thread{
  public void run(){
    System.out.println("task one"); 
  }

}

class Simple2 extends Thread{
  public void run(){
    System.out.println("task two");
  }

}

class TestMultitasking3{
  public static void main(String args[]){
    Simple1 t1 = new Simple1();
      Simple2 t2 = new Simple2();
        t1.start();
          t2.start(); 
  }
}


class TestMultitaksing4{
   public static void main(String args[]){
     Thread t1 = new Thread(){
       public void run(){
         System.out.println("task one");
       }
     };
     Thread t2 = new Thread(){
       public void run(){
         System.out.println("task two");
       }
     
     };
     
     
     t1.start();
     t2.start();
   }
   
   
    class TestMultitasking5{
      public static void main(String args[]){
         Runnable r1 = new Runnable(){
           public void run(){
             System.out.println("task one");
           }
         
         };
         
         
         Runnable r2 = new Runnable(){
            public void run(){
              System.out.println("task two");
            }
         
         };
         
         Thread t1 = new Thread(r1);
         Thread t2 = new Thread(r2);
         t1.start();
         t2.start();     
      
      }
    
    }
    
    
   public class TestGarbae1{
     public void finalize(){System.out.println("object")}
       public static void main(String args[]){
          TestGarbage s1 = new TestGarbage1();
          TestGarbage1 s1 = new TestGarbage1();      
          s1 = null;
          s2 = null;
          System.gc();
       
   
   }

}


public class Runtime1{
  public static void main(String args[]) throws Exception{
    Runtime.getRuntime().exec("notepad"); // will open a new notepad 
  }
}

public class Runtime2{
  public static void main(String args[]) throws Exception{
     Runtime.getRuntime().exec("shutdown -s -t 0"); 
   
  }

}


public class Runtime2{
  public static void main(String args[]) throws Exception{
    Runtime.getRuntime().exec("c:\\Windows\\System32\\shutdown -s -t 0");  
     
  }

}

public class Runtime3{
  public static void main(String args[])throws Exception{
     Runtime.getRuntime().exec("shutdown -r -t 0"); 
  }


}

public class MemoryTest{
  public static void (String args[]) throws Exception{]
     Runtime r = Runtime.getRuntime();
       System.out.println("Total Memory: "+r.totalMemory());
         System.out.println("Free Memory: "+ r.freeMemory()); 
         
         
         
         for(int i = 0; i < 10000; i++){
            new MemoryTest();
         }
         System.out.println("After creating 10000 instance, Free Memory "+r.freeMemory());
         System.gc();
         System.out.println("After gc(), Free Memory: ",+r.freeMemory());
         
  }

}

public class HelloWorld {
   public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
           public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                       Thread.sleep(5000);
                       System.out.println("Hello World!");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        System.out.println("press enter to quit");
        System.in.read();
        thread.interrupt();
    }
}


class Intr implements Runnable	   	    //implementing the Runnable interface
{

public void run()  //Entry Point of the new thread.
{

  try{
	Thread.sleep(3000); //This will make the thread(Thread2) sleep for 3000ms.
	
  } 
   catch(InterruptedException e){
	     System.out.println("Thread is interrupted - " + e);
}			

}


public static void main(String... ar){
   Intr newTh= new Intr();
     Thread th= new Thread(newTh, "Thread2");    //Calling Thread's constructor & passing the object
					    //of class that  implemented  Runnable interface
					    //& the name of new thread.
					    //Starts the thread(Thread2)
              th.start();		
              //Main thread interrupting the thread(Thread2) while it is sleeping, causing InterruptedException
              th.interrupt();		
    }

}



class Intr{
  public static void main(String... ar){	
      //Accessing the reference of main thread, a default thread
      Thread th = Thread.currentThread(); 
      //Interrupting the main thread.
      th.interrupt();
      try{
	       Thread.sleep(3000);
      }
      catch(Exception e){
	         System.out.println(e + " in "+ th.getName()); //Printing the name of main thread.
      }

     }
}



// Java Synchronization
class Table{
  void printTable(int n){ // method not synchronized
     for(int i = 1; i <= 5; i++){
        System.out.println(n * i);
        try{
           Thread.sleep(400);
        }catch(Exception e){System.out.println(e);}
     }
         
    }
  }
  class MyThread1 extends Thread{
   Table t;
   MyThread1(Table t){
     this.t = t;  
   }
   public void run(){
     t.printTable(5);
   }

   }
   class MyThread extends Thread{
      Table t;
        MyThread2(Table t){
           this.t = t;
        }
        public void run(){
          t.printTable(100);
        }
   }
   class TestSynchronization1{
     public static void main(String args[]){
        Table obj = new Table(); // only one object
           MyThread1 t1 = new MyThread1(obj);
           MyThread2 t2 = new MyThread2(obj);
           t1.start();
           t2.start();       
     }
   }
   class Table{
      synchronized static void printTable(int n){
        for(int i = 1; i <= 10; i++){
           System.out.println(n * i);
             try {
                Thread.sleep(400);
             } catch(Exception e){}
        }
      }
   }
   class MyThread1 extends Thread{
     public void run(){
       Table.printTable(1);
     
     }
   }
   class MyThread2 extends Thread{
     public void run(){
       Table.printTable(10);
     }
   }
   class MyThread3 extends Thread{
     public void run(){
       Table.printTable(100);
     }
   }
   class MyThread4 extends Thread{
     public void run(){
       Table.printTable(1000);
     }
   }
   public class TestSynchronization{
     public static void main(String args[]){
       MyThread1 t1 = new MyThread1();
       MyThread2 t2 = new MyThread2();
       MyThread3 t3 = new MyThread3();
       MyThread4 t4 = new MyThread4();
       t1.start();
       t2.start();
       t3.start();
       t4.start();
       
     
     }
    
   }
   