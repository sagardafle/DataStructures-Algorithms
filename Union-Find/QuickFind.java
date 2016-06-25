public class QuickFind{
    static int numberarray[];
    public static void main(String args[]){
        int n=10;
         numberarray = new int[n];
        for(int i=0;i<numberarray.length;i++){
            numberarray[i] = i;
        }
        
        
        union(1,2);
        union(6,5);
        union(5,0);

        
        System.out.println(isConnected(2,1)); //Symmetric rule. 1=>2 then 2=>1.  
        System.out.println(isConnected(0,5)); //follows the transitive rule : if 6=>5 & 5=> 0 , 6 => 0 .
         
        
    }
    
    public static void union(int a, int b){
        int aid = numberarray[a];
        int bid = numberarray[b];
        
        for(int i=0;i<numberarray.length;i++){
            if(numberarray[i] == aid) numberarray[i] = bid;
        }
        
    }
    
    public static boolean isConnected (int a, int b){
        return numberarray[a] == numberarray[b] ;
    }
}