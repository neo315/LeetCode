//// #78 Subsets
//Given a set of distinct integers, S, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
//Tags: Array Backtracking Bit Manipulation
import java.util.Arrays; 
 
public class Solution { 
    public List<List<Integer>> subsets(int[] S) { 
         
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if(S == null || S.length == 0)   
        return result;   
        Arrays.sort(S); 
         
        for (int size = 0; size <= S.length; size++) 
            generate(size, 0, new ArrayList<Integer>(size), S, result); 
        return result; 
    } 
     
    private void generate(int size, int start, ArrayList<Integer> item, int[] S, ArrayList<List<Integer>> result) 
    { 
        if (item.size() == size) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = start; i < S.length; i++) 
        { 
            item.add(S[i]); 
            generate(size, i+1, item, S, result); 
            item.remove(item.size() - 1); 
        } 
    } 
}