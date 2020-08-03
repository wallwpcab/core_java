
package TypeCastingStep15;
   public class Test0 {
   public static void main(String[]args){
   int i=12345;
   long l=i;
   System.out.println("the output for wedening casting: "+l);
   int i1=21474;
   short s=(short)i1;
   System.out.println("the output for narrowing casting: "+s);
   int i2=2147483647;
   short s1=(short)i2;
   System.out.println("the output for overflow casting: "+s1);
   Object o=new String("wornoz");
   String sb=(String)o;
   System.out.println("the output for object casting: "+sb);
   
   
   
   
}
}



package StaticControlFlowStep12;
    public class Base1 {
    static int x=10;
    static{
        m1();
        System.out.println("Base1 SB");
    }
    public static void main(String[]args){
        m1();
        System.out.println("Base1 main");
    }
    public static void m1(){
        System.out.println(y);
    }
    static int y=20;
    
}

class Derived extends Base1{
    static int i=100;
    static{
        m2();
        System.out.println("DFSB"); }
    public static void main(String[]args){
        m2();
        System.out.println("Derived main");
    }
    public static void m2(){
        System.out.println(j);
    }
    static{
        System.out.println("DSSB");
    }
    static int j=200;
}




package StaticControlFlowStep12;
    class Base{
          static int x=10;
            static{
               m1();
               System.out.println("First Static Block");}
	public static void main(String[]args){
        m1();
        System.out.println("main method");}
    public static void m1(){
        System.out.println(y);
    }
    static{
    System.out.println("Second Static Block");}
    static int y=20;
}
	 

package InstanceControlFlowStep13;
public class Parent1 {
    int x=10;
    {
        m1();
        System.out.println("Parent");
    }
    Parent1(){
        System.out.println("Parent Constructor");   
    }
public static void main(String[]args){
    Parent1 p=new Parent1();
    System.out.println("Parent Main");
}
    public void m1(){
        System.out.println(y);
    }
    int y=20;
}

class Child extends Parent1{
    int i=100;{
        m2();
        System.out.println("CIIB");}
    Child(){
        System.out.println("Child constructor");
    }
    public static void main(String[]args){
    Child c=new Child();
    System.out.println("Child Main");}
    public void m2(){
        System.out.println(j);
    }
    {
     System.out.println("CSIIB");   
    }
    int j=200;
}


package InstanceControlFlowStep13;
public class Parent {
    int x=10;{
        m1();
        System.out.println("First Instance Block");
    }
    Parent(){
        System.out.println("constructor");
    }
	
public static void main(String[]args){
    Parent p=new Parent();
    System.out.println("main method");
}
    public void m1(){
        System.out.println(y);
    }
    {
        System.out.println("Second Instance Block");
    }
    int y=20;
    
}



package CuplingStep16;
    public class A {
    static int i=B.j; }
    class B{
        static int j=C.m1();
    }
    class C{
    public static int  m1(){
        return D.k;
    }
}
    class D{
    static int k=10;
}

package ConstructorStep14;
    public class Test1 {
    private static Test1 t;
    private Test1(){
    
    }
    public static Test1 getInstance(){
        if(t==null){
            t=new Test1();
        }
        return t;
    }
    public Object clone(){
        return this;
    }
    public static void main(String[]args){
    Test1 t1=Test1.getInstance();
    Test1 t2=Test1.getInstance();
    Test1 t100=Test1.getInstance();
   // Test1 t101=Test1.clone();

   }
}




package ConstructorStep14;
    public class Student {
    int rollno;
    String name;
    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
    public static void main(String[]args){
    Student st1=new Student(12230326,"wornoz qurishe");
    Student st2=new Student(12230335,"tarikur rahman");
    System.out.println(st1.rollno+" "+st1.name);
    System.out.println(st2.rollno+" "+st2.name);
    
    }
    
    
}
