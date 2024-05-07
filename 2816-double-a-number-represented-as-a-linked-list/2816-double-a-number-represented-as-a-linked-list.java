class Solution {
    private int solve(ListNode node) {
        int value = 2 * node.val + (node.next != null ? solve(node.next) : 0);
        node.val = value % 10;
        return value / 10;
    }

    public ListNode doubleIt(ListNode head) {
        int chk = solve(head);
        if (chk != 0) return new ListNode(1, head);
        return head;
    }
}