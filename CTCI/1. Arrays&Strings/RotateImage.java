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
		rotate90Degrees(image);
		
	}

	public static void rotate90Degrees(int[][] image) {
		
	
		int[][] rotatedImage = new int[image.length][image[0].length];
	    for(int i=0;i<image.length;i++){
	            rotatedImage[i][0] = image[image.length-1][i];
	            rotatedImage[i][1] = image[image.length-2][i];
	            rotatedImage[i][2] = image[image.length-3][i];
	            rotatedImage[i][3] = image[image.length-4][i];
	        }
		
		
		System.out.println("\nRotated 90 degrees:");
		print(rotatedImage);
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