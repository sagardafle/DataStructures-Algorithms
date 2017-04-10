import java.util.*;
public class SubSets {
   private static void findSubsets(int array[]) {
  int numOfSubsets = 1 << array.length; 
  System.out.println("num of sets "+numOfSubsets);
  for(int i = 0; i < numOfSubsets; i++){
    int pos = array.length - 1;
   int bitmask = i;

   System.out.print("{");
   while(bitmask > 0){
    if((bitmask & 1) == 1)
            System.out.print(array[pos]+",");
            bitmask >>= 1;
            pos--;
        }
        System.out.print("}");
    }
}

    public static void main(String[] args) {
        SubSets obj = new SubSets();
        int[] a = {1,2,3};
        obj.findSubsets(a);
    }
}


