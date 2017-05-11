public class Floor {
    int floorSearch(int arr[], int low, int high, int x){
    // If low and high cross each other
    if (low > high)
        return -1;
 
    // If last element is smaller than x
    if (x >= arr[high])
        return high;
 
    // Find the middle point
    int mid = (low+high)/2;
 
    // If middle point is floor.
    if (arr[mid] == x)
        return mid;
 
    // If x lies between mid-1 and mid
    if (mid > 0 && arr[mid-1] <= x && arr[mid] > x)
        return mid-1;
 
    // If x is smaller than mid, floor must be in
    // left half.
    if (x < arr[mid])
        return floorSearch(arr, low, mid-1, x);
 
    // If mid-1 is not floor and x is greater than arr[mid],
    return floorSearch(arr, mid+1, high, x);
}

    // Initial call
    int floor(int A[], int size, int key) {
        // Add error checking if key < A[0]
        if (key < A[0])
            return -1;

        // Observe boundaries
        return floorSearch(A, 0, size, key);
    }

    public static void main(String[] args) {
        Floor obj = new Floor();
        int a[] = {1, 2, 4, 6, 10, 12, 14};
        int n = a.length;
        int floor = a[obj.floor(a, n-1, 3)];
        System.out.println("Floor is: " + floor);
    }
}