class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def chk(listNode, treeNode):
            if not listNode: return True
            if not treeNode or listNode.val != treeNode.val: return False
            return chk(listNode.next, treeNode.left) or chk(listNode.next, treeNode.right)

        if not root: return False
        if chk(head, root): return True
        return self.isSubPath(head, root.left) or self.isSubPath(head, root.right)
