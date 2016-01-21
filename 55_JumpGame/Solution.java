// #55 Jump Game
// Given an array of non-negative integers, you are initially positioned at the first index of the array.

//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
// Tags: Array, Greedy, Dynamic programing
public class Solution { 
    public boolean canJump(int[] A) { 
        if (A == null) return false; 
        if (A.length == 1 && A[0] == 0) return true; 
        int n = A.length; 
        int reach = 0; 
        for (int i = 0; i < n; i++) 
        { 
            if (A[i] == 0 && reach <= i) return false;  
            if (A[i] + i > reach) reach = A[i] + i; 
            if (reach >= n - 1) return true; 
        } 
        return reach >= n - 1; 
    } 
}