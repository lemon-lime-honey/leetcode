# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        global result, cnt
        result, cnt = 0, 0
        self.search(root, k)
        return result


    def search(self, node: Optional[TreeNode], k: int):
        if node is None: return

        global result, cnt
        self.search(node.left, k)
        cnt += 1
        if cnt == k: result = node.val
        self.search(node.right, k)