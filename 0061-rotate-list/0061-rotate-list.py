class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head: return None

        last = head
        length = 1

        while last.next:
            last = last.next
            length += 1

        k = k % length
        last.next = head

        for i in range(length - k - 1):
            head = head.next

        result = head.next
        head.next = None

        return result