/**
 * You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).

	Follow up:
	Could you do this in-place?
LOGIC: 
 * 
 *  2 Steps: 
        Step-1: Find Transpose of matrix : A matrix which is formed by turning all the rows of a given matrix into columns and vice-versa. 
        Step-2: Change the symmetry.
        */
public class RotateImage {
	public static void main(String[] args){
	    	int[][] image = {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
    	};
	    
		System.out.println("Original:");
		print(image);
		transpose(image);
		changesymmetry(image);
		print(image);
		
	}

	public static void transpose(int[][] matrix) {
		int s = 0;
		int e = matrix.length-1;
        
		while(s<=e){
	            int[] temp = matrix[s];
	            matrix[s] = matrix[e];
	            matrix[e] = temp;
	            s++;e--;
		}
	}
	
	public static void changesymmetry(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=i+1;j<matrix[0].length;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		System.out.println("\nRotated 90 degrees:");
	}
	
	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}