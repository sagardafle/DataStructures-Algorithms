

 public class MyClass implements IMyClass {
           public void methodA(){
                     System.out.println("Inside methodA");
           }
           
           public String methodB(){
                    return "Inside methodB";
           }
           
           public Integer methodC(){
                     return test*2;
           }
 
 
 public static void main(String[] args){
           MyClass obj = new MyClass();
           obj.methodA();
           obj.methodB();
           System.out.println(obj.methodC());
 }
 }