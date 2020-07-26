// Simple Example of Garbage collection in java

public class TestGarbage1{
  public void finalize(){
    System.out.println("");}
      public static void main(String args[]){
         TestGarbage1 s1 = new TestGarbage1();
            TestGarbage s2 = new TestGarbage1();
               s1 = null;
                 s2 = null;
                   System.gc();
                
      }
  }
