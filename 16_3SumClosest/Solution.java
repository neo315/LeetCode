// # 16 3Sum Closest 
//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Tags: Array, Two Pointers

public class Solution { 
    public int threeSumClosest(int[] num, int target) { 
        int min = Integer.MAX_VALUE; 
        int result = 0; 
        int n = num.length; 
        Arrays.sort(num); 
         
        for (int i = 0; i < n - 2; i++) 
        { 
            if (i == 0 || num[i] > num[i-1]) 
            { 
                int start = i + 1; 
                int end = n - 1; 
                while (start < end) 
                { 
                    if (Math.abs(num[start] + num[end] + num[i] - target) < min) 
                    { 
                        min = Math.abs(num[start] + num[end] + num[i] - target); 
                        result = num[start] + num[end] + num[i]; 
                    } 
                    if (num[start] + num[end] + num[i] == target) return target; 
                    else if (num[start] + num[end] + num[i] < target) 
                        start++; 
                    else end--; 
                } 
            } 
        } 
        return result; 
    } 
}