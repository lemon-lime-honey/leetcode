class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.vals = list()
        self.iterate(root)
        self.idx = -1


    def iterate(self, node):
        if node.left:
            self.iterate(node.left)
        self.vals.append(node.val)
        if node.right:
            self.iterate(node.right)


    def next(self) -> int:
        self.idx += 1
        return self.vals[self.idx]


    def hasNext(self) -> bool:
        return True if self.idx < len(self.vals) - 1 else False
