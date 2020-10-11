import java.util.HashMap;
import java.util.Map;

public class T138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) {
                return null;
            }
            Node p = head;
            while(p != null) {
                Node t = new Node(p.val);
                t.next = p.next;
                p.next = t;
                p = t.next;
            }
            p = head;
            while(p != null && p.next != null) {
                p.next.random = p.random == null ? null : p.random.next;
                p = p.next.next;
            }
            Node ans = head.next;
            Node a = ans;
            Node h = head;
            p = ans.next;
            a.next = h.next = null;
            while(p != null && p.next != null) {
                h.next = p;
                a.next = p.next;
                h = h.next;
                a = a.next;
                p = p.next.next;
            }
            h.next = a.next = null;

            return ans;
        }
    }
}
