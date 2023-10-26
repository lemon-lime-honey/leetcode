class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def chk(left, right):
            if left is None and right is None:
                return True
            if left is None or right is None:
                return False

            return (
                left.val == right.val and
                chk(left.left, right.right) and
                chk(left.right, right.left)
            )


        return chk(root, root)