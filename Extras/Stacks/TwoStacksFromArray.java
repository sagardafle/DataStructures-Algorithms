public class TwoStacksFromArray{
    
    /**
     * LOGIC: 
     * 1. We maintain 2 top pointers (top1,top2) for two respective stacks. 
     * 2. Initially, top1= -1 & top2= n (n - length of the array)
     * 3. As we push the elements in respective stack we check if there is a space i.e top2-top1>1
     * 4. Increment and Decrement the values of the top pointers while pushing values in stack#1 and stack#2, respectively.
     * 5. Decrement and Increment the values of the top pointers while popping values in stack#1 and stack#2, respectively.
     */ 
    
    class StackOverFlowException extends Exception
    {
          public StackOverFlowException(String message)
          {
            super(message);
            System.out.println(" ERROR:" +message);
          }
    }
    
        static private int k; //no of stacks
        static private int stacksize;
        static private int stackcapacity;
        static private int[] values;
        static private int[] sizes;
        static private int top1;
        static private int top2;
        
        
        TwoStacksFromArray (int stackcapacity){
        this.stackcapacity = stackcapacity;
        values = new int[k*stackcapacity]; // to hold the list of all the values in the stack.
        sizes = new int[k]; // to hold the sizes of each stack.
    }
    
    public static void main(String[] args){
        k = 2; 
        stackcapacity = 3;
        TwoStacksFromArray twostacks = new TwoStacksFromArray(stackcapacity);
        top1 = -1;
        top2 = values.length;
        
        /**
         * Push an element to first stack
         **/
         for(int i=0;i<stackcapacity;i++){
             twostacks.push1(0,i);  // 0 1 2 
         }
         twostacks.printStack(0);
         
         /**
         * Push an element to second stack
         **/
         for(int i=0;i<stackcapacity;i++){
             twostacks.push2(1,i+stackcapacity); //3 4 5
         }
         twostacks.printStack(1);
         
         System.out.println("Top1 "+top1);
         System.out.println("Top2 "+top2);
         
         /**
          * forceful push to create exception
          */
        // twostacks.push2(1,108);
         
         System.out.println("Popped value from stack#1 is: "+twostacks.pop1());
         System.out.println("Popped value from stack#1 is: "+twostacks.pop2());
         
         System.out.println("Stack#1 isEmpty: "+twostacks.isEmpty1());
         System.out.println("Stack#1 isEmpty: "+twostacks.isEmpty2());
         
         System.out.println("Stack#1 Size: "+twostacks.size1());
         System.out.println("Stack#1 Size: "+twostacks.size2());
    }
    
    public void push1(int stacknum, int val){
        try{
             if(top2-top1>1){ 
                top1++;
                sizes[stacknum] +=1;
                values[top1] = val;
        } else {
            throw new StackOverFlowException("No space to add new data");
            }
        } catch(StackOverFlowException ex) {
              //Process message however you would like
         }
    }
    
    
    public void push2(int stacknum, int val){
        try{
             if(top2-top1>1){ 
                top2--;
                sizes[stacknum] +=1;
                values[top2] = val;
        } else {
            throw new StackOverFlowException("No space to add new data");
            }
        } catch(StackOverFlowException ex) {
              //Process message however you would like
         }
    }
    
    public int pop1(){
        int val = values[top1];
        top1--;
        sizes[0] -= 1;
        return val;
    }
    
     public int pop2(){
        int val = values[top2];
        top2++;
        sizes[1] -= 1;
        return val;
    }
    
    public boolean isEmpty1(){
        return (top1 == -1) ?  true: false;
    }
    
    public boolean isEmpty2(){
        return (top2 == values.length) ?  true: false;
    }
    
    public int size1(){
        return sizes[0];
    }
    
    public int size2(){
        return sizes[1];
    }
    
    public void printStack(int stacknum){
           System.out.println("\nPrinting stack "+stacknum);
           if(stacknum ==0){
               for (int i=0; i<sizes[stacknum];i++){
               System.out.print(values[top1-i]+" -> ");
                }
           } else {
               for (int i=0; i<sizes[stacknum];i++){
               System.out.print(values[top2+i]+" -> ");
            }
           System.out.println();
       }
    }
}