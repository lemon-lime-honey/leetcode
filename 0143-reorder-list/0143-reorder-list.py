class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head:
            return

        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        stack = list()
        mid = slow
        slow = slow.next
        mid.next = None
        while slow:
            stack.append(slow)
            slow = slow.next

        while head and stack:
            target = stack.pop()
            temp = head
            head = head.next
            temp.next = target
            target.next = head