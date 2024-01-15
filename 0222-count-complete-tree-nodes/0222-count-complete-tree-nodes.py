class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        def cnt(node):
            if not node.left and not node.right:
                return

            nonlocal result
            if node.left:
                result += 1
                cnt(node.left)
            if node.right:
                result += 1
                cnt(node.right)


        if root is None: return 0
        result = 1
        cnt(root)
        return result