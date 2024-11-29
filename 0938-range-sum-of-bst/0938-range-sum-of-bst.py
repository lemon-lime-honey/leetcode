class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def calc(node):
            if not node:
                return 0

            now = 0

            if low <= node.val <= high:
                now = node.val

            left, right = calc(node.left), calc(node.right)

            return left + right + now

        return calc(root)