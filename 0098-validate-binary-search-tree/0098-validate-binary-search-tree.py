class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def chk(node, minimum, maximum):
            if node is None: return True

            if not (minimum < node.val < maximum): return False

            return (chk(node.left, minimum, node.val) and
                    chk(node.right, node.val, maximum))


        return chk(root, float('-inf'), float('inf'))