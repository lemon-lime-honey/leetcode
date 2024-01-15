class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def calc(node, total):
            if node.left is None and node.right is None:
                nonlocal result
                result += total
                return
            if node.left:
                calc(node.left, total * 10 + node.left.val)
            if node.right:
                calc(node.right, total * 10 + node.right.val)


        if not root: return 0
        result = 0
        calc(root, root.val)
        return result