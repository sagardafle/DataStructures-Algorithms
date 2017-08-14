/*Source - watch https://youtu.be/NJuKJ8sasGk
         - https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
    Given a total and coins of certain denomination with infinite supply, what is the minimum number
 *  of coins it takes to form this total.
 *
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 
*/
/**
 * Bottom up way of solving this problem.
 * Keep input sorted. Otherwise temp[j-arr[i]] + 1 can become Integer.Max_value + 1 which
 * can be very low negative number
 * Returns Integer.MAX_VALUE - 1 if solution is not possible.
 */


// T  - array to form minimum number of coins it takes for form certain value.
// T[i] - minimum number of coins it takes to form total value i.
// R  - array that indicates final answer. if R[6] = 0 , it means we can form a sum 6 with coin at 0th index (coins[0]).

public class CoinChangingMinimumCoin {
    public int minimumCoinBottomUp(int total, int coins[]) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0; //it takes 0 coins to form the sum-0
        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1; // Initially, we don't know how many coins it might take to form the sum i.
            R[i] = -1;
        }
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {
    /*Enter the condition only if we can form the sum with the current coin. 
      For example, we cannot form sum 2 with coin value - 7.*/
                if (i >= coins[j]) { 
                    T[i] = Math.min(T[i], 1+T[i-coins[j]]);
                    R[i] = j;
                }
            }
        }
        printTArray(T);
        printRArray(R);
        printCoinCombination(R, coins);
        return T[total];
    }

    private void printTArray(int[] a){
        System.out.print("T: ");
        for(int i=0;i<a.length;i++){
             
             System.out.print(a[i]+ " ");
             
        }
        System.out.println();
    }
    
    private void printRArray(int[] a){
        System.out.print("R: ");
        for(int i=0;i<a.length;i++){
             
             System.out.print(a[i]+ " ");
            
        }
         System.out.println();
    }
    private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No sum is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while (start != 0) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j]; //going back coins[j] steps. At 14:30, watch https://youtu.be/NJuKJ8sasGk

        }
        System.out.print("\n");
    }


    public static void main(String args[]) {
        int total = 5;
        int coins[] = {
            1,
            2,
            3
        };
        CoinChangingMinimumCoin cc = new CoinChangingMinimumCoin();

        int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

        System.out.print(String.format("Bottom up result " + bottomUpValue));

    }
}