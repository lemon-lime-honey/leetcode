# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        global before, result
        before, result = None, int(1e9)
        self.calculate(root)
        return result
    

    def calculate(self, node: Optional[TreeNode]):
        if node is None: return
        global before, result

        self.calculate(node.left)
        if before:
            result = min(result, node.val - before.val)
        before = node
        self.calculate(node.right)