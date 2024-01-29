class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1, head);
        ListNode now = result;

        while (now.next != null) {
            if (now.next.val == val) {
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }

        return result.next;
    }
}