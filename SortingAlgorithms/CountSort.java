public class CountSort {
    public static void main(String[] args) {
        int[] a = {
            8,
            8,
            8,
            9,
            9,
            4,
            5,
            5,
            6,
            6,
            6,
            1,
            3
        };
        int maxvalue = 9;
        int[] sorted = countingSort(a, maxvalue);
        System.out.println("Sorted array is: ");
        for (int val: sorted) {
            System.out.print(val + " ");
        }
    }

    public static int[] countingSort(int[] a, int maxValue) {

        // array of 0's at indices 0...maxValue
        int numCounts[] = new int[maxValue + 1];

        // populate numCounts
        for (int num: a) {
            numCounts[num] += 1;
        }

        // populate the final sorted array
        int[] sortedArray = new int[a.length];
        int currentSortedIndex = 0;

        // for each num in numCounts
        for (int num = 0; num < numCounts.length; num++) {
            int count = numCounts[num];

            // for the number of times the item occurs
            for (int x = 0; x < count; x++) {

                // add it to the sorted array
                sortedArray[currentSortedIndex] = num;
                currentSortedIndex++;
            }
        }

        return sortedArray;
    }
}