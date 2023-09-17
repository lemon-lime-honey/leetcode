class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def search(node, depth):
            nonlocal result
            if not node: return
            if node.left: search(node.left, depth + 1)
            if node.right: search(node.right, depth + 1)
            if depth > result: result = depth
            return
        
        result = 0
        search(root, 1)
        return result