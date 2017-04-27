/** Video reference: https://www.youtube.com/watch?v=bIA8HEEUxZI&t=219s
 *  Code reference: https://github.com/lazylad91/Data-Structure/tree/master/Cracking%20the%20coding%20interview/Trees%20and%20Graphs
 */ 
import java.util.*;
public class DFS {
    public static void main(String[] args) {
              
              /**
               *                                  A
               *                                  |
                                                  B -- H
                                                  |
                                                  C -- E -- G
               *                                  |    |
               *                                  D    F          
               */
                                        // Output : A B C D E F G H
        Graph graph = new Graph();

        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');

        a.adjacencyList.add(b);
        b.adjacencyList.add(a);
        b.adjacencyList.add(h);
        b.adjacencyList.add(c);
        h.adjacencyList.add(e);
        h.adjacencyList.add(b);
        c.adjacencyList.add(e);
        c.adjacencyList.add(b);
        c.adjacencyList.add(d);
        e.adjacencyList.add(c);
        e.adjacencyList.add(g);
        e.adjacencyList.add(h);
        e.adjacencyList.add(f);
        g.adjacencyList.add(e);
        f.adjacencyList.add(e);
        d.adjacencyList.add(c);


        graph.vertexList.add(a);
        graph.vertexList.add(b);
        graph.vertexList.add(c);
        graph.vertexList.add(d);
        graph.vertexList.add(e);
        graph.vertexList.add(f);
        graph.vertexList.add(g);
        graph.vertexList.add(h);

        doDFS(graph);
    }

    public static void doDFS(Graph g) {
        List < Node > list = g.vertexList;
        Stack < Node > st = new Stack < Node > ();
        Node start = list.get(0); //start == a
        start.visited = true;
        st.push(start);

        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.println("First visited node - " + temp.label);
            for (Node n: temp.adjacencyList) {
                if (n.visited != true) {
                    System.out.println("Exploring "+n.label);
                    n.visited = true;
                    st.push(n);
                }
            }
        }
    }
}