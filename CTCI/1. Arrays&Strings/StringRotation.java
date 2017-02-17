public class StringRotation{
    public static void main(String[] args){
        String s = "watterbottle";
        String t = "tlewatterbot";
        System.out.println("Is String rotated "+isRotation(s,t));
    }
    
    /**
     * Create a twin of original string. 
     * If the other string is rotated, it has to be present as a substring in the twin string.
     * 
     * Eg: s="sagar"; t="arsag"
     * twin = "sag'arssag'ar" //twin will contain t.
     * 
     */ 
    public static boolean isRotation(String s, String t) {
         
         if(s.length()!=t.length()) return false;
         
         String twin = s+s; 
         return isSubstring(twin,t);
    }
    
    public static boolean isSubstring(String twin, String t){
        return twin.contains(t);
    }
}