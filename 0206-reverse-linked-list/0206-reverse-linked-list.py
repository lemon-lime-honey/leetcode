class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        before, now = None, head

        while now:
            after = now.next
            now.next = before
            before = now
            now = after

        return before