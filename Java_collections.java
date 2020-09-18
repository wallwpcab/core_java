class HashMap{
		class Entry{
		    Entry<k,v>[] table; [15]=16
		 for (Entry<K,V> e = table[i]; e != null; e = e.next) {
		       Object k;
		       if (e.hash == hash && ((k = e.key) == key || key.equals(k))) { 
			//already the node with same key present
			update operation 			
	                }else { //add operation   }
		   }
		}
     }





public boolean equals(Object o){
  try{
	if (obj == null)
   		return false;
 	 if (getClass() != obj.getClass())
   		return false;

       Student s2=(Student)o;
       if(name.equals(s2.name) && rollNo==s2.rollNo)
           return true;
       else
           return false;
        catch(ClassCastException e)
         {
          return false;    }
        catch(ClassCastException e)
         {
          return false;    } }  }



{
if(i>=-128 && i< = IntegerCache.High)
	returnIntegerCache.Cache[i+128]
}else{
return new Integer(i);
}
`

class HashSet{
	HashMap map;
	private static Object PRESENT = new Object();
	HashSet(){
		map = new HashMap();
	}
	public void add(E, e){
		return map.put(e, PRESENT) == null;
	}
}

int hash(int num){
	int i = sum(digit of num) % 10;
	return i;
}




public class ArrayListDemo{
	public static void main(String[] args){
		ArrayLIst al = new ArrayList();
		al.add("Emrul");
		al.add("Rony");
		al.add(123);
		al.add(null);
		
		for(Object obj : al){
			System.out.println(obj);
		}
		
	}
}
// Output:
// Emrul
// Rony
// 123
// null


public class LinkedListDemo{
    public static void main(String[] args) {
        LinkedList al = new LinkedList();
        al.add("Emrul");
        al.add("Rony");

        al.add(123);
        al.add(null);
        al.addFirst("AddedFirst");
        al.addLast("AddedLast");
        al.set(3,22222);
        
        for (Object obj : al){
            System.out.println(obj);
        }
    }
}
// Output:
// AddedFirst
// Emrul
// Rony
// 22222
// null
// AddedLast


public class LinkedListDemo{
	public static void main(String[] args){
		LinkedList al = new LinkedList();
		al.add("wali");
		al.add("ullah");
		al.add(123);
		al.add("null");
		al.add("Adderfirst");
		al.add("Adderlast");
		al.set(3, 22222);
		
		for(Object obj: al){
			System.out.println(obj);
		}
		
	}
}




public class VectorDemo{
	public static void main(String[] args){
		Vector vector = new vector();
		System.out.println(vector.capacity());
		for(int i = 0; i <= n; i++){
			//System.out.println();
			vector.add(i);
		}
		System.out.println(vector.capacity());
		vector.add(a);
		System.out.println(vector.capacity());
		System.out.println(vector);
	}
}








public class VectorDemo {
    public static void main(String[] args) {
        Vector vector = new Vector();
        System.out.println(vector.capacity());
        for (int i=1; i<=10; i++){
            vector.add(i);
        }
        System.out.println(vector.capacity());
        vector.add("A");
        System.out.println(vector.capacity());
        System.out.println(vector);
    }
}
// Output:
// 10
public class StackDemo {
    public static void main(String[] args) {
        Object arr[] = { "Emrul", "Hasan", "Khan", 1, "X", 3 };
        Stack stack = new Stack();
        for (Object obj : arr) {
            stack.push(obj);
        }
        int size =stack.size();
        for (int i=0; i<size; i++){
            System.out.println(stack.pop());
        }
    }
}
// Output:
// 3
// X
// 1
// Khan
// Hasan
// Emrul

public class StackDemo{
	public static main void(String[] args){
		Object  ar[] = {};
		Stack stack = new Stack();
		for(Object obj: ar){
			Stack.push(obj);
			
		}
		int size = stack.size();
		for(int i = 0; i <= n; i++){
			System.out.println(stack.pop());
		}
	}
}

import java.util.*;  
class TreeMap1{  
 public static void main(String args[]){  
   TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
      map.put(100,"Amit");    
      map.put(102,"Ravi");    
      map.put(101,"Vijay");    
      map.put(103,"Rahul");    
        
      for(Map.Entry m:map.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }    
 }  
}  

import java.util.*;  
class Hashtable1{  
 public static void main(String args[]){  
  Hashtable<Integer,String> hm=new Hashtable<Integer,String>();  
  hm.put(100,"Amit");  
  hm.put(102,"Ravi");  
  hm.put(101,"Vijay");  
  hm.put(103,"Rahul");  
  
  for(Map.Entry m:hm.entrySet()){  
   System.out.println(m.getKey()+" "+m.getValue());  
  }  
 }  
}  




import java.util.*;  
class Book {  
    int id;  
    String name,author,publisher;  int quantity;  
    public Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  this.name = name;  this.author = author;  this.publisher = publisher;  this.quantity = quantity;  
    }  
}  
public class LinkedListExample {  
public static void main(String[] args) {    
    List<Book> list=new LinkedList<Book>(); //Creating list of Books  
    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);   //Creating Books 
    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);   
    list.add(b1);   //Adding Books to list 
    list.add(b2);  
    list.add(b3);   
    for(Book b:list){   //Traversing list 
    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
    }  
}  
}  