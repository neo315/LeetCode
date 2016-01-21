/** 
 * Definition for an interval. 
 * public class Interval { 
 *     int start; 
 *     int end; 
 *     Interval() { start = 0; end = 0; } 
 *     Interval(int s, int e) { start = s; end = e; } 
 * } 
 */ 
public class Solution2 { 
     
    public List<Interval> merge(List<Interval> intervals) { 
        if (intervals == null) return null; 
        ArrayList<Interval> result = new ArrayList<Interval>(); 
        if(intervals.size() == 0) return result;   
         Comparator<Interval> comp = new Comparator<Interval>() 
      { 
          public int compare(Interval i1, Interval i2) 
        { 
              if (i1.start == i2.start)  
                return i1.end - i2.end; 
            else return i1.start - i2.start; 
        } 
    }; 
   
        Collections.sort(intervals, comp); 
        Interval item = new Interval(intervals.get(0).start, intervals.get(0).end); 
        
        for (int i = 1; i < intervals.size(); i++) 
        { 
            if (intervals.get(i).start > item.end) 
            { 
                result.add(item); 
                item = new Interval(intervals.get(i).start, intervals.get(i).end); 
            } 
            else item.end = Math.max(item.end, intervals.get(i).end); 
        } 
        result.add(item); 
        return result; 
    } 
     
  
}