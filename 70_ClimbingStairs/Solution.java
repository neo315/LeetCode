// #70 Climbing stairs
// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//  Dynamic Programming

// X(n+1) = X(n) + X(n-1), Fibonacci number 
 
public class Solution { 
    public int climbStairs(int n) { 
        int oneStep = 1; // alternatively use the two variable to form Fibonacci sequence
        int twoStep = 1; 
        for (int i = 0; i < n/2; i++) 
        { 
            oneStep += twoStep; // To reach n stairs, it can be one step from n-1, and two steps from n-2
            twoStep += oneStep;  
        } 
         
        if (n % 2 == 0)  
            return oneStep; 
        else  
            return twoStep; 
    } 
}