/** 
 * Definition for a point. 
 * class Point { 
 *     int x; 
 *     int y; 
 *     Point() { x = 0; y = 0; } 
 *     Point(int a, int b) { x = a; y = b; } 
 * } 
 */ 
public class Solution2 { 
    public int maxPoints(Point[] points) { 
        if (points == null) { 
            return 0; 
        } 
        if (points.length <= 2) { 
            return points.length; 
        } 
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>(); 
        int result = 1;
        for (int i = 0; i < points.length; i++) { 
            map.clear(); 
            int max = 0; 
            int duplicate = 0; 
            for (int j = i + 1; j < points.length; j++) { 
                int deltaX = points[j].x - points[i].x; 
                int deltaY = points[j].y - points[i].y; 
                if (deltaX == 0 && deltaY == 0) { 
                    duplicate++; 
                    continue; 
                } 
                int gcd = GCD(deltaX, deltaY); 
                if (gcd != 0) { 
                    deltaX /= gcd; 
                    deltaY /= gcd; 
                } 
                if (!map.containsKey(deltaX)) { 
                    Map<Integer, Integer> column = new HashMap<Integer, Integer>(); 
                    column.put(deltaY, 1); 
                    map.put(deltaX, column); 
                } 
                else if (!map.get(deltaX).containsKey(deltaY)) { 
                    Map<Integer, Integer> column = map.get(deltaX); 
                    column.put(deltaY, 1); 
                } 
                else { 
                    Map<Integer, Integer> column = map.get(deltaX); 
                    column.put(deltaY, column.get(deltaY) + 1); 
                } 
                max = Math.max(max, map.get(deltaX).get(deltaY)); 
            } 
            result = Math.max(result, max + 1 + duplicate); 
        } 
        return result; 
    } 
    private int GCD(int a, int b) { 
        while (b != 0) { 
            int t = b; 
            b = a % b; 
            a = t; 
        } 
        return a; 
    } 
}