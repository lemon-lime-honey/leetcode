class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1 or not list2:
            if list1: return list1
            if list2: return list2
            else: return

        result = ListNode(val=min(list1.val, list2.val))
        head = result
        if list1.val <= list2.val: list1 = list1.next
        else: list2 = list2.next

        while list1 and list2:
            new = ListNode(val=min(list1.val, list2.val))
            result.next = new
            result = result.next
            if list1.val <= list2.val: list1 = list1.next
            else: list2 = list2.next

        if list1: result.next = list1
        elif list2: result.next = list2

        return head