import java.util.ArrayList;
import java.util.List;

public class WeightedArray {


    public static List < List < Integer >> arraySplit(int[] arr, int k) {
        List < Integer > temp = null;
        List < List < Integer >> res = new ArrayList < > ();
        int i = 0;
        for (i = arr.length - 1; i >= (arr.length - k); i--) {
           temp = new ArrayList < > ();
            temp.add(arr[i]);
            res.add(temp);
        }
        
        System.out.println("Resut: "+res+ " i: "+i);
        while (i >= 0) {
            int c = getListIndexWithMinSum(res);
            res.get(c).add(arr[i]);
            System.out.println("temp: "+temp+ "res: "+res+"c: "+c);
            i--;
        }
        return res;
    }

    private static int getListIndexWithMinSum(List < List < Integer >> res) {
        int minIndex = 0;
        int minSum = Integer.MAX_VALUE;
        int i = 0;
        for (List < Integer > l: res) {
            int currSum = sum(l);
            if (minSum > currSum) {
                minSum = currSum;
                minIndex = i;
            }
            i++;
        }
        return minIndex;
    }

    private static int sum(List < Integer > arr) {
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {
            1,
            4,
            6,
            9,
            10
        };
        List < List < Integer >> res = arraySplit(arr, 3);

        System.out.println(res);

    }

}