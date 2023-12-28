class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        def find(node, level):
            if node.left is None and node.right is None:
                nonlocal result
                result = min(result, level)
                return

            if node.left:
                find(node.left, level + 1)
            if node.right:
                find(node.right, level + 1)


        if root is None:
            return 0

        result = int(1e9)
        find(root, 1)
        return result