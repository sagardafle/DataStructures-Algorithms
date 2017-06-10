public class MatrixSpiral {

    public static void main(String[] args) {
        
        int arr[][]=
		{{1,  2,  3,  4,  5,  6},
	        	{7,  8,  9,  10, 11, 12},
	        	{13, 14, 15, 16, 17, 18},
	        	{19, 20, 21, 22, 23, 24},
	        	{25, 26, 27, 28, 29, 30},
	        	{31, 32, 33, 34, 35, 36}};
        int rowcount = 6;
        int colcount = 6;
        int total = rowcount * colcount;
        int count = 0;
        int idx1 = 0;
        int idx3 = rowcount - 1;
        int idx4 = idx1;
        while (count < total) {
            for (int i = idx1; i < colcount; i++) {
                System.out.print(arr[idx1][i] + " ");
                count++;
            }
            for (int j = idx1 + 1; j <= rowcount - 1; j++) {
                System.out.print(arr[j][colcount - 1] + " ");
                count++;
            }
            idx3 = colcount - 1;
            for (int k = idx3 - 1; k >= idx1; k--) {
                System.out.print(arr[idx3][k] + " ");
                count++;
            }
            idx4 = rowcount - 1;
            for (int p = idx4 - 1; p > idx1; p--) {
                System.out.print(arr[p][idx1] + " ");
                count++;
            }
            rowcount--;
            colcount--;
            idx1 = idx1 + 1;
        }
    }

}