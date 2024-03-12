class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prefix_dict = {0: dummy}
        node = head
        prefix = 0

        while node:
            prefix += node.val
            if prefix in prefix_dict:
                target = prefix_dict[prefix].next
                temp_sum = prefix + target.val
                while target != node:
                    del prefix_dict[temp_sum]
                    target = target.next
                    temp_sum += target.val
                prefix_dict[prefix].next = node.next
            else:
                prefix_dict[prefix] = node
            node = node.next

        return dummy.next