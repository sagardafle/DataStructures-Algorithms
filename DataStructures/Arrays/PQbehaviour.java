import java.util.Comparator;
import java.util.PriorityQueue;
// PQ.java
import java.util.Comparator;

public class PQbehaviour
{
    public static void main(String[] args)
    {
        Comparator<Integer> comparator = new PQComparator();
        PriorityQueue<Integer> queue = 
            new PriorityQueue<Integer>(10, comparator);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (queue.size() != 0)
        {
            System.out.println(queue.poll());
        }
    }
}



 class PQComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer x, Integer y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x < y)
        {
            return 1;
        }
        if (x > y)
        {
            return -1;
        }
        return 0;
    }
}