// #15 3Sum
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ² b ² c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)
// Tags:  Array, Two Pointers
import java.util.Arrays; 
public class Solution { 
    public List<List<Integer>> threeSum(int[] num) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        int n = num.length; 
        if (n < 3) return result; 
        Arrays.sort(num); 
         
        for (int i = 0; i < n - 2; i++) 
        { 
          if (i == 0 || num[i] > num[i - 1]) 
          { 
            int negate = -num[i]; 
             
            int start = i + 1; 
            int end = n - 1; 
             
            while (start < end) 
            { 
                 
                if (num[start] + num[end] == negate) 
                { 
                    ArrayList<Integer> temp = new ArrayList<Integer>(3); 
                    temp.add(num[i]); 
                    temp.add(num[start]); 
                    temp.add(num[end]); 
                    result.add(temp); 
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
        return result; 
    } 
}