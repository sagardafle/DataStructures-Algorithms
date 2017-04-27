import java.util.*;
public class BFS {
    public static void main(String[] args){
              
                            
              /**
               *                                  A
               *                                  |
                                                  B -- H
                                                  |
                                                  C -- E -- G
               *                                  |    |
               *                                  D    F          
               */
                                        // Output : A B H C E D G F
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
    c.adjacencyList.add(d);
    c.adjacencyList.add(b);
    e.adjacencyList.add(c);
    e.adjacencyList.add(g);
    //e.adjacencyList.add(h);
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
    doBFS(graph);
    }
    
    public static void doBFS(Graph g){
        List<Node> list = g.vertexList;
        Queue<Node> q = new LinkedList<Node>();
        Node start = list.get(0);
        start.visited = true;
        q.add(start);
        
        while(!q.isEmpty()){
        Node temp = q.poll();
        System.out.println("First visited node - " + temp.label);
        for(Node n : temp.adjacencyList){
            if(n.visited!=true){
                n.visited=true;
                q.add(n);
            }
        }
        }
        
    }
}