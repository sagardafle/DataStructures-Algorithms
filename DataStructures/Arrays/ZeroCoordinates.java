// Copyright Karat, Inc. 2016-2017 - Please do not distribute or republish.

import java.io.*;
import java.util.*;

/*
 * The image you get is known to have N rectangles of 0s on a background of 1s. Write a function that takes in the image and outputs the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.
 */

class ZeroCoordinates {
  
   static List<Integer> coords = new ArrayList<>();
  // Sample out
  static int[][] image = {  
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 0, 1},
    {1, 0, 1, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 1, 1, 1},
  };  
  
  // Row = 2, column = 3 
  // OR
  // x = 3, y = 2
  
  // Sample output:  [ 2, 3, 3, 5 ], [ 3, 1, 5, 1 ], [ 5, 3, 6, 4 ]
  // Your function here
  
  
  public List<Integer> findZeroCoordinates(int[] [] img){
   
    
    for( int i = 0; i<image.length ; i++) {
      for( int j=0; j< image[0].length; j++) {
           if(img[i][j] == 0){
                     coords.add(i);
                    coords.add(j);
             findLowerRightCoords(img,i,j);
        } else {
                 // break;
        }
      }
    
    }
    return coords;
  }
  
  
  public void findLowerRightCoords(int[][] img , int x, int y){
    
    int m = 0;
    int n = 0;
    
    for( int i = 0; i<image.length -m; i++) {
      for( int j=0; j< image[0].length -n; j++) {
           if(img[i+m][j+n] == 0){
      
        } else {
              break;
        }
        coords.add(i+m);
              coords.add(j+n);
        
     }
      // n++;
    }
  }
  
  
  public static void main(String[] args) {
      List<Integer> zerolist = new ArrayList<>();
     ZeroCoordinates obj = new ZeroCoordinates();
      zerolist =  obj.findZeroCoordinates(image);
      System.out.print(zerolist);
  }


// if( (img[i][j] == 0) && (img[i][j+1] ==0)){
//              if((img[i+1][j] == 0) && (img[i+1][j+1] ==0)) {
//                coords.add(i);
//                coords.add(j);
//                coords.add(i+1);
//                coords.add(j+1);
}
