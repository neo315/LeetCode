 import java.util.PriorityQueue;
 import java.util.Comparator;
 import java.util.Arrays;
  
public class Solution2 { 
    private class Interval { 
      int start; 
      int end; 
      Interval() { start = 0; end = 0; } 
      Interval(int s, int e) { start = s; end = e; } 
  } 
    public int minMeetingRooms(Interval[] intervals) { 
        if (intervals == null || intervals.length == 0) { 
            return 0; 
        } 
        Arrays.sort(intervals, new Comparator<Interval>() { 
            @Override 
            public int compare(Interval a, Interval b) { 
                return a.start - b.start; 
            } 
        }); 
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() { 
            @Override 
            public int compare(Interval a, Interval b) { 
                return a.end - b.end; 
                } 
            }); 
            pq.offer(intervals[0]); 
            for (int i = 1; i < intervals.length; i++) { 
                Interval cur = pq.poll(); 
                if (cur.end <= intervals[i].start) { 
                    cur.end = intervals[i].end; 
                } 
                else { 
                    pq.offer(intervals[i]); 
                } 
                pq.offer(cur); 
            } 
            return pq.size(); 
    } 
}