class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            if (list1 != null) {
                return list1;
            }
            if (list2 != null) {
                return list2;
            }
            return list1;
        }

        ListNode result = new ListNode(Math.min(list1.val, list2.val));
        ListNode head = result;

        if (list1.val <= list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            ListNode node = new ListNode(Math.min(list1.val, list2.val));
            result.next = node;
            result = result.next;
            if (list1.val <= list2.val) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            result.next = list1;
        } else if (list2 != null) {
            result.next = list2;
        }

        return head;
    }
}