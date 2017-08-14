/*8.3. 
  A magic index in an array A[0...n-1] is defined to be an index such that
  A[i] = i. Given a sorted array of distinct integers, write a method to find a
  magic index, if one exists, in array A.
*/

class MagicIndexDistinct{
          public static void main(String[] args){
                    MagicIndexDistinct obj = new MagicIndexDistinct();
                    int a[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
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
                    else if(a[mid] < mid) return hasMagicIndexhelper(a,mid+1,end);  //magic index value has to be on the right.
                    else return hasMagicIndexhelper(a,start,mid-1);
          }
}