public class T24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode p = head.next.next;
            ListNode h = head.next;
            ListNode n = head;
            h.next = n;
            n.next = null;
            ListNode last = n;
            while(p != null) {
                if(p.next == null) {
                    last.next = p;
                    last = p;
                    break;
                } else {
                    ListNode q = p.next, t = q.next;
                    q.next = null;
                    last.next = q;
                    last = q;
                    p.next = null;
                    last.next = p;
                    last = p;
                    p = t;
                }
            }
            last.next = null;

            return h;
        }
    }
}
