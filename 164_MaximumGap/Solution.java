// #164 Maximum Gap 
// Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//
//Try to solve it in linear time/space.
//
//Return 0 if the array contains less than 2 elements.
//
//You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
//
//Credits:
//Special thanks to @porker2008 for adding this problem and creating all test cases.
//
// Tags: Sort
//Suppose there are N elements and they range from A to B.
//
//Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
//
//Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket
//
//for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.
//
//Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.
//
//For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.

    public class Solution { 
    public int maximumGap(int[] num) { 
       if (num == null || num.length == 0) return 0; 
        
       int max = num[0]; 
       int min = num[0]; 
        
       for (int i = 0; i < num.length; i++) 
       { 
           max = Math.max(max, num[i]); 
           min = Math.min(min, num[i]); 
       } 
        
       // range of each bucket 
       int len = (max - min) / num.length + 1;  
       
       //number of buckets:(maxNum - minNum) / len + 1, each bucket only store the min and max in this bucket range 
       int[][] bucket = new int[(max - min)/len + 1][2]; 
       for (int i = 0; i < bucket.length; i++) 
       { 
           bucket[i][0] = -1; 
           bucket[i][1] = -1; 
       } 
        
       for (int x : num) 
       { 
           int i = (x - min)/len; 
           if (bucket[i][0] == -1) 
           { 
              bucket[i][0] = x; 
              bucket[i][1] = x; 
           } 
           else 
           { 
               if (x < bucket[i][0]) bucket[i][0] = x; 
               if (x > bucket[i][1]) bucket[i][1] = x; 
           } 
       } 
    // For each non-empty buckets p, find the next non-empty buckets q, return min(q.min - p.max) 
    int prev = 0; 
    int gap = 0; 
    for (int i = 1; i < bucket.length; i++) 
    { 
        if (bucket[i][0] == -1) continue; 
        gap = Math.max(gap, bucket[i][0] - bucket[prev][1]); 
        prev = i; 
    } 
    return gap; 
    } 
}
