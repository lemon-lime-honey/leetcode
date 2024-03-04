class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def get_sequence(node, lst):
            if not node.left and not node.right:
                lst.append(node.val)
            if node.left:
                get_sequence(node.left, lst)
            if node.right:
                get_sequence(node.right, lst)


        seq1, seq2 = list(), list()
        get_sequence(root1, seq1)
        get_sequence(root2, seq2)

        return seq1 == seq2