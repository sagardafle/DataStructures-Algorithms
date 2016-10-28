/**
 * Linear Search worst case complexity is O(n) 
 * Find at nth place or not at all - n comparisons
 */ 

public class LinearSearch{
    static String indexvalues = "";
     int a[] = {6,5,2,3,1,8,9,4,0,7,4};
    public static void main(String args[]){
        LinearSearch linsearch = new LinearSearch();
        linsearch.findElement(4);
        System.out.println("Value found at "+indexvalues+ " indexes.");
    }
    public void findElement(int value){
        for(int i=0;i<a.length;i++){
            if(a[i]==value) indexvalues += i + ", ";
        }
    }
}