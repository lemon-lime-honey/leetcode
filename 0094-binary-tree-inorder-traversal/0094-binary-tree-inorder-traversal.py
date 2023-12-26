class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def traverse(node):
            if node is None: return
            traverse(node.left)
            result.append(node.val)
            traverse(node.right)


        result = list()
        traverse(root)
        return result