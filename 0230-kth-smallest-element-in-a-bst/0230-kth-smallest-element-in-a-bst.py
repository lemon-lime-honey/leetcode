# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def plainList(root):
            if root is None: return list()
            return plainList(root.left) + [root.val] + plainList(root.right)


        result = plainList(root)
        print(result)
        return result[k - 1]