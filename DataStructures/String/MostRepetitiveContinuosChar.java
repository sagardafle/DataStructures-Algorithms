/*MostRepetitiveContinuosChar Continous */
import java.io.*;
import java.util.Scanner;
public class MostRepetitiveContinuosChar {

    public static void mostRepetitiveChar(String input) {
        char curr = '\0';
        char previous = '\0';
        char result = '\0';
        int max = 0;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            curr = input.charAt(i);
            if (curr != previous) {
                count = 1;
            } else {
                count++;
                if (count>max) {
                    max = count;
                    result = curr;
                }
            }

            if (count > max) {
                max = count;
                result = curr;
            }

            previous = curr;

        }
        System.out.println(result + " " + max);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);

        String input = in .nextLine();

        mostRepetitiveChar(input);

        in .close();

    }

}