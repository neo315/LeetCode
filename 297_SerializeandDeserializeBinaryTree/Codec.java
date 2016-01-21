import java.util.LinkedList;
public class Codec { 
    private class TreeNode { 
        int val; 
        TreeNode left; 
        TreeNode right; 
        TreeNode(int x) { val = x; } 
    } 
    // Encodes a tree to a single string. 
    public String serialize(TreeNode root) { 
        if (root == null) { 
            return ""; 
        } 
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
        queue.offer(root);
        int cur = 1, next = 0, cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (!queue.isEmpty()) { 
            TreeNode node = queue.poll(); 
            cnt++;
            if (node.left != null) {
                sb.append(",");
                sb.append(node.left.val);
                queue.offer(node.left);
                next++;
            }
            else { 
                sb.append(",");
                sb.append("null");
            } 
            
            if (node.right != null) {
                sb.append(",");
                sb.append(node.right.val);
                queue.offer(node.right); 
                next++;
            } 
            else { 
                sb.append(",");
                sb.append("null");
            }
            if (cnt == cur) {
                cur = next;
                next = 0;
                cnt = 0;
            }
        } 
        return sb.toString(); 
    } 
    
    // Decodes your encoded data to tree. 
    public TreeNode deserialize(String data) { 
        if (data == null || data.equals("")) { 
            return null; 
        } 
        String[] strs = data.trim().split(","); 
        if (strs.length == 0 || strs[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[0])); 
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int index = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index < strs.length && !strs[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.left);
            }
            index++;
            if (index < strs.length && !strs[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    } 
    
    public static void main(String[] args) {
        Codec codec = new Codec();
        String input = "5,2,3,null,null,2,4,3,1";
        System.out.println(codec.serialize(codec.deserialize(input)));
    }
} 

// Your Codec object will be instantiated and called as such: 
// Codec codec = new Codec(); 
// codec.deserialize(codec.serialize(root));