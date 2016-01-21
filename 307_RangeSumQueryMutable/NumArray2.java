// 307 Range Sum Query - Mutable
public class NumArray2 { 
    private class SegmentTreeNode { 
        int sum; 
        SegmentTreeNode left, right; 
        int start, end; 
        public SegmentTreeNode(int s, int e) { 
            this.start = s; 
            this.end = e; 
        } 
    } 
     
    private SegmentTreeNode root = null; 
    public NumArray2(int[] nums) { 
        root = buildTree(nums, 0, nums.length-1); 
    } 
    SegmentTreeNode buildTree(int[] nums, int start, int end) { 
        if (start > end) { 
            return null; 
        } 
        SegmentTreeNode node = new SegmentTreeNode(start, end); 
        if (start == end) { 
            node.sum = nums[start]; 
        } 
        else { 
            int mid = start + (end - start) / 2; 
            node.left = buildTree(nums, start, mid); 
            node.right = buildTree(nums, mid + 1, end); 
            node.sum = node.left.sum + node.right.sum; 
        } 
        return node; 
    } 
    public void update(int i, int val) { 
        update(root, i, val); 
    } 
    private void update(SegmentTreeNode node, int i, int val) { 
        if (node == null || i > node.end || i < node.start) { 
            return; 
        } 
        int mid = node.start + (node.end - node.start) / 2; 
        if (node.start == i && node.end == i) { 
            node.sum = val; 
            return; 
        } 
        else { 
            if (i > mid) { 
                update(node.right, i, val); 
            } 
            else { 
                update(node.left, i, val); 
            } 
            node.sum = node.left.sum + node.right.sum; 
        } 
    } 
 
    public int sumRange(int i, int j) { 
        if (i > j) { 
            return 0; 
        } 
        return sumRange(root, i, j); 
    } 
    private int sumRange(SegmentTreeNode node, int i, int j) { 
        if (node == null || i < node.start || j > node.end) { 
            return 0; 
        } 
        if (node.start == i && node.end == j) { 
            return node.sum; 
        } 
        else { 
            int mid = node.start + (node.end - node.start) / 2; 
            if (j <= mid) { 
                return sumRange(node.left, i, j); 
            } 
            else if (i > mid) { 
                return sumRange(node.right, i, j); 
            } 
            else { 
                return sumRange(node.left, i, mid) + sumRange(node.right, mid+1, j); 
            } 
        } 
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray2 numArray = new NumArray2(nums); 
        System.out.println(numArray.sumRange(0, 2)); 
        numArray.update(1, 2); 
        System.out.println(numArray.sumRange(0, 2));
    }
}