//// #77 Combinations
//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//Tags:  Backtracking

public class Solution { 
    public List<List<Integer>> combine(int n, int k) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (n < 0 || k > n) return result; 
        helper(n, k, 1, new ArrayList<Integer>(k), result); 
        return result; 
    } 
     
    private void helper(int n, int k, int start, ArrayList<Integer> item, ArrayList<List<Integer>> result) 
    { 
        if (item.size() == k) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = start; i <= n; i++) 
        { 
            item.add(i); 
            helper(n, k, i + 1, item, result); 
            item.remove(item.size()-1);   
        } 
    } 
}