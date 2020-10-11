import java.util.HashSet;
import java.util.Set;

public class T142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            while(fast.next !=null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    if(slow == head) {
                        return head;
                    }
                    fast = head;
                    while(fast.next != null) {
                        fast = fast.next;
                        slow = slow.next;
                        if(fast == slow) {
                            return fast;
                        }
                    }
                }
            }
            return null;
        }
    }
}
