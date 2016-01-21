// # 31 Next Permutation
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 ? 1,3,2
//3,2,1 ? 1,2,3
//1,1,5 ? 1,5,1
//Tags: Array

public class Solution { 
    public void nextPermutation(int[] nums) { 
        if (nums == null || nums.length == 1) return; 
         
        int partitionIndex = nums.length-1; 
        while (partitionIndex > 0) 
        { 
            if (nums[partitionIndex-1] < nums[partitionIndex]) break; 
            partitionIndex--; 
        } 
         
        if (partitionIndex > 0) 
        { 
            partitionIndex--; 
            int switchIndex = nums.length-1; 
            while (switchIndex >= 0 && nums[switchIndex] <= nums[partitionIndex]) 
                switchIndex--; 
            int temp = nums[switchIndex]; 
            nums[switchIndex] = nums[partitionIndex]; 
            nums[partitionIndex] = temp; 
            partitionIndex++; 
        } 
         
        int end = nums.length-1; 
         
        while (partitionIndex < end) 
        { 
            int swap = nums[end]; 
            nums[end] = nums[partitionIndex]; 
            nums[partitionIndex] = swap; 
            partitionIndex++; 
            end--; 
        } 
        return; 
    } 
}