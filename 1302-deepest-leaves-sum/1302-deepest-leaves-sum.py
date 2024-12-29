class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        def backtrack(node, lvl):
            if not node.left and not node.right:
                nonlocal level, result
                if level < lvl:
                    level = lvl
                    result = node.val
                elif level == lvl:
                    result += node.val
                return
            if node.left:
                backtrack(node.left, lvl + 1)
            if node.right:
                backtrack(node.right, lvl + 1)

        level, result = 0, 0
        backtrack(root, 0)

        return result
