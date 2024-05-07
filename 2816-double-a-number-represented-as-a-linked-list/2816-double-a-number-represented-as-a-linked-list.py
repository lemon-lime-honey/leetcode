class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def solve(node: Optional[ListNode]) -> int:
            value = 2 * node.val + (solve(node.next) if node.next else 0)
            node.val = value % 10
            return value // 10


        return ListNode(1, head) if solve(head) else head