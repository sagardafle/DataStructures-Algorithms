/**
 * LOGIC: 
 * 1. Divide the array into sizes n/k.
 * 2. Fix the slots for different stacks, i.e., use arr[0] to arr[n/k-1] for first stack, and arr[n/k] to arr[2n/k-1].
 * 3. Problem : Inefficient use of array space. A stack push operation may result in stack overflow even if there is space available in arr[].
 */
 
class KFixedSizeStacks{
    static int k;
    int stacksize;
    private int[] values;
    private int[] sizes;
    public static void main(String args[]){
        k = 4;
        int stackcapacity = 3;
        KFixedSizeStacks kFixedSizeStacks = new KFixedSizeStacks(stackcapacity);
        
        //Push values in stack1
        for(int i=1;i<=stackcapacity;i++){
            kFixedSizeStacks.push(1,i); // 1 2 3 
        }
        
        //Push values in stack2
        for(int i=1;i<=stackcapacity;i++){
            kFixedSizeStacks.push(2,i+stackcapacity); //4 5 6
        }
        
        //Push values in stack3
        for(int i=1;i<=stackcapacity;i++){
            kFixedSizeStacks.push(3,i+stackcapacity+stackcapacity);// 7 8 9
        }
        
        System.out.println("========Before popping========");
        kFixedSizeStacks.printStack(1);
         System.out.println("========After popping========");
        //Pop from stack 1
        kFixedSizeStacks.pop(1);
        kFixedSizeStacks.printStack(1);
        
        
        
    }
    
    KFixedSizeStacks(int stacksize){
        this.stacksize = stacksize;
        values = new int[k*stacksize]; // to hold the list of all the values in the stack.
        sizes = new int[k]; // to hold the sizes of each stack.
    }
    
    /**
     * Return the top index of respective stack.
     */ 
    public int getTop(int stacknum){
        int offset = stacknum*stacksize;
        int size = sizes[stacknum];
        return offset+size-1;
    }
    
    /**
     * 1. push(stacknum, val)
     */
     public void push(int stacknum, int val){
         sizes[stacknum]+= 1;  //increment the value of the sizes array for the corresponding stack.
         values[getTop(stacknum)] = val; // add the value to be pushed at the corresponding top of the stack.
     }
     
     /**
      * 2. POP(stacknum)
     */
     public int pop(int stacknum){
         int topIndex = getTop(stacknum);
         int topmostelement =  values[topIndex]; // This is the topmost element. We shall return this.
         values[getTop(stacknum)] = 0; //clear the respective value.
         sizes[stacknum]-= 1; //decrement the sizes array for the corresponding stack.
         return topmostelement;
     }
     
     /**
      * 3. PEEK(stacknum)
      */
      public int peek(int stacknum){
          return values[getTop(stacknum)];
      }
      
      /**
       * 4. Print stack
       */
       public void printStack(int stacknum){
           System.out.println(" Printing stack "+stacknum);
           for (int i=0; i<sizes[stacknum];i++){
               System.out.print(values[getTop(stacknum)-i]+" -> ");
           }
           System.out.println();
       }
}