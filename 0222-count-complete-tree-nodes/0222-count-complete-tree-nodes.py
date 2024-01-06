# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
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