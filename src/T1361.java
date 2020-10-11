import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class T1361 {
    class TreeNode {
        int left, right;
        List<Integer> parent;
        TreeNode() {
            parent = new ArrayList<>();
        }
    }

    class Solution {
        TreeNode[] treeNodes;
        int root;
        boolean[] visited;
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            treeNodes = new TreeNode[n];
            for(int i = 0; i < n; i ++) {
                treeNodes[i] = new TreeNode();
            }
            for(int i = 0; i < n; i ++) {
                treeNodes[i].left = leftChild[i];
                treeNodes[i].right = rightChild[i];
                if(leftChild[i] != -1) {
                    treeNodes[leftChild[i]].parent.add(i);
                }
                if(rightChild[i] != -1) {
                    treeNodes[rightChild[i]].parent.add(i);
                }
            }
            int cnt = 0;
            int root = -1;
            for(int i = 0; i < n; i ++) {
                int num = treeNodes[i].parent.size();
                if(num > 1) {
                    return false;
                } else if(num == 0) {
                    root = i;
                    cnt ++;
                }
            }
            if(cnt != 1) {
                return false;
            }
            visited = new boolean[n];
            dfs(root);
            for(int i = 0; i < n; i ++) {
                if(!visited[i]) {
                    return false;
                }
            }
            return true;
        }

        public void dfs(int root) {
            visited[root] = true;
            if(treeNodes[root].left != -1 && !visited[treeNodes[root].left]) {
                dfs(treeNodes[root].left);
            }
            if(treeNodes[root].right != -1 && !visited[treeNodes[root].right]) {
                dfs(treeNodes[root].right);
            }
        }
    }
}
