/*Source - watch https://youtu.be/NJuKJ8sasGk
         - https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
*/
/**
 * Bottom up way of solving this problem.
 * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
 * can be very low negative number
 * Returns Integer.MAX_VALUE - 1 if solution is not possible.
 */


// T  - array to form minimum number of coins it takes for form certain value.
// R  - array that indicates final answer. if R[6] = 0 , it means we can form a sum 6 with coin at 0th index (coins[0]).

public class CoinChangingMinimumCoin {
    public int minimumCoinBottomUp(int total, int coins[]) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {
                if (i >= coins[j]) {
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
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
        int total = 13;
        int coins[] = {
            7,
            2,
            3,
            6
        };
        CoinChangingMinimumCoin cc = new CoinChangingMinimumCoin();

        int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

        System.out.print(String.format("Bottom up result " + bottomUpValue));

    }
}