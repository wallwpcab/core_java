import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InvalidColumnindexExample {
  public static void main(String... args) throws ClassException, InterruptedException{
    Connection con = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    Class.forName("");
    con = DriverManager.getConnection(
    
    
    )
    System.out.println("Connection established");
    prepStmt.setInt(2, 7);
    rs = prepStmt.executeQuery();
    while(rs.next()){
       System.out.println(rs.getInt("ID") + "");
       System.out.println(rs.getString("NAME"))
    }
  
  }

}




// IOException 
class MyRunnable implements Runnable{
   public void run(){
      System.out.println("in run() method"');
      for(int i = 0; i < 2; i++){
         System.out.println("i=" + i + "" 
           Thread.currentThread());
       }
   }
}
public class InterruptedExceptionJoinExample{
  public static void main(Strubg... args){
     System.out.println("In main() method");
     MyRunnable runnable = new MyRunnable();
     Thread thread1 = new Thread(runnable);
     Thread thread2 = new Thread(runnable);
     Thread thread3 = new Thread(runnable);
     
     thread1.start();
     try{
        thread1.join();
     } catch(InterruptedException e){
        e.printStackTrace();
     }
     thread2.start();
     try{
        thread2.join();
     }
     catch(InterruptedException e){
        e.printStackTrace();
     }
     System.out.println("End main() method");
     
   }
 
 }
 
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Employee implements Serializable{
   private static final long serialVersionUID = 1L;
   private Integer id;
   private String name;
   
   public Employee(Integer id, String name) {
     this.id = id;
     this.name = name;
     @Override
     public String toString() {
       return "Employee " + id " ";
     }
    
   }

}

public class SeriealizeEmployee {
  public static void main(String[] args){
   Employee object1 = new Employee(1, "amy");
   Employee object2 = new Employee(2, "ankit");
   try{
      OutputStream fout = new FileOutputStream();
      ObjectOutput oout - new ObjectOutputStream();
      System.out.println("");
      oout.writeObjecet(object1);
      oout.writeObject(object2);
        oout.close();
        System.out.println("Object Serialization completed")l
        
   } catch(IOException ioe) {
       ioe.printStackTrace();
   }
  }

}


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class DeserializeEmployee{
   public static void main(String[] args) {
     InputStream fin;
     try{
        fin = new FileInputStream("");
        ObjectInput oin = new ObjectInputStream(fin);
        System.out.println("DeSerialization process");
        Employee emp;
        while((emp = (Employee) oin.readObject() != null)){
           System.out.println(emp);
        }   
        oin.close();
        } catch(EOFException e) {
            System.out.println("File ended");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        System.out.println("Object DeSerializatoin");
            
   }
}


import  java.io.IOException;
import  java.io.RandomAccessFile;
public class RandomAccessFileTest{
  public static void main(String[] args){
     try{
        String fileName = "c:/myFile.txt";
        String data = "abcdef";
        RandomAccessFile = randomAccessFile;
        randomAccessFile = new RandomAccessFile();
        randomAccessFile.seek(5);
        randomAccessFile.writeUTF(data);
        System.out.println("Data written in ");
        randomAccessFile.close();
        randomAccessFile = new RandomAccessFile();
        randomAccessFile.seek(5);
        data = randomAccessFile.readUTF(5);
        System.out.println("Data read from");
        randomAccessFile.close();
     
     
     } catch(IOException e) {
        e.printStackTrace();
     }
  
  }

 }
 
 

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


class EofIndicatorClass implements Serializable{
  class Employee implements Serializable{
     private static final long serialVersionUID = 1L;
       private string name;
       public Employee(String name) {
         this.name = name;
       }
       @Override
       public String toString(){
         return "Employee [name" + name + "]";
       }
  }

 }  
 

public class SerializeEmployee {
  public static void main(String[] args) {
    Employee object1 = new Employee("");
    Employee object2 = new Employee("");
    
    try {
        OutputStream fout = new FileOutputStream("");
        ObjectOutput oout = new ObjectOutputStream(fout);
        System.out.println("Serialization starts" + "Serializing employee");
        oout.writeObject(object1);
        oout.writeObject(object2);
        oout.writeObject(new EofindicatorClass());
        oout.close();
        System.out.println("Object ");
        
    } catch(IOException ioe) {
       ioe.printStackTrace();
    }
  
  }

 }  
 
 
 
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class DeSerializeEmployee {
   public static void main(String[] args) {
      InputStream fin;
      try {
         fin = new FileInputStream();
         ObjectInput cin = new ObjectInputStream(fin);
         SYstem.out.println("");
         Object obj;
         while(!((obj = cin.readObject){
           System.out.println(obj);
         }
         cin.close();
      }  catch(EOFException e) {
          System.out.println("File ended");
      } catch(FileNotFoundException e) {
           e.printStackTrace();
      } catch(IOException e) {
           e.printStackTrace();
      } catch(ClassNotFoundException e) {
           e.printStackTrace();
      }
   }
 }
    
    
    // IllegalMonitorStateException

class MuRunnable implements Runnable {
  public void run() {
    System.out.println("MyRunnable, in run()");
    try {
       this.wait(1000);
    } catch(InterruptedException e) {
       e.printStackTrace();
    }
    System.out.println("Thread in runnable state after 1000 millisecs");
  }

} 


public class IllegalMonitorStateExceptionExample {
  public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable();
    Thread thread1 = new Thread(myRunnable);
    thread1.start();
  }
}

public class IllegalMonitorStateExceptionExampleUsingWait {
  public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable();
    Thread thread1 = new Thread(myRunnable, "Thread");
    thread1.start();
  }
}


class MyRunnable implements Runnable {
  public void run() {
    synchronized(this) {
      System.out.println("MyRunnalbe in run() method");
      try {
        this.wait(1000);
        System.out.println("");
      } catch(InterruptedException e) {
          e.printStackTrace();
      }
    }
  }
 }
 
public class AvoidillegalMonitorStateExceptionExample {
  public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable();
    Thread thread1 = new Thread(MyRunnable);
    thread1.start();
  }
}

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class IllegalMonitorStateExceptionExample{
  public static void main(String[] args) {
    final Lock lock = new ReentrantLock();
    new Thread(new Runnable()) {
      public void run() {
        SYstem.out.orintln("Thread - 1");
        // lock.lock();
        lock.unlock();
      }
    }, "Thread - 1" {
       
    }.start();
  }
} 


// 182   //////////////////////////

            