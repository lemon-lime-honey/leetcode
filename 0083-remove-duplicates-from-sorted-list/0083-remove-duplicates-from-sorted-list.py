class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node = head

        while node and node.next:
            if node.val == node.next.val:
                temp = node.next
                while temp:
                    if temp.next:
                        if temp.next.val == node.val:
                            temp = temp.next
                        else:
                            node.next = temp.next
                            break
                    else:
                        node.next = None
                        break
            else:
                node = node.next
        
        return head