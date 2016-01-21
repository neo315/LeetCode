public class Solution2 { 
    public int countComponents(int n, int[][] edges) { 
        if (n <= 0 || edges == null) { 
            return 0; 
        } 
        UF uf = new UF(n); 
        for (int i = 0; i < edges.length; i++) { 
            uf.union(edges[i][0], edges[i][1]); 
        } 
        return uf.size(); 
    } 
    private class UF { 
        int[] id; 
        int[] sz; 
        int N; 
         
        public UF(int n) { 
            id = new int[n]; 
            sz = new int[n]; 
            N = n; 
            for (int i = 0; i < n; i++) { 
                id[i] = i; 
                sz[i] = 1; 
            } 
        } 
         
        public int size() { 
            return N; 
        } 
        private int find(int i) { 
            while (id[i] != i) { 
                i = id[i]; 
            } 
            return i; 
        } 
        public boolean connected(int i, int j) { 
            return find(i) == find(j); 
        } 
        public void union(int p, int q) { 
            int i = find(p); 
            int j = find(q); 
            if (i == j) return; 
            if (sz[i] < sz[j]) { 
                id[i] = j; 
                sz[j] += sz[i]; 
            } 
            else { 
                id[j] = i; 
                sz[i] += sz[j]; 
            } 
            N--; 
        } 
    } 
}