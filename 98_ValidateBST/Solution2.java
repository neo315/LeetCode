import java.util.ArrayList;
import java.util.Stack; 
 


public class Solution2 { 
    private static class TreeNode { 
      int val; 
      TreeNode left; 
      TreeNode right; 
      TreeNode(int x) { val = x; } 
  } 
 
    public static boolean isValidBST(TreeNode root) { 
        if (root == null) { 
            return true; 
        } 
        ArrayList<Integer> order = new ArrayList<Integer>(); 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode node = root; 
        while (node != null || !stack.empty()) { 
            if (node != null) { 
                stack.push(node); 
                node = node.left; 
            } 
            else { 
                node = stack.pop(); 
                order.add(node.val); 
                node = node.right; 
            } 
        } 
         System.out.println(order.size());
        for (int i = 1; i < order.size(); i++) { 
            if (order.get(i-1) >= order.get(i)) { 
                System.out.print(order.get(i-1) + " ");
                return false; 
            } 
        } 
        return true; 
    } 
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(Solution2.isValidBST(root));
    }
}