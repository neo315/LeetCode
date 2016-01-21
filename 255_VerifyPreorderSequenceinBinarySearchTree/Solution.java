// 255 Verify Preorder Sequence in Binary Search Tree 
//Total Accepted: 2300 Total Submissions: 6876 Difficulty: Medium
//Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//
//You may assume each number in the sequence is unique.
//
//Follow up:
//Could you do it using only constant space complexity?
//
//Hide Tags Tree Stack
//Hide Similar Problems (M) Binary Tree Preorder Traversal
public class Solution { 
    public boolean verifyPreorder(int[] preorder) { 
        int low = Integer.MIN_VALUE; 
        Stack<Integer> stack = new Stack<Integer>(); 
        for (int p : preorder) { 
            if (p < low) { 
                return false; 
            } 
            while (!stack.empty() && p > stack.peek()) { 
                low = stack.pop(); 
            } 
            stack.push(p); 
        } 
        return true; 
    } 
}