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