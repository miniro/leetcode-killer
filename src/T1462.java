import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T1462 {
    class Solution {
        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            List<List<Integer>> graph = new ArrayList<>();
            List<List<Integer>> parent = new ArrayList<>();
            List<Boolean> ans = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            int[] preNum = new int[n];
            for(int i = 0; i < n; i ++) {
                List<Integer> list = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                graph.add(list);
                parent.add(list2);
            }
            for(int[] require : prerequisites) {
                graph.get(require[0]).add(require[1]);
                preNum[require[1]] ++;
            }
            for(int i = 0; i < n; i ++) {
                if(preNum[i] == 0) {
                    queue.offer(i);
                }
            }
            while(!queue.isEmpty()) {
                int key = queue.poll();
                for(int value : graph.get(key)) {
                    parent.get(value).add(key);
                    parent.get(value).addAll(parent.get(key));
                    preNum[value] --;
                    if(preNum[value] == 0) {
                        queue.add(value);
                    }
                }
            }
            for(int[] query : queries) {
                ans.add(parent.get(query[1]).contains(query[0]));
            }
            return ans;
        }
    }
}