class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        result = ListNode(0, list1)

        for i in range(a - 1):
            list1 = list1.next

        target = list1.next
        list1.next = list2

        for i in range(b - a + 1):
            temp = target.next
            del target
            target = temp

        while list2 and list2.next:
            list2 = list2.next

        list2.next = target

        return result.next