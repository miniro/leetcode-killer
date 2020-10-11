import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1443 {
    class Solution {
        int[] level;
        boolean[] visited;
        List<List<Integer>> graph;

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>();
                graph.add(list);
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            level = new int[n];
            visited = new boolean[n];
            dfs(0, 0);
            int result = 0;
            Arrays.fill(visited, false);
            visited[0] = true;
            for (int i = 0; i < n; i++) {
                if (hasApple.get(i)) {
                    int index = i;
                    while (!visited[index]) {
                        visited[index] = true;
                        for (int key : graph.get(index)) {
                            if (level[key] == level[index] - 1) {
                                index = key;
                                result += 2;
                                break;
                            }
                        }
                    }
                }
            }
            return result;
        }

        public void dfs(int index, int height) {
            visited[index] = true;
            for (int nextIndex : graph.get(index)) {
                if (!visited[nextIndex]) {
                    dfs(nextIndex, height + 1);
                }
            }
            level[index] = height;
        }
    }
}