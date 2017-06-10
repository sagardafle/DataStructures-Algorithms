import java.util.Scanner;

public class ArrayFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int temp = 0;
        int count = 0;

        System.out.println("please enter a no of elements.");
        int number = sc.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = 0;
        }
        int n;
        while (count < number) {
            System.out.println("Enter element->");
            n = sc.nextInt();
            if (n < 0 && n > 10) {
                System.out.println("please enter a valid numer.");
                break;
            }
            array[n]++;
            count++;
        }
        for (int i = 0; i < number; i++) {
            System.out.print(array[i]);
            System.out.print("");
        }
    }


}