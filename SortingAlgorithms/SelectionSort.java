/**
 * In-Place algorithm. 
 * Works well for small files.
 * O(n2)
 * 
 * LOGIC : 
 * 1. Start outer loop.
 *  1.1: The first element in the array is considered as the min value.
 * 2. Start inner loop.
 *  2.1: We start with 2nd element in the array called and compare if a[j]< min. 
 *  2.2: If yes, we set a[j] as the new min and SWAP a[j] with the previous original min i.e. a[i].
 * 
 */ 
public class SelectionSort{
    public static void main(String args[]){
        int a[] = {5,2,7,4,1,0,8,6,9};
        SelectionSort selobj = new SelectionSort();
        System.out.println("\n=============UnSorted array=============");
        selobj.printarray(a);
        selobj.sortarray(a);
        System.out.println("\n=============Sorted array=============");
        selobj.printarray(a);
    }
    
    /* After the end of every INNER LOOP, we fix the position of the miniumum element in the array.*/
    public void sortarray(int[] a){
        int i,j,min,temp;
        for(i=0;i<a.length-1;i++){
            min = a[i];
            for(j=i+1;j<a.length-1;j++){
                if(a[j]<min){
                    min = a[j];
                    //swap a[i] with a[j]
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                } 
            }
            printarray(a);
        }
    }
    
    public void printarray(int a[]){
         for (int data:a) System.out.print(data+" ");
         System.out.println();
    }
}