class wali extends Thread{
  public void run(){
     System.out.println("The thread is running");
  }
  public static void main(String args[]){
     wali t1 = new wali();
     t1.start(); 
  }
}