public class T141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null) {
                return false;
            }
            ListNode p = head, q = head;
            while(q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
                if(p == q) {
                    return true;
                }
            }
            return false;
        }
    }
}
