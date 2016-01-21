//// #119 Pascal's Triangle II 
//// Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?
//Tags: Arrays
// do the iteration from the end of the array to save the last row's value
public class Solution { 
    public List<Integer> getRow(int rowIndex) { 
        ArrayList<Integer> result = new ArrayList<Integer>(rowIndex); 
        result.add(1); 
         
        for (int k = 1; k < rowIndex + 1; k++) 
            { 
                for (int i = k - 1; i > 0 ; i--) 
                        result.set(i, result.get(i-1) + result.get(i));
                result.add(1);
            }
        return result; 
    }
}