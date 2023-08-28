# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        linked = ListNode()
        head = linked
        linked.val = (l1.val + l2.val) % 10
        carry = (l1.val + l2.val) // 10
        l1 = l1.next
        l2 = l2.next

        while l1 or l2:
            if l1 and l2:
                value = (l1.val + l2.val + carry) % 10
                carry = (l1.val + l2.val + carry) // 10
                new = ListNode(val=value)
                linked.next = new
                linked = linked.next
                l1 = l1.next
                l2 = l2.next
            elif l1:
                value = (l1.val + carry) % 10
                carry = (l1.val + carry) // 10
                new = ListNode(val=value)
                linked.next = new
                linked = linked.next
                l1 = l1.next
            else:
                value = (l2.val + carry) % 10
                carry = (l2.val + carry) // 10
                new = ListNode(val=value)
                linked.next = new
                linked = linked.next
                l2 = l2.next

        if carry:
            new = ListNode(val=carry)
            linked.next = new
            linked = linked.next

        return head