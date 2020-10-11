import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T834 {
    class Solution {
        int[] sum;
        int[] dist;
        int[] ans;
        int[] parent;
        List<List<Integer>> graph = new ArrayList<>();

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            int root = -1;
            sum = new int[N];
            dist = new int[N];
            ans = new int[N];
            parent = new int[N];
            Arrays.fill(parent, -1);
            for (int i = 0; i < N; i++) {
                List<Integer> list = new ArrayList<>();
                graph.add(list);
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                parent[edge[1]] = edge[0];
            }
            for (int i = 0; i < N; i++) {
                sum[i] = getSum(i, N);
                if (parent[i] == -1) {
                    root = i;
                }
            }
            for (int i = 0; i < N; i++) {
                dist[i] = getDist(i, N);
            }
            preOrder(root, N);
            return ans;
        }

        public int getSum(int x, int N) {
            if (graph.get(x).size() == 0) {
                return 1;
            }
            int sum = 1;
            for (int value : graph.get(x)) {
                sum += getSum(value, N);
            }
            return sum;
        }

        public int getDist(int x, int N) {
            if (graph.get(x).size() == 0) {
                return 0;
            }
            int dist = 0;
            for (int value : graph.get(x)) {
                dist += getDist(value, N) + sum[value];
            }
            return dist;
        }

        public void preOrder(int x, int N) {
            ans[x] = parent[x] == -1 ? dist[x] : ans[parent[x]] - sum[x] + N - sum[x];
            for (int value : graph.get(x)) {
                preOrder(value, N);
            }
        }
    }
}
