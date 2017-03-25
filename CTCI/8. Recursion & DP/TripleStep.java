/* Triple Step: 
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up the stairs.
*/
import java.util.*;
public class TripleStep {

    public static void main(String[] args) {
        TripleStep ts = new TripleStep();
        //int noofways = ts.computeNumberOfWaysBruteForce(5);
        int noofways = ts.computeNumberOfWaysMemoization(5);
        System.out.println("Number of ways: " + noofways);
    }

    public int computeNumberOfWaysBruteForce(int n) {
        if (n < 0) return 0;
        else if (n == 0) return 1;
        else return computeNumberOfWaysBruteForce(n - 1) + computeNumberOfWaysBruteForce(n - 2) + computeNumberOfWaysBruteForce(n - 3);
    }

    public int computeNumberOfWaysMemoization(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return counthelper(n, memo);
    }

    public int counthelper(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = counthelper(n - 1, memo) + counthelper(n - 2, memo) + counthelper(n - 3, memo);
        }
        return memo[n];
    }
}