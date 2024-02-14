class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode mid = slow;
        slow = slow.next;
        mid.next = null;

        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (head != null && !stack.isEmpty()) {
            ListNode target = stack.pop();
            ListNode temp = head;
            head = head.next;
            temp.next = target;
            target.next = head;
        }
    }
}