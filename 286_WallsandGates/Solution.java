import java.util.LinkedList;
public class Solution { 
    public void wallsAndGates(int[][] rooms) { 
        if (rooms == null || rooms.length == 0) { 
            return; 
        } 
        int m = rooms.length, n = rooms[0].length; 
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) { 
                int code = i * n + j; 
                if (rooms[i][j] == 0) { 
                    bfs(rooms, code); 
                } 
            } 
        } 
        return; 
    } 
    private void bfs(int[][] rooms,int x) { 
        int m = rooms.length, n = rooms[0].length;

        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        int level = 1, cnt = 0, next = 0, cur = 1; 
        queue.offer(x); 
        while (!queue.isEmpty()) { 
            int code = queue.poll(); 
            cnt++; 
            int row = code / n, column = code % n; 
            //System.out.println("row= " + row + " column= " + column + " value= " + rooms[row][column]);
            if (row > 0 && rooms[row-1][column] > level) { 
                rooms[row-1][column] = level;
                queue.offer(code - n);
                next++;
            } 
            if (column > 0 && rooms[row][column-1] > level) { 
                rooms[row][column-1] = level; 
                queue.offer(code - 1);
                next++; 
            } 
            if (row < m-1 && rooms[row+1][column] > level) { 
                rooms[row+1][column] = level; 
                queue.offer(code + n);
                next++; 
            } 
            if (column < n-1 && rooms[row][column+1] > level) { 
                rooms[row][column+1] = level; 
                queue.offer(code + 1);
                next++; 
            } 
            if (cnt == cur) { 
                cur = next; 
                next = 0; 
                cnt = 0; 
                level++; 
            } 
         } 
         return; 
    }
    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        Solution s = new Solution();
        s.wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}