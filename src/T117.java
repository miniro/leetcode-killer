public class T117 {
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
        Node last = null;
        Node nextLine = null;
        public Node connect(Node root) {
            if(root == null) {
                return null;
            }
            Node start = root;
            while(start != null) {
                last = nextLine = null;
                for(Node p = start; p != null; p = p.next) {
                    if(p.left != null) {
                        handle(p.left);
                    }
                    if(p.right != null) {
                        handle(p.right);
                    }
                }
                start = nextLine;
            }
            return root;
        }

        public void handle(Node p) {
            if(last == null) {
                last = p;
            } else {
                last.next = p;
                last = last.next;
            }
            if(nextLine == null) {
                nextLine = p;
            }
        }
    }
}
