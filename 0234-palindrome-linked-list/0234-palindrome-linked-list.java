class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head, rev = null;

        while (fast != null && fast.next != null) {
            ListNode temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp.next = rev;
            rev = temp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (rev != null && rev.val == slow.val) {
            rev = rev.next;
            slow = slow.next;
        }

        return rev == null;
    }
}