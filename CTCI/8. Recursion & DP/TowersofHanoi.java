/*
Logic: 
This puzzle can be solved using recursion. 
For a moment, assume that there are just two discs (disc 1 and 2; disc 2 being the larger one) on the first disc. 
The solution consists of three steps. 

Step 1: Move disc 1 from disc 1 to disc 2.
Step 2: Move disc 2 from disc 1 to disc 3.
Step 3: Move disc 1 from disc 1 to disc 3.


Now, assume that disc 1 is not a single disc but a collection of discs. 
The procedure would be similar to the above three steps, but steps 1 and 3 would be a collection of steps. 
Step 1 would be to move the n-1 discs from disc 1 to disc 2. 
For moving these (n -1) discs, we again follow the same strategy of considering them as 1 disc plus a set of n-2 discs. 
Step 3 would also be similar. This gives us the recursive solution. 

Recursive Algorithm 
The recursive solution to move n discs from the source disc to the destination disc using an buffer disc is given below. 

Base Case - When n = 1
Move the disc from source disc to destination disc 

Recursive Case - When n > 1
Step 1: Move (n-1) discs from source disc to buffer disc.
Step 2: Move the last disc from source disc to destination disc.
Step 3: Move the (n-1) discs from buffer disc to destination disc.
Steps 1 and 3 are recursive invocations of the same procedure. 

*/

public class TowersofHanoi {

   public void solve(int n, String source, String buffer, String destination) {
       if (n == 1) {
           System.out.println(source + " -> " + destination);
       } else {
           solve(n - 1, source, destination, buffer);
           System.out.println(source + " -> " + destination);
           solve(n - 1, buffer, source, destination);
       }
   }

   public static void main(String[] args) {
       TowersofHanoi towersOfHanoi = new TowersofHanoi();
       int discs = 3;
       towersOfHanoi.solve(discs, "A", "B", "C");
   }
}