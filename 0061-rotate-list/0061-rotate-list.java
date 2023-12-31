class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode last = head;
        int length = 1;

        while (last.next != null) {
            last = last.next;
            length++;
        }

        k = k % length;
        last.next = head;

        for (int i = 0; i < length - k - 1; i++) {
            head = head.next;
        }

        ListNode result = head.next;
        head.next = null;

        return result;
    }
}