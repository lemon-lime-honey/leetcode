class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode before = null, now = head;

        while (now != null) {
            ListNode after = now.next;
            now.next = before;
            before = now;
            now = after;
        }

        return before;
    }
}