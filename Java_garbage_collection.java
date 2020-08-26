public class Runtime1{
   public static void main(String args[]) throws Exception{
      Runtime.getRuntime.exec("notepad");   
   }
}


public class Runtime2{
   public static void main(String args[])throws Exception{
      Runtime.getRuntime().exec("shutdown -s -t 0");
   }
}


public class Runtime2{
  public static void main(String args[])throws Exception{
     Runtime.getRuntime().exec("c:\\Windows\\System32\\shutdown -s -t 0"); 
  }
}


public class Runtime3{  
 public static void main(String args[])throws Exception{  
  Runtime.getRuntime().exec("shutdown -r -t 0");  
 }  
}  


public class Runtime4{  
 public static void main(String args[])throws Exception{  
  System.out.println(Runtime.getRuntime().availableProcessors());  
 }  
}  