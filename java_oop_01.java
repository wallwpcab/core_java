package AbstractionStep2;
    abstract  class Account {//abstract class
	    void showName(){
        System.out.println("wornoz qurishe");
    }
    abstract void showAccount();//abstract method
  }


package AbstractionStep2;
public class TestClass {
    public static void main(String[]args){
        Account ac;
        ac=new Wornoz();
        ac.showAccount();
        ac.showName();
        
        ac=new Wadil();
        ac.showName();
        ac.showAccount();
    }
    
	
	
}

package AbstractionStep2;


class Wornoz extends Account {//if i use abstract sothat can not be override

    @Override
    void showAccount() {
        System.out.println("account number is 1234567wer");
        
    }
    
}



package EncapsulationStep3;


public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Test{
    public static void main(String[]args){
        Student st=new Student();
        st.setId(101);
        st.setName("wornoz qurishe");
        System.out.println(st.getId()+" "+st.getName());
    }
}

package HASARelationStep6;


public class Result {
    double marks;
    String grade;
    Student student;

    public Result(double marks , String grade,Student student) {
        this.marks = marks;
        this.grade = grade;
        this.student = student;//rule follow aggregation
    }
    void display(){
        System.out.println(student.id+" "+student.name+" "+marks+" "+grade);
    }
    public static void main(String[]args){
        Student st1=new Student(101,"wornoz");
        Result rs1=new Result(85,"A+",st1);
        rs1.display();
    }
    
}
package HASARelationStep6;


public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


package ISARelationStep5;


public class Student {
    int id;
    String name;
    void display1(){
        System.out.println("student id:" +id);
        System.out.println("student name:" +name);
    }
}
class Result extends Student{
    double marks;
    String grade;
        void display2(){
        System.out.println("student id:" +id);
        System.out.println("student name:" +name);
        System.out.println("student marks:" +marks);
        System.out.println("student grade:" +grade);
    }
}
class Test{
    public static void main(String[]args){
    
    //*++++++child class object get parent and child+++++++++++++++++++++++++++++++++++
        Result rs=new Result();
        rs.id=101;
        rs.name="wornoz";
        rs.marks=85;
        rs.grade="A+";
        System.out.println("only student class output" );
        rs.display1();
        System.out.println("result class extends student class and output");
        rs.display2();
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    /*
    //---------parent class object get parent -----------------------------
        Student st=new Student();
        st.id=101;
        st.name="wornoz";
        //st.marks=85;
        //st.grade="A+";
        System.out.println("only student class output" );
        st.display1();
        //System.out.println("result class extends student class and output");
        // st.display2();
    //----------------------------------------------------------------------------
    */
    /*
    //***************parent class object can carry child class object but show output parent***
    Student st=new Result();
    st.id=101;
    st.name="wornoz";
    st.display1();
    //******************************************************************************
    */
    
    }
}

package MethodHidingStep10;


public class Student {
    public static void m1(){
        System.out.println("hellow");
    }
    
}
class Result extends Student{
   public static void m1(){
        System.out.println("hellow wornoz");
    }
}
class Test{
    public static void main(String[]args){
       Result r=new Result();
       r.m1();
       Student s=new Student();
       s.m1();
       Student p=new Result();
       p.m1();
    }
}package ISARelationStep5;


public class Student {
    int id;
    String name;
    void display1(){
        System.out.println("student id:" +id);
        System.out.println("student name:" +name);
    }
}
class Result extends Student{
    double marks;
    String grade;
        void display2(){
        System.out.println("student id:" +id);
        System.out.println("student name:" +name);
        System.out.println("student marks:" +marks);
        System.out.println("student grade:" +grade);
    }
}
class Test{
    public static void main(String[]args){
    
    //*++++++child class object get parent and child+++++++++++++++++++++++++++++++++++
        Result rs=new Result();
        rs.id=101;
        rs.name="wornoz";
        rs.marks=85;
        rs.grade="A+";
        System.out.println("only student class output" );
        rs.display1();
        System.out.println("result class extends student class and output");
        rs.display2();
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    /*
    //---------parent class object get parent -----------------------------
        Student st=new Student();
        st.id=101;
        st.name="wornoz";
        //st.marks=85;
        //st.grade="A+";
        System.out.println("only student class output" );
        st.display1();
        //System.out.println("result class extends student class and output");
        // st.display2();
    //----------------------------------------------------------------------------
    */
    /*
    //***************parent class object can carry child class object but show output parent***
    Student st=new Result();
    st.id=101;
    st.name="wornoz";
    st.display1();
    //******************************************************************************
    */
    
    }
}


package HASARelationStep6;


public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

package HASARelationStep6;


public class Result {
    double marks;
    String grade;
    Student student;

    public Result(double marks , String grade,Student student) {
        this.marks = marks;
        this.grade = grade;
        this.student = student;//rule follow aggregation
    }
    void display(){
        System.out.println(student.id+" "+student.name+" "+marks+" "+grade);
    }
    public static void main(String[]args){
        Student st1=new Student(101,"wornoz");
        Result rs1=new Result(85,"A+",st1);
        rs1.display();
    }
    
}

package EncapsulationStep3;
    public class Student {
    private int id;
    private String name;
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Test{
    public static void main(String[]args){
        Student st=new Student();
        st.setId(101);
        st.setName("wornoz qurishe");
        System.out.println(st.getId()+" "+st.getName());
    }
}
