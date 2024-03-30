class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode eve = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }

            odd.next = eve;
        }

        return head;
    }
}