class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def get_sequence(node):
            if not node.left and not node.right:
                seq.append(node.val)
            if node.left:
                get_sequence(node.left)
            if node.right:
                get_sequence(node.right)


        seq = list()
        get_sequence(root1)
        seq1 = deepcopy(seq)
        seq.clear()
        get_sequence(root2)

        return seq == seq1