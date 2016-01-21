/** 
 * Definition for an interval. 
 * public class Interval { 
 *     int start; 
 *     int end; 
 *     Interval() { start = 0; end = 0; } 
 *     Interval(int s, int e) { start = s; end = e; } 
 * } 
 */ 
public class Solution3 { 
     
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
         
        result.add(intervals.get(0)); 
        
        for (int i = 1; i < intervals.size(); i++) 
        { 
            if (result.get(result.size()-1).end >= intervals.get(i).start) 
            { 
                result.get(result.size()-1).end = Math.max(result.get(result.size()-1).end, intervals.get(i).end); 
            } 
            else result.add(intervals.get(i)); 
        } 
        return result; 
    } 
     
  
}