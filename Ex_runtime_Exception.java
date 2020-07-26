class Test{   
   public static void main(String[] args){
      throw new Test();
   }
}
class Test extends RuntimeException{
  public static void main(String[] args){
     throw new Test();
}