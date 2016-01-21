// #128 Longest Consecutive Sequence
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.
// Tags: Hash Table, Array
public class Solution { 
    public int longestConsecutive(int[] num) { 
        if (num == null || num.length == 0) return 0; 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        int max = 1; 
         
        for (int value : num) 
            map.put(value, 0); 
         
        for (int i = 0; i < num.length; i++) 
        { 
             
            if (map.get(num[i]) == 1) continue; 
            int curmax = 1; 
            int temp = num[i]; 
            while (map.containsKey(temp + 1)) 
            { 
                curmax++; 
                temp++; 
                map.put(temp, 1); 
            } 
             
            temp = num[i]; 
            while (map.containsKey(temp - 1)) 
            { 
                curmax++; 
                temp--; 
                map.put(temp, 1); 
            } 
            max = Math.max(curmax, max); 
        } 
        return max; 
    } 
}