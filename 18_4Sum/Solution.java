// # 18 4Sum
//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ² b ² c ² d)
//The solution set must not contain duplicate quadruplets.
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)
//Tags: Array, Hash Table, Two Pointers

import java.util.Arrays; 
import java.util.Hashtable;  
public class Solution { 
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) { 
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        if (num == null || num.length < 4) return result; 
        int n = num.length; 
        Arrays.sort(num); 
        for (int i = 0; i < n - 2; i++) 
            { 
                if (i == 0 || num[i] > num[i-1]) 
                { 
                    ArrayList<ArrayList<Integer>> curRes = threeSum(num, i+1, target-num[i]); 
                    for (int j = 0; j < curRes.size(); j++) 
                        curRes.get(j).add(0, num[i]); 
                    result.addAll(curRes); 
                } 
            } 
        return result; 
    } 
     
     private ArrayList<ArrayList<Integer>> threeSum(int[] num, int head, int target) 
     { 
         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
         for (int i = head; i < num.length - 2; i++) 
         { 
             if (i == head || num[i] > num[i-1]) 
             { 
                 int negate = target - num[i]; 
                 int start = i + 1; 
                 int end = num.length - 1; 
                  
                 while (start < end) 
                 { 
                     if (num[start] + num[end] == negate) 
                     { 
                         ArrayList<Integer> item = new ArrayList<Integer>(); 
                         item.add(num[i]); 
                         item.add(num[start]); 
                         item.add(num[end]); 
                         res.add(item); 
                         start++; 
                         end--; 
                         while (start < end && num[start] == num[start-1]) start++; 
                         while (start < end && num[end] == num[end+1]) end--; 
                     } 
                     else if (num[start] + num[end] < negate) start++; 
                     else end--; 
                 } 
             } 
        } 
     return res; 
    } 
}