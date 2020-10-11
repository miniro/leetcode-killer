import java.util.HashSet;
import java.util.Set;

public class T839 {

    class Solution {
        int[] parent;

        public int numSimilarGroups(String[] A) {
            parent = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (judge(A[i], A[j])) {
                        union(i, j);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                set.add(getParent(i));
            }
            return set.size();
        }

        public int getParent(int x) {
            int t = x;
            while (parent[t] != t) {
                t = parent[t];
            }
            while (parent[x] != t) {
                int y = parent[x];
                parent[x] = t;
                x = y;
            }
            return t;
        }

        public void union(int x, int y) {
            int fx = getParent(x);
            int fy = getParent(y);
            if (fx != fy) {
                parent[fx] = fy;
            }
        }

        public boolean judge(String a, String b) {
            if (a.equals(b)) {
                return true;
            }
            int k = 0;
            int[] record = new int[2];
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (k == 2) {
                        return false;
                    }
                    record[k++] = i;
                }
            }
            if (k == 2 && a.charAt(record[0]) == b.charAt(record[1]) && a.charAt(record[1]) == b.charAt(record[0])) {
                return true;
            }
            return false;
        }
    }
}
