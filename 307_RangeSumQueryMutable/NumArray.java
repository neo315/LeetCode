// 307 Range Sum Query - Mutable
public class NumArray { 
    private int[] nums; 
    private int[] tree; 
    private int max; 
     
    public NumArray(int[] nums) { 
        if (nums != null) { 
            max = nums.length; 
            tree = new int[max+1];
            this.nums = new int[max];
        }
        for (int i = 0; i < nums.length; i++) { 
            update(i, nums[i]); 
            //System.out.print("tree[" + (i+1) +"]=" + tree[i+1] + " ");
        }
    } 
     
    public void update(int i, int val) { 
        int diff = val - nums[i]; 
        nums[i] = val; 
        for (int idx = i+1; idx <= max; idx += (idx & -idx)) { 
            tree[idx] += diff; 
        } 
    } 
    public int sumRange(int i, int j) { 
        if (nums == null || i > j || j < 0 || i >= max) { 
            return 0;
        } 
        if (i < 0) { 
            i = 0; 
        } 
        if (j >= max) { 
            j = max - 1; 
        } 
        return sum(j+1) - sum(i); 
    } 
    private int sum(int i) { 
        int sum = 0; 
        for (int idx = i; idx > 0; idx -= (idx & -idx)) { 
            sum += tree[idx]; 
        } 
        //System.out.println("sum(" + i + ")=" + sum);
        return sum; 
    } 

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums); 
        System.out.println(numArray.sumRange(0, 2)); 
        numArray.update(1, 2); 
        System.out.println(numArray.sumRange(0, 2));
    }
}