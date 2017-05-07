/*8.3. 
  A magic index in an array A[0...n-1] is defined to be an index such that
  A[i] = i. Given a sorted array of distinct integers, write a method to find a
  magic index, if one exists, in array A.
  
  FOLLOW UP
  What if the values are not distinct?
*/

/*Logic:
if A[mid] < mid , we cant be sure whether to go right or left unlike previous example. 
:et A[3] = 2, A[4] = 2 and A[5] =3 and consider mid = 5. 
Now, we are sure that '4' cannot be magic since A[4] HAS TO BE less than or equal to A[5](which is 3).
So, we can easily skip A[4] while checking left part of the array. 
This skipping is determined as:

          - Left part : leftIndex = Math.min(mid-1,a[mid]); //   let mid = 5 A[5]=3      Math.min(4,3) .. we search from 0..3
          - Right part : rightIndex = Mat.max(mid+1,a[mid]); //                          Math.max(6,3) .. we search from 6..n-1

*/
class MagicIndexNonDistinct{
          public static void main(String[] args){
                    MagicIndexNonDistinct obj = new MagicIndexNonDistinct();
                    int a[] = {-10,-5,2,2,2,3,4,7,9,12,13}; 
                    System.out.println("Has magix index= " +obj.hasMagicIndex(a));
          }
          
          public boolean hasMagicIndex(int [] a){
                    return hasMagicIndexhelper(a, 0, a.length-1);
          }
          
          public boolean hasMagicIndexhelper(int a[] ,int start, int end){
                    if(end<start) return false;
                    int mid = (start+end)/2;
                    if(a[mid] == mid) {
                              System.out.println("Magix Index is: " +mid);
                              return true;
                    }
                    
                             
                    /*Search in left side*/
                    int leftIndex = Math.min(mid-1,a[mid]);
                    if(hasMagicIndexhelper(a, start, leftIndex)){
                              return true;
                    }
                    
                    /*search in right side*/
                    int rightIndex = Math.max(mid+1,a[mid]);
                    return hasMagicIndexhelper(a, rightIndex, end);
                    
          }
}