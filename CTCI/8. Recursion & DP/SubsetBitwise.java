/** 
 * Given a set of distinct integers, S, return all possible subsets. 
 *  
 * Note: Elements in a subset must be in non-descending order. The solution set 
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution 
 * is: 
 *  
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ] 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class SubsetBitwise {
    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
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