// package whatever; // don't place package name!
//You have a list of sorted numbers find how many times the elements K has been repeated:

//Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
//Output: 2 

//Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
//Output: -1 // 4 doesn't occur in arr[] 
import java.io.*;

class DuplicateCount
{
    static int count = 0;
    static int firstoccurence = 0;
    static int lastoccurence = 0;
    public static void main (String[] args) throws java.lang.Exception
    {
       int[] a = {1, 1, 2, 2, 2, 2, 2, 3, 3, 3};
        int n = a.length-1;
        int x = 2;
        
        int first = findFirst(a,0,n,x);
        int last = findLast(a,0,n,x);
        System.out.println("F: "+first);
        System.out.println("L: "+last);
        
        count = Math.abs(first-last)+1;
        System.out.println("Count of "+x+ " is: "+count);
        
    }
    
    public static int findFirst(int[] a, int start, int end, int x){
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            if(a[mid] == x) {
               while(mid>0 && a[mid]==x){
                         mid--;
               }
               break;
            }
            else if (a[mid]>x) end = mid-1;
                else start = mid+1;
        }
        return mid+1;
     }
    
    public static int findLast(int[] a, int start, int end, int x){
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            if(a[mid] == x) {
               while(mid<a.length && a[mid] == x){
                         mid++;
               }
               break;
            }
            else if (a[mid]>x) end = mid-1;
                else start = mid+1;
        }
        return mid-1;
     }
    
   
}


/* 
Your last C# code is saved below:
using System;

public class Test
{
    public static void Main()
    {
        Console.WriteLine("Hello");
    }
}
 */