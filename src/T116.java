import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            if(root == null) {
                return null;
            }
            Map<Node, Integer> map = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            map.put(root, 1);
            Node pre = null;
            while(!queue.isEmpty()) {
                Node t = queue.poll();
                if(pre != null) {
                    if(map.get(t) == map.get(pre) + 1) {
                        pre.next = null;
                    } else if (map.get(t) == map.get(pre)) {
                        pre.next = t;
                    }
                }
                int depth = map.get(t);
                if(t.left != null) {
                    queue.add(t.left);
                    map.put(t.left, depth + 1);
                }
                if(t.right != null) {
                    queue.add(t.right);
                    map.put(t.right, depth + 1);
                }
                pre = t;
            }
            pre.next = null;
            return root;
        }
    }
}
