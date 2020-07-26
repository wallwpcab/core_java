public class Test { 
	public static void main(String[] args) throws InterruptedException { 
		String str = new String("GeeksForGeeks"); 
		    str = null; 
		        System.gc(); 			
		        Thread.sleep(1000); 	
		        System.out.println("end of main"); 
	} 
	@Override
	protected void finalize(){ 
		System.out.println("finalize method called"); 
	} 
} 


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


public class Test { 
	static Test t ; 
	static int count =0; 
    public static void main(String[] args) throws InterruptedException{ 
		        Test t1 = new Test(); 
			        t1 = null; // line 12 
		            System.gc(); // line 15 
			        Thread.sleep(1000); 
		            t = null; // line 21 
			        System.gc(); // line 24 
	                Thread.sleep(1000); 
			        System.out.println("finalize method called "+count+" times"); 
		
	    } 
	
	@Override
	protected void finalize(){ 
		count++; 
		    t = this; // line 38 
	    } 
	} 


public class Test{ 
	public static void main(String[] args) { 
		m1(); // Line 5 
	} 
	static void m1(){ 
		Test t1 = new Test(); 
		Test t2 = new Test(); 
	} 
} 

public class Test { 
	public static void main(String [] args){ 
		Test t1 = new Test(); 
		    Test t2 = m1(t1); // line 6 
		        Test t3 = new Test(); 
		            t2 = t3; // line 8 
		
	} 
	static Test m1(Test temp){ 
		temp = new Test(); 
		    return temp; 
	} 
} 
