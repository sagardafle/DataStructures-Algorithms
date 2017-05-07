public class ClassAB implements InterfaceA,InterfaceB{
          
          @Override
          public void test (){
                    System.out.println("Test");
          }
          
          @Override
          public boolean test (){   //error: method test() is already defined in class ClassAB
                    return 1==1;
          }
          
          public static void main(String[] args){
                  ClassAB obj = new ClassAB();
                  obj.test();
                  
          }
}