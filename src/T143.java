import java.util.ArrayList;
import java.util.List;

public class T143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<>();
            for(ListNode p = head; p != null; p = p.next) {
                list.add(p);
            }
            ListNode last = head;
            for(int i = 0; i < list.size() / 2; i ++) {
                ListNode p = list.get(list.size() - 1 - i);
                p.next = last.next;
                last.next = p;
                last = p;
                if(i == list.size() / 2 && list.size() % 2 == 0) {
                    break;
                }
                p = list.get(i + 1);
                p.next = last.next;
                last.next = p;
                last = p;
            }
            last.next = null;
        }
    }
}
