public class MultipleCatchBlock2 {
	public static void main(String[] args) {
           try{  
	       int a[]=new int[5];   // Risky code 
	       System.out.println(a[10]);}  
	         catch(ArithmeticException e){
		    System.out.println("Arithmetic Exception occurs");}
			catch(ArrayIndexOutOfBoundsException e){System.out.println("ArrayIndexOutOfBounds Exception occurs");} // Default Exception Handler
                             catch(Exception e){System.out.println("Parent Exception occurs");}	  // Default Exception Handler  
 			          System.out.println("rest of the code"); 
			  		  
			    
	}
}
