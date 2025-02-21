class FindElements:
    def __init__(self, root: Optional[TreeNode]):
        def assign(node: TreeNode, value: int):
            node.val = value
            if node.left:
                assign(node.left, value * 2 + 1)
            if node.right:
                assign(node.right, value * 2 + 2)

        self.root = root
        assign(root, 0)


    def find(self, target: int) -> bool:
        def run(node: TreeNode) -> bool:
            if node.val == target: return True

            if not node.left and not node.right:
                return node.val == target
            if node.left and node.right:
                return run(node.left) or run(node.right)
            if node.left:
                return run(node.left)
            if node.right:
                return run(node.right)

        return run(self.root)