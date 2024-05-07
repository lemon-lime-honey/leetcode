class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node = head
        target = 0

        while node:
            target = target * 10 + node.val
            node = node.next

        target *= 2
        node = head
        number = list()

        if target == 0: number.append(0)

        while target:
            number.append(target % 10)
            target //= 10

        while node:
            node.val = number.pop()
            if number:
                if not node.next:
                    node.next = ListNode(-1)
            node = node.next

        return head