// #47 Permutations II
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].
// Tags:  Backtracking
public class Solution { 
    public List<List<Integer>> permuteUnique(int[] num) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
         
        if (num == null || num.length == 0) return result; 
        int N = num.length; 
        boolean[] isUsed = new boolean[N]; 
        for (int i = 0; i < N; i++) 
            isUsed[i] = false; 
        Arrays.sort(num); 
        generate(num, new ArrayList<Integer>(), isUsed, result); 
        return result; 
    } 
     
    private void generate(int[] num, ArrayList<Integer> item, boolean[] isUsed, ArrayList<List<Integer>> result) 
    { 
         
        if (item.size() == num.length) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
        for (int i = 0; i < num.length; i++) 
        { 
            if (i > 0 && num[i] == num[i-1] && !isUsed[i-1] && !isUsed[i]) continue; 
            if (isUsed[i]) continue; 
            item.add(num[i]); 
            isUsed[i] = true; 
            generate(num, item, isUsed, result); 
            item.remove(item.size()-1); 
            isUsed[i] = false; 
        } 
        return; 
    } 
}