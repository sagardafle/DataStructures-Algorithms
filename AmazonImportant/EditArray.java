public class EditArray {
    public static void main(String[] args) {
        int[] arr = {
            3,
            3,
            3,
            3,
            2,
            2,
            1,
            1,
            1,
            1,
            6,
            6,
            6,
            6,
            7,
            8
        };
        editArray(arr, 4, arr.length);
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
    
    public static void editArray(int arr[], int m, int arr_size) {
        int cur, i, cur_ele = -1;
        int count = 0;

        cur = 0;

        for (i = 0; i < arr_size; i++) {
            if (cur_ele != arr[i]) {
                cur_ele = arr[i];
                count = 0;
            }

            if (cur_ele == arr[i] && count < Math.min(m, 2)) {
                count++;
                arr[cur] = arr[i];
                cur++;
            }
        }

        for (i = cur; i < arr_size; i++)
            arr[i] = 0;
    }
}