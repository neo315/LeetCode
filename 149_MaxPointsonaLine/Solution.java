// # 149 Max Points on a Line 
//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//
//Tags: Hash Table, Math

/** 
 * Definition for a point. 
 * class Point { 
 *     int x; 
 *     int y; 
 *     Point() { x = 0; y = 0; } 
 *     Point(int a, int b) { x = a; y = b; } 
 * } 
 */ 
public class Solution { 
    public int maxPoints(Point[] points) { 
        if (points == null || points.length == 0) 
            return 0; 
        int max = 1; 
        HashMap<Double, Integer> map = new HashMap<Double, Integer>(); 
         
        for (int i = 0; i < points.length; i++) 
        { 
            int duplicate = 1; 
            for (int j = 0; j < points.length; j++) 
            { 
                if (i == j) continue; 
                if (points[i].x == points[j].x && points[i].y == points[j].y)  
                { 
                    duplicate++; 
                    continue; 
                } 
                double slope = points[i].x == points[j].x ? Double.MAX_VALUE:  
                                1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x); 
                if (!map.containsKey(slope)) 
                    map.put(slope, 1); 
                else 
                    map.put(slope, map.get(slope)+1); 
            } 
            for (Integer count : map.values()) 
               if (max < count+duplicate) 
                    max = count + duplicate; 
            max = Math.max(max, duplicate); 
            map.clear(); 
        } 
        return max; 
    } 
}