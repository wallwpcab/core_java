class Test{
  public static void main(String[] arts){
     doStuff();
     System.out.println(10/0);
  }
  public static void doStuff(){
     doMoreStuff();
     System.out.println("Hi");
  }
  public static void doMoreStuff(){
     System.out.println("hello");
  }
}