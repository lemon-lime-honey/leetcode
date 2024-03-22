class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True

        slow, fast = head, head
        rev = None

        while fast and fast.next:
            temp = slow
            slow = slow.next
            fast = fast.next.next
            temp.next = rev
            rev = temp

        if fast:
            slow = slow.next

        while rev and rev.val == slow.val:
            rev = rev.next
            slow = slow.next

        return rev is None