import java.util.HashSet;
import java.util.Set;

public class T959 {

    class Solution {
        int[] parent;
        int n;

        public int regionsBySlashes(String[] grid) {
            this.n = grid.length;
            parent = new int[this.n * this.n * 4];
            for(int i = 0; i < parent.length; i ++) {
                parent[i] = i;
            }
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    int[] indexes = new int[4];
                    for(int k = 0; k < 4; k ++) {
                        indexes[k] = (i * n + j) * 4 + k;
                    }
                    if(grid[i].charAt(j) == '/') {
                        union(indexes[0], indexes[3]);
                        union(indexes[1], indexes[2]);
                    } else if (grid[i].charAt(j) == '\\'){
                        union(indexes[0], indexes[1]);
                        union(indexes[2], indexes[3]);
                    } else {
                        union(indexes[0], indexes[1]);
                        union(indexes[1], indexes[2]);
                        union(indexes[2], indexes[3]);
                    }
                    if(i > 0) {
                        union(indexes[0], indexes[0] + 2 - n * 4);
                    }
                    if(j > 0) {
                        union(indexes[3], indexes[3] - 6);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < parent.length; i ++) {
                set.add(getParent(i));
            }
            return set.size();
        }

        public void union(int x, int y) {
            int fx = getParent(x);
            int fy = getParent(y);
            if(fx != fy) {
                parent[fx] = fy;
            }
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
    }
}
