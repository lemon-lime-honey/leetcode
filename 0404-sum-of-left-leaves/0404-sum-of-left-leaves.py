class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        def calc(node, left):
            nonlocal result
            if not node.left and not node.right and left:
                result += node.val
            if node.left:
                calc(node.left, True)
            if node.right:
                calc(node.right, False)

        result = 0
        calc(root, False)
        return result