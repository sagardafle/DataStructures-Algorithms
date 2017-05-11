/**http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */
class LargestDiffrence{
          public static void main(String[] args){
                 int[] arr = {2, 3, 10, 6, 4, 8, 1};
                 int j = arr.length -1;
                 int maxdiff = Integer.MIN_VALUE;
                 for(int i=0;i<arr.length;i++){
                           while(j>i){
                                     if(arr[j]-arr[i]>maxdiff) {
                                               maxdiff = arr[j]-arr[i];
                                     }
                                     j--;
                              }  
                 }
                 System.out.println(maxdiff);
          }
}