class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def calc(node, total):
            if not node.left and not node.right:
                if total == targetSum:
                    nonlocal result
                    result = True
                return
            if node.left:
                calc(node.left, total + node.left.val)
            if node.right:
                calc(node.right, total + node.right.val)


        if root is None: return False

        result = False
        calc(root, root.val)
        return result