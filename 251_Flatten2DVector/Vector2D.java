// 251 Flatten 2D Vector
// Implement an iterator to flatten a 2d vector.

//For example,
//Given 2d vector =
//
//[
//  [1,2],
//  [3],
//  [4,5,6]
//]
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
public class Vector2D { 
    private int listIndex; 
    private int index; 
    private List<List<Integer>> vector; 
    private List<Integer> curVector; 
    public Vector2D(List<List<Integer>> vec2d) { 
        this.vector = vec2d; 
        if (vec2d.size() == 0) { 
            curVector = null; 
        } 
        else {
            listIndex = 0; 
            index = 0; 
            curVector = vec2d.get(listIndex); 
        } 
    } 
 
    public int next() { 
        int result = curVector.get(index); 
        index++; 
        return result; 
    } 
 
    public boolean hasNext() { 
         if (vector == null || vector.size() == 0 || curVector == null) { 
             return false; 
         } 
         while (curVector != null && index == curVector.size()) { 
            index = 0; 
            listIndex++; 
            curVector = listIndex < vector.size() ? vector.get(listIndex) : null; 
        } 
        return  curVector != null; 
    } 
} 
 
/** 
 * Your Vector2D object will be instantiated and called as such: 
 * Vector2D i = new Vector2D(vec2d); 
 * while (i.hasNext()) v[f()] = i.next(); 
 */