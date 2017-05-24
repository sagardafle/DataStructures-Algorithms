import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        try {
            FileInputStream fstream = new FileInputStream("task2.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            List < integer > rating = new ArrayList < > ();
            HashMap < String, rating > productsandrating = new HashMap < > ();
            HashMap < Date, productsandrating > map = new HashMap < > ();
            while ((strLine = br.readLine()) != null) {
                String[] parts = strLine.split("\\s+");
                // 0 -> date 1-> TS 2 -> product 3 -> RATING
                //     for(int i=0;i<parts.length; i++){
                //             //  System.out.print(parts[i]+" ");
                //     }
                rating.add(parts[3]);
                productsandrating.put(parts[2], rating);
                mp.put(parts[0], productsandrating);
                System.out.println();
            }

            printoutput(map);

            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }



    }

    public static void printoutput(HashMap < Date, productsandrating > map) {
          
          System.out.println("Date \t Item \t # of1 \t # of 2 \t # of 3 \t # of 4 \ t # of 5");

    }
}