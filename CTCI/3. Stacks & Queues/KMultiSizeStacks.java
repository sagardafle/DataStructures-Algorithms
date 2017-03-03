import java.util.*;

/**
 * Implement k stacks in an array
 * Time- O(1)
 * Space- O(n+k) 
 */
 
public class KMultiSizeStacks {
    int[] arr;
    int[] top;
    int[] next;
    int free; int k,n;
    
    //k is the number of stacks and n is array length
    KMultiSizeStacks(int k,int n){
        this.k=k;
        this.n=n;
        arr=new int[n];
        top=new int[k];
        next=new int[n];
        for(int i=0;i<k;i++){
            top[i]= -1;
        }
        for(int i=0;i<n-1;i++){
            next[i]= i+1;
        }
        next[n-1]=-1;
        free=0;
    }
    
    /*
    * data- item to be pushed
    * kn - stack number
    */
    void push(int data, int kn){
        if(isFull()){
            System.out.print("Stack overflow");
            return;
        }
        int i=free;
        free=next[i];
        next[i]=top[kn];
        top[kn]=i;
        
        arr[i]=data;
    }
    
    
    int pop(int kn){
        if(isEmpty(kn)){
            System.out.print("Stack underflow");
            return Integer.MAX_VALUE;
        }
        int i=top[kn];
        top[kn]=next[i];
        next[i]=free;
        free=i;
        
        return arr[i];
    }
    
    boolean isFull(){
        return free==-1;
    }
    
    boolean isEmpty(int kn){
        return top[kn]==-1;
    }
    
	public static void main(String args[]){
    // Let us create 3 stacks in an array of size 10
    int k = 3, n = 10;
    KMultiSizeStacks ks=new KMultiSizeStacks(k, n);
 
    // Let us put some items in stack number 2
    ks.push(15, 2);
    ks.push(45, 2);
 
    // Let us put some items in stack number 1
    ks.push(17, 1);
    ks.push(49, 1);
    ks.push(39, 1);
 
    // Let us put some items in stack number 0
    ks.push(11, 0);
    ks.push(9, 0);
    ks.push(7, 0);
 
    System.out.println("Popped element from stack 2 is "+ks.pop(2));
    System.out.println("Popped element from stack 1 is "+ks.pop(1));
    System.out.println("Popped element from stack 0 is "+ks.pop(0));
	}
}
