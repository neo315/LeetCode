// #96 Unique Binary Search Trees 
// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
// Tree, Dynamic Programming

public class Solution {
    public int numTrees(int n) {
        int[] num = new int[n+1];
        num[0] = 1;
        for (int i = 1; i < n+1; i++)
        {
            for (int j = 0; j < i; j++ )
            num[i] = num[i] + num[j] * num[i-1-j];
        }
        return num[n];
    }
}