/*1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, 
its entire row and column are set to 0.*/

class ZeroMatrix
{
  public static void main(String[] args)
  {
    int[][] input = { {3, 5, 0, 4},
                      {2, 1, 9, 7},
                      {3, 2, 1, 0},
                      {8, 5, 0, 4} };
    //unoptimized(input);
    optimizedtime(input);
  }
 
 /**
  * Almost same as unoptimized way. 
  * We use nullifyrows and nullifycolumns method which reduces the time complexity to O(n).
  */
  
 public static void optimizedtime(int[][] a){
    /*Array[number of arrays][how many elements in each of those arrays]*/           
     int rows = a.length;  // 4
     int cols = a[0].length;     // 4
     boolean[] rowarr = new boolean[rows];
     boolean[] colarr = new boolean[cols];
     for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
             if(a[i][j] == 0){
                 rowarr[i] = true;
                 colarr[j] = true;
             }
         }
     }
     
     for(int i=0;i<rowarr.length;i++){
         if(rowarr[i]) nullifyRows(a,i);
     }
     
     for(int i=0;i<colarr.length;i++){
         if(colarr[i]) nullifyColumns(a,i);
     }
     
     print2dmatrix(a,rows,cols);
     
 }
 
    public static void nullifyRows(int[][] a, int rownum){
         for(int i=0;i<a[0].length;i++)
          a[rownum][i] = 0;
     }
     
     public static void nullifyColumns(int[][] a, int column){
         for(int i=0;i<a.length;i++)
          a[i][column] = 0;
     }
     

 
 /**
  * LOGIC: O(n2)
  * 1. Iterate through 2D array. 
  * 2. Get the indices where a[i][j] = 0. Store them in 2 arrays, one for rows and other for columns. 
  * 3. Now, fill the required indices with 0. 
  *    3.1 Loop through the 2D array. 
  *    3.2 Set the row to zero as per the rowarr.
  *    3.3 Set the column to zero as per the colarr.
  */ 
 public static void unoptimized(int[][] a){
     int rows = a[0].length;  // 4
     int cols = a.length;     // 3
     int[] rowarr = new int[rows];
     int[] colarr = new int[cols];
     for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
             if(a[i][j] == 0){
                 rowarr[i] = 1;
                 colarr[j] = 1;
             }
         }
     }
     
     for(int m=0;m<rowarr.length;m++){
         System.out.print(rowarr[m]);
     }
        System.out.println();
     for(int m=0;m<colarr.length;m++){
         System.out.print(colarr[m]);
     }
      System.out.println("\nm");
     fill(a,rowarr,colarr,rows,cols);
     print2dmatrix(a, rows,cols);
 }
 
 public static void fill(int[][] a, int[] rowarr, int[] colarr, int rows,int cols){
      for(int i=0;i<rowarr.length;i++){
          for(int j=0;j<colarr.length;j++){
              if(rowarr[i] == 1){
                  System.out.println("Making a["+i+"]["+j+"] = 0");
                 a[i][j] = 0; 
              } 
              if(colarr[j] == 1){
                  System.out.println("Making a["+i+"]["+j+"] = 0");
                  a[i][j] = 0;
              } 
      }
 }
}
public static void print2dmatrix(int[][] a, int rows,int cols){
     for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
             System.out.print(a[i][j]);
         }
         System.out.println();
     }
    }
}