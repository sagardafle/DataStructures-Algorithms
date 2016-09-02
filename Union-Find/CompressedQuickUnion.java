    public class CompressedQuickUnion{
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
            while( i!= numberarray[i]) {
                numberarray[i] = numberarray[numberarray[i]]; //make every other node in the path point to its grandparent.We try to keep the tree as flat as possible.
                i = numberarray[i];
            }
            return i;                //video at : https://class.coursera.org/algs4partI-010/lecture/8
        }
        
        public static boolean isConnected (int a, int b){
            return root(a) == root(b) ;
        }
    }