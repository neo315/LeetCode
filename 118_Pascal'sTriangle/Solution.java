//// #118 Pascal's Triangle
//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]

// Tags: Array

public class Solution { 
    public List<List<Integer>> generate(int numRows) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (numRows == 0) return result; 
        ArrayList<Integer> lastRow = new ArrayList<Integer>(1); 
        lastRow.add(1); 
        result.add(lastRow); 
        for (int row = 1; row < numRows; row++) 
        { 
            ArrayList<Integer> currentRow = new ArrayList<Integer>(row); 
            currentRow.add(1); 
            for (int i = 1; i < row; i++) 
                currentRow.add(lastRow.get(i-1) + lastRow.get(i)); 
            currentRow.add(1); 
            result.add(currentRow); 
            lastRow = currentRow; 
        }        return result; 
    } 
}