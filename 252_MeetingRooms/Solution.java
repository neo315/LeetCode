import java.util.Comparator;
import java.util.Arrays;
public class Solution { 
    private class Interval { 
      int start; 
      int end; 
      Interval() { start = 0; end = 0; } 
      Interval(int s, int e) { start = s; end = e; } 
  } 
    public boolean canAttendMeetings(Interval[] intervals) { 
        if (intervals == null || intervals.length == 0) { 
            return true; 
        } 
        IntervalComparator cmp = new IntervalComparator(); 
        Arrays.sort(intervals, cmp); 
        for (int i = 1; i < intervals.length; i++) { 
            if (intervals[i].start < intervals[i-1].end) { 
                return false; 
            }  
        }
        return true;
    } 
    private class IntervalComparator implements Comparator<Interval> { 
        @Override 
        public int compare(Interval a, Interval b) { 
            if (a.start == b.start) { 
                return a.end - b.end; 
            } 
            return a.start - b.start; 
        } 
    }
}