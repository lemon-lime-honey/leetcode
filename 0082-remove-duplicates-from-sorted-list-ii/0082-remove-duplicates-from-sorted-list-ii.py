class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()
        node = result

        while head:
            if head.next:
                if head.val == head.next.val:
                    while head.next and head.val == head.next.val:
                        head = head.next
                    if head.next:
                        head = head.next
                    else:
                        break
                else:
                    node.next = ListNode(head.val)
                    node = node.next
                    head = head.next
            else:
                node.next = ListNode(head.val)
                node = node.next
                head = head.next

        return result.next