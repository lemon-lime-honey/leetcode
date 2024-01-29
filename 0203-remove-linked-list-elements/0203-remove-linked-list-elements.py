class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        result = ListNode(-1)
        result.next = head

        now = result

        while now.next:
            if now.next.val == val:
                now.next = now.next.next
            else:
                now = now.next

        return result.next