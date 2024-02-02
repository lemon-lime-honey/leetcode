class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def traverse(node):
            result.append(node.val)
            if node.left:
                traverse(node.left)
            if node.right:
                traverse(node.right)


        result = list()

        if not root: return result
        traverse(root)
        return result