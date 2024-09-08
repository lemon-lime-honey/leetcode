class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        result, size, temp = [None for i in range(k)], 0, head

        while temp:
            size += 1
            temp = temp.next

        chunk = size // k
        left = size % k

        for i in range(k):
            result[i] = head
            size_now = chunk + (1 if left > 0 else 0)
            left -= 1

            for j in range(size_now - 1):
                if head:
                    head = head.next

            if head:
                temp = head.next
                head.next = None
                head = temp

        return result