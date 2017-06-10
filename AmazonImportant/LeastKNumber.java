public class LeastKNumber{
          public static void main(String[] args){
               int[] a = {1,3,5,7};
               int[] b = {2,4,6,8};
               LeastKNum(a,b,6);
          }
 public static void LeastKNum(int[] a, int[] b, int n){
        int i=0,j=0,k=0;

        while (k<n&&i<a.length&&j<b.length){
            if (a[i]<b[j]){
                System.out.println(a[i]);
                i++;
            }else{
                System.out.println(b[j]);
                j++;
            }
            k++;
        }

        while (k<n&&i<a.length){
            System.out.println(a[i]);
            i++;
            k++;
        }

        while (k<n&&j<b.length){
            System.out.println(b[j]);
            j++;
            k++;
        }
    }
}