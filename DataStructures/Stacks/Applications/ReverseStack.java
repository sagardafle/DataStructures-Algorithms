import java.util.*;
public class ReverseStack{
    static Stack<Integer> s = new Stack<Integer>();
    public static void main(String[] args){
        s.push(100);
        s.push(900);
        s.push(300);
        s.push(800);
        System.out.println("Original stack: "+s);
        //Stack<Integer> reversed = reverseStackIterative(s);
        reverseStackRecursive(s);
        System.out.println("Reversed stack: "+s);
    }
    
    public static void reverseStackRecursive(Stack s){
          if(s.isEmpty()) return;
          int data = (int) s.pop();
          reverseStackRecursive(s);
          insertAtBottom(s,data);
    }
    
    public static void insertAtBottom(Stack s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp= (int) s.pop();
        insertAtBottom(s,data); 
        s.push(temp);
    }
    
    public static Stack<Integer> reverseStackIterative(Stack s){
        Stack<Integer> output = new Stack<Integer>();
        while(s.size()>0){
            output.push((int) s.pop());
        }
        return output;
    }
    
    
}