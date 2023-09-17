class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        def check(n, m):
            if (not n and m) or (n and not m): return False
            if not n and not m: return True
            if n.val != m.val: return False

            if n.left and m.left:
                chk = check(n.left, m.left)
                if not chk: return False
            if n.right and m.right:
                chk = check(n.right, m.right)
                if not chk: return False
            if ((n.left and not m.left) or
                (n.right and not m.right) or
                (not n.left and m.left) or
                (not n.right and m.right)):
                return False

            return True

        return check(p, q)