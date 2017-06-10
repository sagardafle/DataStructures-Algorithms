import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class PS {

public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println("ArrayList-lunchMenuPairs");
ArrayList<ArrayList<String>> agr1 = new ArrayList<>();
agr1.add(new ArrayList<>());
agr1.add(new ArrayList<>());
agr1.add(new ArrayList<>());
agr1.get(0).add("Pizza");
agr1.get(0).add("Italian");
agr1.get(1).add("Curry");
agr1.get(1).add("Indian");
agr1.get(2).add("Masala");
agr1.get(2).add("Indian");
System.out.println("ArrayList-teamCuisinePreference");
ArrayList<ArrayList<String>> agr2 = new ArrayList<>();
agr2.add(new ArrayList<>());
agr2.add(new ArrayList<>());
agr2.add(new ArrayList<>());
agr2.add(new ArrayList<>());
agr2.get(0).add("Jose");
agr2.get(0).add("Italian");
agr2.get(1).add("John");
agr2.get(1).add("Indian");
agr2.get(2).add("Sarah");
agr2.get(2).add("Thai");
agr2.get(3).add("Mary");
agr2.get(3).add("*"); 
System.out.println("Input lunchMenuPairs-"+"\n"+agr1+"\n Input teamCuisinePreference \n"+agr2);
ArrayList<ArrayList<String>> Output = new ArrayList<>();
int c=0;
for (int i=0;i<agr1.size();i++){
for (int j=0;j<agr2.size();j++){
if(agr2.get(j).get(1).equals(agr1.get(i).get(1)) || agr2.get(j).get(1).equals("*") ){
Output.add(new ArrayList<>());
Output.get(c).add(agr2.get(j).get(0));
Output.get(c).add(agr1.get(i).get(0));
c++;
}
continue;
}
}
System.out.println("Output -"+"\n"+Output);
}

}