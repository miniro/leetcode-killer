import java.util.HashSet;
import java.util.Set;

public class T547 {
    class Solution {
        int n;
        int[] parent;
        public int findCircleNum(int[][] M) {
            int n = M.length;
            parent = new int[n];
            for(int i = 0; i < n; i ++) {
                parent[i] = i;
            }
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < i; j ++) {
                    if(M[i][j] == 1) {
                        unite(i, j);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i ++) {
                set.add(getParent(i));
            }
            return set.size();
        }

        public int getParent(int x) {
            int t = x;
            while(parent[t] != t) {
                t = parent[t];
            }
            while(parent[x] != t) {
                int y = parent[x];
                parent[x] = t;
                x = y;
            }
            return t;
        }

        public void unite(int x, int y) {
            int fx = getParent(x);
            int fy = getParent(y);
            if(x != y) {
                parent[fx] = fy;
            }
        }
    }
}
