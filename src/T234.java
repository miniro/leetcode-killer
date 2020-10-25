import java.util.ArrayList;
import java.util.List;

public class T234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            for(ListNode p = head; p != null; p = p.next) {
                list.add(p.val);
            }
            for(int i = 0; i < list.size() / 2; i ++) {
                if(list.get(i) != list.get(list.size() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
