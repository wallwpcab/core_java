public class Test { 
	public static void main(String[] args) throws InterruptedException { 
		Test t = new Test(); 
		    t = null; 
		    System.gc(); 
		    Thread.sleep(1000); 
		        System.out.println("end main"); 
	} 
	@Override
	protected void finalize() { 
		System.out.println("finalize method called"); 
		System.out.println(10/0); 
	} 
} 