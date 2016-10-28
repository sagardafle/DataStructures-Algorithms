/**
 * Complexity:O(log2(N))
 */ 
public class BinarySearch{
    int a[] = new int[] {6,5,2,3,1,8,9,4,0,7,4};
    public static void main(String args[]){
        BinarySearch binobj = new BinarySearch();
        int indexvalue = binobj.findElement(8);
        System.out.println("Value found at index "+indexvalue);
    }
    public int findElement(int value){
        int high = a.length-1, low = 0;
        while(high>=low){
            int mid = (low+high)/2;
            if(a[mid] == value) return mid;
            if(a[mid] > value) high = mid-1;
            if(a[mid] < value) low = mid+1;
        }
        return -1;
    }
}