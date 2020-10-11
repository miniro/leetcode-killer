import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T52 {
    class Solution {
        int ans = 0;
        int n;
        boolean[] visited;
        List<int[]> list = new ArrayList<>();

        public int totalNQueens(int n) {
            this.n = n;
            this.visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited, false);
                dfs(i, 0);
            }
            return ans;
        }

        public void dfs(int index, int num) {
            list.add(new int[]{index, num});
            visited[index] = true;
            if (num == n - 1) {
                ans++;
                list.remove(list.size() - 1);
                visited[index] = false;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                boolean tag = true;
                for (int[] value : list) {
                    if (Math.abs(value[0] - i) == Math.abs(value[1] - num - 1)) {
                        tag = false;
                        break;
                    }
                }
                if (tag) {
                    dfs(i, num + 1);
                }
            }
            list.remove(list.size() - 1);
            visited[index] = false;
        }
    }

}