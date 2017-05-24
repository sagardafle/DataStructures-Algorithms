import java.util.*;
public class DeleteValue {
          public static void main(String[] args){
                    List<String> gg = new ArrayList<>();
                    gg.add("America");
                    gg.add("Afghanistan");
                    gg.add("Dublin");
                    gg.add("Egypt");
                    List<String> output = removeElements(gg);
                    System.out.println(output);
          }
          
    public static List<String> removeElements(List < String > items) {
        boolean[] deleteindex = new boolean[items.size()];
        if (items == null || items.size() == 0) return items;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                String item = items.get(i);
                boolean match = item.startsWith("A");
                if (match) {
                    //delete this index
                    deleteindex[i] = true;
                }
            }
        }

        return deleteindexes(deleteindex, items);
    }

    public static List<String> deleteindexes(boolean[] deleteindex, List < String > items) {
        for (int j = deleteindex.length - 1; j >= 0; j--) {
            if (deleteindex[j]) items.remove(j);
        }
        return items;
    }

}