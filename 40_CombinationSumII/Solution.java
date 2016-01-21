// #40 Combination Sum II
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 
// Tags: Array, Backtracking

public class Solution { 
    public List<List<Integer>> combinationSum2(int[] num, int target) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (num == null) return result; 
        Arrays.sort(num); 
        helper(0, target, num, new ArrayList<Integer>(), result); 
        return result; 
    } 
     
    private void helper(int start, int target, int[] num, ArrayList<Integer> item, ArrayList<List<Integer>> result) 
    { 
        if (target < 0) return; 
        if (target == 0) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = start; i < num.length; i++) 
        { 
            if (i > start && num[i] == num[i - 1]) continue; 
            item.add(num[i]); 
            helper(i+1, target - num[i], num, item, result); 
            item.remove(item.size() - 1); 
        } 
        return; 
    } 
}