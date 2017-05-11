/**
 * LOGIC : At the end of the each pass, we fix the position of the largest element.
 * In-Place algorithm.
 */ 
public class BubbleSort{
    int temp;
    public static void main(String args[]){
        int a[] = {16,5,2,7,4,1,0,8,9};
        BubbleSort  bubbleobj = new BubbleSort();
        bubbleobj.sortarray(a);
        System.out.println("\n=============Sorted array=============");
        bubbleobj.printarray(a);
    }
    
    public void sortarray(int[] a){
        int n= a.length ;
        
        //outer loop for passes
        for(int pass=1; pass<=n; pass++){
            //inner loop to compare elements
            for(int i =0; i<n-pass; i++){
                if(a[i] > a[i+1]){
                    //swap the two numbers
                    swap(a,i,i+1);
                }
            }
            System.out.println("\n Printing pass# "+pass);
                 printarray(a);
        }
    }
    
    public void swap(int a[],int m,int n){
        temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
    
    public void printarray(int a[]){
        for (int data:a) System.out.print(data+" ");
         System.out.println();
    }
}