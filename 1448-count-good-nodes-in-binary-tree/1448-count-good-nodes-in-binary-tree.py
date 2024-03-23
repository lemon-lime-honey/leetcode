class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def search(node, largest):
            if largest <= node.val:
                nonlocal result
                result += 1
            if node.left:
                search(node.left, max(largest, node.val))
            if node.right:
                search(node.right, max(largest, node.val))


        result = 0
        search(root, root.val)
        return result