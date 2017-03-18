import java.util.*;
class Node {
    public char label;
    public boolean visited;
    public List<Node> adjacencyList;
    
    public Node(char label){
        this.label = label;
        visited = false;
        adjacencyList = new ArrayList<Node>();
    }
}