//// #60 Permutation Sequence 
//The set [1,2,3,,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.
// Tags:  Backtracking Math
//http://blog.csdn.net/linhuanmars/article/details/22028697
import java.util.ArrayList;
public class Solution { 
    public String getPermutation(int n, int k) { 
        if (n <= 0) return ""; 
        ArrayList<Integer> num = new ArrayList<Integer>(n); 
        k--; 
        int product = 1; 
        for (int i = 1; i <= n; i++) 
        { 
            product = i * product; 
            num.add(i); 
        } 
        StringBuilder result = new StringBuilder(); 
         
        for (int i = 0; i < n; i++) 
        { 
            product = product / (n - i); 
            int choosed = k / product; 
            k = k % product; 
            result.append(num.get(choosed)); 
            num.remove(choosed); 
        } 
        return result.toString(); 
    } 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        Solution s = new Solution();
        System.out.println(s.getPermutation(n, k));
    }
}