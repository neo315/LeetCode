// #198 House Robber 
//You are a professional robber planning to rob houses along a street.
//Each house has a certain amount of money stashed, the only constraint
//stopping you from robbing each of them is that adjacent houses have
//security system connected and it will automatically contact the police
//if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money
//of each house, determine the maximum amount of money you can rob tonight
//without alerting the police.
//
//Credits: Special thanks to @ifanchu for adding this problem and creating
//all test cases. Also thanks to @ts for adding additional test cases.
// Tags: Dynamic Programming
import java.util.LinkedList;
import java.util.List;
public class Solution { 
//    public int rob(int[] num) { 
    public List<Integer> rob(int[] num) {
//        if (num == null) return 0; 
        int N = num.length; 
//        if (N == 0) return 0; 
//        if (N == 1) return num[0]; 
         
        int[] max = new int[N+2]; 
        List<Integer> result = new LinkedList<Integer>();
        boolean[] select = new boolean[N];
        max[0] = 0; 
        max[1] = 0; 
        for (int i = 2; i <= N+1; i++) {
            if (max[i-1] < max[i-2] + num[i-2]) {
                select[i-2] = true;
                max[i] = max[i-2] + num[i-2];
            }
            else {
                max[i] = max[i-1];
                
            }
        }
        for (int i = N-1; i >= 0; i--) {
            if (select[i]) {
                result.add(0, num[i]);
                i--;
            }
        }
        //System.out.println(max[N+1]);
        return result;
            //return max[N+1]; 
    } 
    public static void main(String[] args) {
        int[] nums = new int[args[0].length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = args[0].charAt(i) - '0';
        }
        Solution s = new Solution();
        List<Integer> result = s.rob(nums);
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
