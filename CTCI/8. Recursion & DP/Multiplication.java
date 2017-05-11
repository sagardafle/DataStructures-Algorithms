/*LOGIC :

Complexity: O(log(s)) where s is the smaller number to be multiplied.
 Case-1 : When smaller number is even:
          minprod(30,35) = 2 * minprod(15,35);
 Case-2 : When smaller number is odd:
          minprod(31,35) = 2 * minprod(15,35) + 35; (2*halfprod+largernumber) == (halfprod+halfprod+largenum)
          
          On even numbers, we just divide the smaller number by 2 and double the result on recursive calls.
          On odd numbers, we do the same, but we also add bigger number to the result.
          
          Our minproduct function just recurses straight downwards with smaller numbers each time and no call will be repeated.
          So we dont need to memoize any data.

*/
public class Multiplication{
          
	public static int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		
		return minProductHelper(smaller, bigger);
	}
	
	public static int minProductHelper(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;           /* 0*bigger = 0   */
		} else if (smaller == 1) {
			return bigger;      /* 1*bigger = bigger */
		} 
		
		/*Compute Half. If even, double it. If uneven, compute double half. */
		int s = smaller >> 1; //divide smaller number by 2.
		int halfProd = minProductHelper(s, bigger);
		
		if (smaller % 2 == 0) {
			return halfProd + halfProd;
		} else {
			return halfProd + halfProd + bigger;
		}
	}

	
	
	
	public static void main(String[] args) {
		int a = 9;
		int b = 10;
		int product = a * b;
		int minProduct = minProduct(a, b);
		if (product == minProduct) {
			System.out.println("Success: " + a + " * " + b + " = " + product);
		} else {
			System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
		}
	}
}