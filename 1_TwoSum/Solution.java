// #1 Two Sum
// Given an array of integers, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2
// Tags: Array, Hash Table

import java.util.Hashtable; 
 
public class Solution { 
    public int[] twoSum(int[] numbers, int target) { 
         
        int n = numbers.length; 
        Hashtable<Integer, Integer> index = new Hashtable<Integer, Integer>(n); 
        int[] result = new int[2]; 
 
        for (int i = 0; i < n; i++) 
            index.put(numbers[i], i); 
         
        for (int i = 0; i < n; i++) 
        { 
            Integer j = index.get(target - numbers[i]); 
            if (j != null && i != j) 
            { 
                result[0] = Math.min(i, j) + 1; 
                result[1] = Math.max(i, j) + 1; 
                return result; 
            } 
        } 
       return result; 
    } 
}