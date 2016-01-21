// #39 Combination Sum
//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 
// Tags: Array, Backtracking

public class Solution { 
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (candidates == null) return result; 
        Arrays.sort(candidates); 
        helper(0, target, candidates, new ArrayList<Integer>(), result); 
        return result; 
    } 
     
    private void helper(int start, int target, int[] candidates, ArrayList<Integer> item, ArrayList<List<Integer>> result) 
    { 
        if (target < 0) return; 
        if (target == 0) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = start; i < candidates.length; i++) 
        { 
            if (i > 0 && candidates[i] == candidates[i-1]) continue; 
            item.add(candidates[i]); 
            helper(i, target - candidates[i], candidates, item, result); 
            item.remove(item.size() - 1); 
        } 
        return; 
    } 
}