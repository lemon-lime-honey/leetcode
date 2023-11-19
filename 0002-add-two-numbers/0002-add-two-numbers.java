class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode result = new ListNode(sum);
        ListNode answer = result;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode node = new ListNode(sum);
            result.next = node;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1.val = sum;
            result.next = l1;
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2.val = sum;
            result.next = l2;
            result = result.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            result.next = node;
        }

        return answer;
    }
}