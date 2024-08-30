class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def chk(node):
            if node is None: return 0
            leftLevel, rightLevel = chk(node.left), chk(node.right)
            if leftLevel < 0 or rightLevel < 0 or abs(leftLevel - rightLevel) > 1:
                return -1
            return max(leftLevel, rightLevel) + 1

        return chk(root) > -1
