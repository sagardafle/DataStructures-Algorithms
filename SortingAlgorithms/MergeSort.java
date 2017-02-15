/**
 * LOGIC: 
 * Reference: https://www.youtube.com/watch?v=0ewhf9bqrJg (Rebel Guru)
 * BREAK: We will break an array of n items into n number of lists.
 * MERGE: Now, we try to eventually merge distinct list in a group so as to form a SINGLE list in a merged and sorted manner.
 * 
 * 
 */
 public class MergeSort{
      public static void main(String args[]){
        int a[] = {-5,2,7,4,10,44,23,41};
        MergeSort  mergeobj = new MergeSort();
        System.out.println("\n=============UnSorted array=============");
         mergeobj.printarray(a);
        mergeobj.mergesort(a,0,a.length-1);
        System.out.println("\n=============Sorted array=============");
        mergeobj.printarray(a);
      }
      
      public void mergesort(int[] array, int low, int high){
         
         if(low<high){ // we will do sorting iff the arraysize is greater than 1. In this case, if low<high. 
             int mid = (low+high)/2;
             
             //Recursively call the mergesort function
             mergesort(array,low,mid); //sorting the left half.
             
             //Recursively call the mergesort function
             mergesort(array,mid+1,high); //sorting the right half.
             
             System.out.println("Performing merge for: low="+low+" mid="+mid+" high="+high);
             merge(array,low,mid,high); //The Conquer step.
         }
      }
      
      public void merge(int[] array, int low, int mid, int high){
          int[] temp = new int[high-low+1]; //helper array
          int left = low;
          int right = mid+1;
          int k = 0;
          
          // STEP:1 Compare each elements of left and right subarray( card deck example) and merge them into temp array
          while(left<=mid && right <= high){
              if(array[left]<array[right]){ //if 1st element on the left is smaller than the 1st element on the right, we add that element in temp array.
                  temp[k++] = array[left++];
              } else {
                  temp[k++] = array[right++];
              }
          }
          
          
          // STEP2: Copy the leftover elements. 2 cases.
          //CASE 1. right sub-array is sorted and merged and some part of the left subarray is remaining.
          if(left <= mid){
              while(left<=mid){
                  temp[k++] = array[left++];
              }
          } else if (right <= high){ //CASE 2. left sub-array is sorted and merged and some part of the right subarray is remaining.
          while(right<=high){
               temp[k++] = array[right++];
            }
          }
          
          //Step3: Copy the temp array back to the original array.
          for(int i=0; i<temp.length; i++){
              array[low+i] = temp[i];
          }
      }
    
    public void printarray(int a[]){
         for (int data:a) System.out.print(data+" ");
         System.out.println();
    }
 }