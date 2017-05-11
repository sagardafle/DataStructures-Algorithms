/**
 * BackTrack Solution: https://leetcode.com/problems/subsets/#/description
 * 
import java.util.*;
public class SubSets {
    
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = convertIntToSet(i, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int i, ArrayList<Integer> set) {
	          System.out.println("i = "+i);
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = i; k > 0; k >>= 1) {
		          System.out.println(" 1>>k = "+ (k));
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 3; i++) {
			list.add(i);
		}
		
		ArrayList<ArrayList<Integer>> subsets2 = getSubsets(list);
		System.out.println(subsets2.toString());		
	}
}