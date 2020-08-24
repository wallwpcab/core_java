class MyRunnable implements Runnable{
  public void run(){
     for(int i = 0; i < 10; i++){
        System.out.println("Child Thread")';
     }
  }
}

class ThreadDemo{
  public static void main(){
    MyRunnable r = new MyRunnable();
    Thread t = new Thread(r);
    t.start();
    for(int i = 0; i < 10; i++){
       System.out.println("Main Thread");
    }
  }
  
}

class MyThread extends Thread{
  
}
class ThreadDemo{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getname());
          MyThread t = new MyThread();
            System.out.println();
              Thread.currentThread().setName("Nayeem");
               System.out.println(Thread.currentThread().getname());
    }
}


class MyThread extends Thread{
  public void run(){
    System.out.println("This method executed by Thread"+ Thread.currentThread().getname());
  }

}
class ThreadDemo{
   public static void main(){
       MyThread t = new MyThread();
         t.start();
         System.out.println("This method executed by Thread"+ Thread.currentThread().getname() );
   }
}


class MyThread extends Thread{

}
class ThreadDemo{
      public static void main(String[] args){
          System.out.println(Thread.currentThread);
           Thread.currentThread().setPriority(15);
            Thread.currentThread().setPriority(7);
            MyThread t = new MyThread();
            System.out.println(t.getPriority());
      }
}


class MyThread extends Thread{
   public void run(){
          for(int i = 0; i < 10; i++){
           //Mythread t = new Mythread();
           //t.yield();
           System.out.println("child Thread");
          Thread.yield();
          }
          
   }
}
class ThreadDemo{
   public static void main(String[] args){
         MyThread t = new MyThread();
         t.start();
         System.out.println("Main Thread");
   }

}


class MyThread extends Thread{
   public void run(){
          for(int i = 0; i < 10; i++){
           //Mythread t = new Mythread();
           //t.yield();
           System.out.println("child Thread");
          //Thread.yield();
          try{
              Thread.sleep(1000);
             }
             catch(InterruptedException e){
             }
          }
          
   }
}
class ThreadDemo{
   public static void main(String[] args) throws InterruptedException{
         MyThread t = new MyThread();
         t.start();
         t.join();
         for(int i = 0; i < 10; i++){
            System.out.println("Main Thread");
          }
         
   }

}


class MyThread extends Thread{
   static Thread mt;
   public void run(){
           try{
              mt.join();
            }
            catch(InterruptedException e){
             for(int i = 0; i < 10; i++){
                 System.out.println("Child Thread");
            }
           }
          
   }
}
class ThreadDemo{
   public static void main(String[] args) throws InterruptedException{
         MyThread mt = Thread.currentThread();
         MyThread t = new MyThread();
         t.start();
         t.join();
         for(int i = 0; i < 10; i++){
            System.out.println("Main Thread");
            Thread.sleep(2000)
          }
         
   }

}