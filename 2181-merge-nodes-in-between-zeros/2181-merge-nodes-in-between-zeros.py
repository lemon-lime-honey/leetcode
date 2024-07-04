class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        res = ListNode(-1)
        result = res
        total = 0

        while head:
            if head.val == 0 and total != 0:
                res.next = ListNode(total)
                res = res.next
                total = 0
            total += head.val
            head = head.next

        return result.next