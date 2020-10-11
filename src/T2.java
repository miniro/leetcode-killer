public class T2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode list = new ListNode(-1);
            ListNode head = list;
            list.next = null;
            int add = 0;
            while(l1 != null && l2 != null) {
                int value = (l1.val + l2.val + add) % 10;
                ListNode p = new ListNode(value);
                p.next = list.next;
                list.next = p;
                list = list.next;
                add = (l1.val + l2.val + add) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1 != null) {
                int value = (l1.val + add) % 10;
                ListNode p = new ListNode(value);
                p.next = list.next;
                list.next = p;
                list = list.next;
                add = (l1.val + add) / 10;
                l1 = l1.next;
            }
            while(l2 != null) {
                int value = (l2.val + add) % 10;
                ListNode p = new ListNode(value);
                p.next = list.next;
                list.next = p;
                list = list.next;
                add = (l2.val + add) / 10;
                l2 = l2.next;
            }
            if(add > 0) {
                ListNode p = new ListNode(add);
                p.next = list.next;
                list.next = p;
            }
            return head.next;
        }
    }
}
