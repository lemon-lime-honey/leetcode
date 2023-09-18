class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def invert(original, result):
            if original.left:
                result.right = TreeNode(val=original.left.val)
                invert(original.left, result.right)
            if original.right:
                result.left = TreeNode(val=original.right.val)
                invert(original.right, result.left)


        if not root: return None

        answer = TreeNode(root.val)
        invert(root, answer)
        return answer