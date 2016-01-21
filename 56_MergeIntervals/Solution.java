// #56 Merge Intervals
// Given a collection of intervals, merge all overlapping intervals.

//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].
// Tags: Array, Sort
/** 
 * Definition for an interval. 
 * public class Interval { 
 *     int start; 
 *     int end; 
 *     Interval() { start = 0; end = 0; } 
 *     Interval(int s, int e) { start = s; end = e; } 
 * } 
 */ 
public class Solution { 
    public List<Interval> merge(List<Interval> intervals) { 
        if (intervals == null) return null; 
        ArrayList<Interval> result = new ArrayList<Interval>(); 
        if(intervals.size() == 0) return result;   
        ArrayList<Interval> input = new ArrayList<Interval>(intervals); 
        sort(input); 
        Interval item = new Interval(input.get(0).start, input.get(0).end); 
        for (int i = 1; i < input.size(); i++) 
        { 
            if (input.get(i).start > item.end) 
            { 
                result.add(item); 
                item = new Interval(input.get(i).start, input.get(i).end); 
            } 
            else item.end = Math.max(item.end, input.get(i).end); 
        } 
        result.add(item); 
        return result; 
    } 
     
    private void sort(ArrayList<Interval> input) 
    { 
        sort(input, 0, input.size() - 1); 
    } 
     
    private void sort(ArrayList<Interval> input, int lo, int hi) 
    { 
        if (hi <= lo) return; 
        int lt = lo; 
        int gt = hi; 
        int i = lo; 
        int v = input.get(lo).start; 
         
        while (i <= gt) 
        { 
            int cmp = input.get(i).start - v; 
             
            if (cmp < 0) { exch(input, i, lt); i++; lt++;} 
            else if (cmp > 0) { exch(input, i, gt); gt--;} 
            else i++; 
        } 
        sort(input, lo, lt - 1); 
        sort(input, gt + 1, hi); 
    } 
     
    private void exch(ArrayList<Interval> input, int i, int j) 
    { 
        Interval temp = input.get(i); 
        input.set(i, input.get(j));   
        input.set(j, temp); 
        return; 
    } 
}