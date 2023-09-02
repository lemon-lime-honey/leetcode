# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def merge(self, head1, head2):
        merged = ListNode(val=-1)
        temp = merged

        while head1 and head2:
            if head1.val < head2.val:
                temp.next = head1
                head1 = head1.next
            else:
                temp.next = head2
                head2 = head2.next
            temp = temp.next

        if head1: temp.next = head1
        if head2: temp.next = head2

        return merged.next


    def findMid(self, head):
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow


    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None: return None
        if head.next == None: return head

        mid = self.findMid(head)
        head2 = mid.next
        mid.next = None
        nHead1 = self.sortList(head)
        nHead2 = self.sortList(head2)
        final = self.merge(nHead1, nHead2)
        return final