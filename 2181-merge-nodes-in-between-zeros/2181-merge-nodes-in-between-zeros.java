class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode result = res;
        int total = 0;

        while (head != null) {
            if (head.val == 0 && total != 0) {
                res.next = new ListNode(total);
                res = res.next;
                total = 0;
            }
            total += head.val;
            head = head.next;
        }

        return result.next;
    }
}