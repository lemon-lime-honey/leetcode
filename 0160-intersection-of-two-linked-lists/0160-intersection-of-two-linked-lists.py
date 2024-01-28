class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        nodes = set()

        while headA:
            nodes.add(headA)
            headA = headA.next

        while headB:
            if headB in nodes:
                return headB
            headB = headB.next

        return None