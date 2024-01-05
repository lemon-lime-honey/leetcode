class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder: return

        root = TreeNode(postorder.pop())
        idx = inorder.index(root.val)

        root.right = self.buildTree(inorder[idx + 1:], postorder)
        root.left = self.buildTree(inorder[:idx], postorder)

        return root