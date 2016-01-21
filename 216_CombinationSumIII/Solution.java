// # 216 Combination Sum III
//Find all possible combinations of k numbers that add up to a number n, 
//given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//Ensure that numbers within the set are sorted in ascending order.
//
//
//Example 1:
//
//Input: k = 3, n = 7
//
//Output:
//
//[[1,2,4]]
//
//Example 2:
//
//Input: k = 3, n = 9
//
//Output:
//
//[[1,2,6], [1,3,5], [2,3,4]]
//
//Tags: Array, Backtracking

public class Solution { 
    public List<List<Integer>> combinationSum3(int k, int n) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (k < 0 || k > 9 || n > 1050 || n < 0) return result; 
         
        helper(1, k, n, new ArrayList<Integer>(), result); 
        return result; 
    } 
    private void helper(int start, int k, int target, ArrayList<Integer> item, ArrayList<List<Integer>> result) 
    { 
        if (k < 0) return; 
        if (k == 0 && target == 0) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = start; i < 10; i++) 
        { 
            item.add(i); 
            helper(i+1, k-1, target-i, item, result); 
            item.remove(item.size()-1); 
        } 
        return; 
    } 
}