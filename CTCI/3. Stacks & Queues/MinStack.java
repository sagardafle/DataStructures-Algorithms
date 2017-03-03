import java.util.*;
class NodeWithMin{
    public int value;
    public int min;
    NodeWithMin(int v, int min){
        this.value = v;
        this.min = min;
    }
}
public class MinStack extends Stack<NodeWithMin> {
    
    public void push(int value){
        int newmin = Math.min(value, min());
        super.push(new NodeWithMin(value, newmin));
    }
    
    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
    
    public static void main(String[] args){
        MinStack ms = new MinStack();
        ms.push(13);
        ms.push(4);
        ms.push(32);
        ms.push(8);
        System.out.println(" Min is "+ms.min());
    }
}