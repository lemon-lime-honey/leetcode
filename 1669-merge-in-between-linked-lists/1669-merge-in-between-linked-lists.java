/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode result = new ListNode(0, list1);

        for (int i = 0; i < a - 1; i++) {
            list1 = list1.next;
        }

        ListNode target = list1.next;
        list1.next = list2;

        for (int i = 0; i < b - a + 1; i++) {
            ListNode temp = target.next;
            target.next = null;
            target = temp;
        }

        while (list2 != null && list2.next != null) {
            list2 = list2.next;
        }

        list2.next = target;

        return result.next;
    }
}