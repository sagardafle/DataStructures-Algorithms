/**
         *Perform deletion k times from the max heap
        */

public class KthSmallestElement {
    int position;
    int size;
    public int [] a;
    
    public KthSmallestElement(int size){
		this.size=size;
		a = new int [size+1];
		position = 0;
	}
	
    public static void main(String args[]){
       	int a [] = {3,2,1,7,8,4,16,12,9};
		System.out.print("Original Array : ");
		for(int i=0;i<a.length;i++){
			System.out.print("  " + a[i]);
		}
		KthSmallestElement delobj = new KthSmallestElement(a.length);
		System.out.print("\nMax-Heap : ");
        delobj.createHeap(a);		
		delobj.display();
        int requiredelement = delobj.getElement(5); 
        System.out.println("requiredelement "+requiredelement);
        delobj.display();
    }
    
    public void createHeap(int [] arrA){
		if(arrA.length>0){
			for(int i=0;i<arrA.length;i++){
				insert(arrA[i]);
			}
		}		
	}
    
    	public void insert(int x){
	    if(position==0){
	        a[position+1]=x;
			position = 2;
	    } else{
			a[position++]=x;
			swim();
		}
	}
	
	/**
	 * balances the binary tree if the parent<children or children>parent.
	 */ 
	
	public void swim(){
	    int pos = position-1;
		while(pos>0 && a[pos/2]<a[pos]){  //swap only if parent<children
			int y = a[pos];
			a[pos]=a[pos/2];
			a[pos/2] = y;
			pos = pos/2; //set pos to parent and do the same check.
		}
	}
    
    public int getElement(int k){
        int extractedvalue = -1;
        
        for(int i=0; i<k-1; i++)
             extractedvalue = extractMin();
		return extractedvalue;
    }
    
    public int extractMin(){
		int min = a[1];
		a[1]=a[position-1];
		a[position-1]=-1;
		position--;		
		sinkDown(1);
		return min;
	}
    
    
    public void sinkDown(int k){
		System.out.println("k =  " + k);
		int smallest = k;
		if(2*k<position && a[smallest]<a[2*k]){
			System.out.println("Setting smallest to  " + 2*k);
			smallest = 2*k;
		}
		if(2*k+1<position && a[smallest]<a[2*k+1]){ //check if the left child is lesser than right. If yes, we swap will right child.
				System.out.println("Setting smallest +1 to  " + 2*k+1);
			smallest = 2*k+1;
		}
			System.out.println("smallest =  " + smallest);
		if(smallest!=k){
			swap(k,smallest);
			sinkDown(smallest);
		}
	}
	
	public void swap(int x, int y) {
        System.out.println("swapping " + a[x] + " and " + a[y]);
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
	
		public void display(){
		for(int i=1;i<a.length;i++){
			System.out.print(" " + a[i]);			
		}
		System.out.println("");
	}
}