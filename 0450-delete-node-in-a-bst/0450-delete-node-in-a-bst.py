class Solution:
    def before(self, root):
        root = root.left
        while root.right:
            root = root.right
        return root.val


    def next(self, root):
        root = root.right
        while root.left:
            root = root.left
        return root.val


    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root: return

        if key > root.val:
            root.right = self.deleteNode(root.right, key)
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        else:
            if not root.left and not root.right:
                root = None
            elif root.right:
                root.val = self.next(root)
                root.right = self.deleteNode(root.right, root.val)
            else:
                root.val = self.before(root)
                root.left = self.deleteNode(root.left, root.val)
        return root