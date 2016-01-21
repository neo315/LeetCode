// #90 Subsets II 
//Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Tags: Array, Backtracking
public class Solution { 
    public List<List<Integer>> subsetsWithDup(int[] num) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (num == null && num.length == 0) return result; 
         
        Arrays.sort(num); 
        for (int size = 0; size <= num.length; size++) 
            generate(size, 0, new ArrayList<Integer>(size), num, result); 
        return result; 
    } 
     
    private void generate(int size, int start, ArrayList<Integer> item, int[] num, ArrayList<List<Integer>> result) 
    { 
        if (item.size() == size) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = start; i < num.length; i++) 
            { 
                item.add(num[i]); 
                generate(size, i+1, item, num, result); 
                item.remove(item.size()-1); 
                while (i < num.length - 1 && num[i] == num[i+1]) i++; 
 
            } 
        return; 
    } 
}