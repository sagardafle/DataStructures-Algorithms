/*8.3. 
  A magic index in an array A[0...n-1] is defined to be an index such that
  A[i] = i. Given a sorted array of distinct integers, write a method to find a
  magic index, if one exists, in array A.
  
  FOLLOW UP
  What if the values are not distinct?
*/

class MagicIndexNonDistinct{
          public static void main(String[] args){
                    MagicIndexNonDistinct obj = new MagicIndexNonDistinct();
                    int a[] = {-10,-5,2,2,2,3,4,7,9,12,13}; 
                    System.out.println("Has magix index=" +obj.hasMagicIndex(a));
          }
          
          public boolean hasMagicIndex(int [] a){
                    return hasMagicIndexhelper(a, 0, a.length-1);
          }
          
          public boolean hasMagicIndexhelper(int a[] ,int start, int end){
                    if(end<start) return false;
                    int mid = (start+end)/2;
                    if(a[mid] == mid) {
                              System.out.println("Magix Index is:" +mid);
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