class wali2 extends runnable{
   public void run(){
         System.out.println("The runnable thread is running ");
    
	}public static void main(String args[]){
     wali2 c1 = new wali2();
     Thread c2 = new Thread(c1);
     c2.start();
   }

}