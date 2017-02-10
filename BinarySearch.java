import java.util.Scanner;

public class BinarySearch{

    public int BinarySearch(int key,int array[],int min,int max){
    int i;
    if(min<=max){
   
    int midlength = (min+max)/2;   
    
    if(key>array[midlength]){
        min=midlength+1;
       
        
        return BinarySearch(key, array,min,max);
         
        }
    
    else if(key==array[midlength] ){
        return midlength;
        } 
        
    else{
         max=midlength-1;
         //System.out.println("less than mean:"+max);

        return BinarySearch( key,array,min,max);
         
        
        }
        
    }
    return -1;
}
    
    public static void main(String args[]){
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter a number to search in the array");
    int key=scan.nextInt();
    BinarySearch obj = new BinarySearch(); 
    int[] myarray={4,5,6,7,8,9,10,12,13,14,15,16,22,25,26,34,35,38,40,45,48,56,59,67,78,80,99,167};
    int index=obj.BinarySearch(key,myarray,0,myarray.length-1);
    if(index==-1){
     System.out.println("Element not found");
    }
    System.out.println(index);
   

}
}