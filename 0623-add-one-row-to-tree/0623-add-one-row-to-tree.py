class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        def insert(node, val, depth, level):
            if level == depth - 1:
                left, right = None, None
                if node.left and not node.right:
                    left = TreeNode(val, left=node.left)
                    right = TreeNode(val)
                elif node.right and not node.left:
                    left = TreeNode(val)
                    right = TreeNode(val, right=node.right)
                elif not node.left and not node.right:
                    left = TreeNode(val)
                    right = TreeNode(val)
                else:
                    left = TreeNode(val, left=node.left)
                    right = TreeNode(val, right=node.right)
                node.left = left
                node.right = right
                return

            if node.left:
                insert(node.left, val, depth, level + 1)
            if node.right:
                insert(node.right, val, depth, level + 1)


        if depth == 1:
            node = TreeNode(val, left=root)
            return node

        insert(root, val, depth, 1)
        return root