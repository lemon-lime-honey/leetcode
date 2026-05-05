class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head

        node = head
        tail = None
        n = 0

        while node:
            n += 1
            if not node.next:
                tail = node
            node = node.next

        k %= n
        if k == 0:
            return head

        tail.next = head
        node = head

        for i in range(n - k - 1):
            node = node.next

        head = node.next
        node.next = None

        return head