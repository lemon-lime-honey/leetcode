# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def view(node):
            if not node: return
            nonlocal result, depth
            depth += 1
            if depth == len(result) + 1:
                result.append(node.val)
            view(node.right)
            view(node.left)
            depth -= 1


        if not root: return list()
        result = [root.val]
        depth = 0
        view(root)
        return result