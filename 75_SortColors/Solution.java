// #75 Sort Colors
//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//Note:
//You are not suppose to use the library's sort function for this problem.
//click to show follow up.
//Follow up:
//A rather straight forward solution is a two-pass algorithm using counting sort.
//First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//Could you come up with an one-pass algorithm using only constant space?

// Tags:  Array, Two Pointers, Sort
public class Solution { 
    public void sortColors(int[] A) { 
        int lt = 0; 
        int gt = A.length - 1; 
        int i = 0; 
 
        while (i <= gt) 
        { 
            if (A[i] < 1) exch(A, lt++, i++); 
            else if (A[i] > 1) exch(A, gt--,i); 
            else i++; 
        } 
        return; 
    } 
     
    private void exch(int[] A, int i, int j) 
    { 
        int temp = A[i]; 
        A[i] = A[j]; 
        A[j] = temp; 
        return; 
    } 
}
