class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def reverse(node1, node2, level):
            if not node1 or not node2:
                return

            if level % 2 == 0:
                node1.val, node2.val = node2.val, node1.val

            reverse(node1.left, node2.right, level + 1)
            reverse(node1.right, node2.left, level + 1)

        reverse(root.left, root.right, 0)
        return root