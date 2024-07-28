class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def traverse(node):
            if not node: return
            traverse(node.left)
            traverse(node.right)
            result.append(node.val)

        result = list()
        traverse(root)
        return result