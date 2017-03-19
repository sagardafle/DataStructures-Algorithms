/**
 * LOGIC : The first element in the array is considered sorted.
 * We start with 2nd element in the array called as key
 * Inside a while loop, We compare key with the values on the left (j pointer) and swap if key < a[j]
 */ 
public class InsertionSort{
      public static void main(String args[]){
        int a[] = {5,2,7,4,1,0,8,6,9};
        InsertionSort  insertionobj = new InsertionSort();
        System.out.println("\n=============UnSorted array=============");
         insertionobj.printarray(a);
        insertionobj.sortarray(a);
        System.out.println("\n=============Sorted array=============");
        insertionobj.printarray(a);
      }
    
    public void sortarray(int[] a){
        int i,j,key,temp;
        for(i=1;i<a.length;i++){ //i=1 as the very first element is already sorted.
            key = a[i];
            j = i-1;
            while(j >= 0 && a[j] > key){ // we will swap the values only if 
                                        //the elements of the current key is lesser than the elements on the left.
            
            //swap the key value with a[j]
           temp = a[j];
           a[j] = a[j+1];
           a[j+1] = temp;
                
                j--;
            }
        }
    }

     
     public void printarray(int a[]){
         for (int data:a) System.out.print(data+" ");
         System.out.println();
    }
}