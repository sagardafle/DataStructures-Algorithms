/**
 * Complexity:O(log2(N))
 */ 
 import java.util.Arrays;
public class BinarySearch{
    static int a[] = new int[] {1,2,3,4,5,6,7,8,9};
    public static void main(String args[]){
        BinarySearch binobj = new BinarySearch();
        
        int indexvalue = binobj.findElement(7);
        System.out.println("Value found at index "+indexvalue);
    }
    public int findElement(int value){
        int high = a.length-1, low = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid] == value) return mid; 
            if(a[mid] > value) high = mid-1;
            if(a[mid] < value) low = mid+1;
        }
        return -1;
    }
}