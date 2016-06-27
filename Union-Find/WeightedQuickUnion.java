public class WeightedQuickUnion{
    static int numberarray[];
    static int sz[];
    public static void main(String args[]){
        int n=10;
         numberarray = new int[n];
         sz = new int[n];
        for(int i=0;i<numberarray.length;i++){
            numberarray[i] = i;
        }
        
        
        union(1,2);
        union(6,5);
        union(5,0);

        
        System.out.println(isConnected(2,1)); //Symmetric rule. 1=>2 then 2=>1.  
        System.out.println(isConnected(0,5)); //follows the transitive rule : if 6=>5 & 5=> 0 , 6 => 0 .
        System.out.println(isConnected(0,4));
         
        
    }
    
    public static void union(int a, int b){
        
        /*
            RULES : 
            1. a[i] is the parent of i.
            2. Root of i is id[id[id[....id[i]....]]]
            3. Find the roots of a and b. If they are equal exit the function as they are already connected.
            4. Maintain an extra array sz such that sz[i] is the count of objects rooted at i.
            5. We ALWAYS link the root of smaller tree to the root of larger tree(smaller tree at the bottom).
            6. Update the sz array after linking.
        */
        
        int i = root(a);
        int j = root(b);
        if(i==j) return;
        if(sz[i] < sz[j]) { 
            numberarray[i] = j;  //i is smaller tree than j. Set the parent of i as j. 
            sz[j]+= sz[i];  //update the size of bigger tree(j) by adding the size of the smaller tree(i).
        }
        else {
            numberarray[j] = i;
            sz[i]+= sz[j];
        }
        
    }
    
    public static int root (int i){
        while( i!= numberarray[i]) i = numberarray[i]; //keeps on finding the parent of i unless it is the root.
        return i;                                                
                                              /*                         2
                                                                        / \
                                                                       3   4        numberarray =  2   3   4   8  10
                                                                      /                   i       [2] [2] [2] [3] [8] 
                                                                     8                             |
                                                                    /                              \/
                                                                   10                            i == numberarray[i]
                                                */                     
    }
    
    public static boolean isConnected (int a, int b){
        return root(a) == root(b) ;
    }
}