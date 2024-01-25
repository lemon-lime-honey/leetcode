class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        node = head.next
        head.next = self.swapPairs(head.next.next)
        node.next = head
        return node