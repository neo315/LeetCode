// #46 Permutations
//Given a collection of numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
// Tags:  Backtracking

public class Solution { 
    public List<List<Integer>> permute(int[] num) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
         
        if (num == null || num.length == 0) return result; 
        int size = num.length; 
        LinkedList<Integer> numbers = new LinkedList<Integer>(); 
        for (int i =0; i < num.length; i++)  
            numbers.add(num[i]); 
        ArrayList<Integer> item = new ArrayList<Integer>(); 
        generate(size, item, numbers, result); 
        return result; 
    } 
    private void generate(int size, ArrayList<Integer> item, LinkedList<Integer> numbers, ArrayList<List<Integer>> result) 
    { 
        if (item.size() == size || numbers.isEmpty()) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = 0; i < numbers.size(); i++) 
        { 
            int temp = numbers.get(i); 
            numbers.remove(i); 
            item.add(temp); 
            generate(size, item, numbers, result); 
            item.remove(item.size() - 1); 
            numbers.add(i, temp); 
    } 
  } 
}
