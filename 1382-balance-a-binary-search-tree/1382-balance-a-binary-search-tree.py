class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        def traverse(node):
            if not node: return
            traverse(node.left)
            arr.append(node)
            traverse(node.right)

        def run(lo, hi):
            if hi < lo: return
            mid = lo + (hi - lo) // 2
            node = arr[mid]
            node.left = run(lo, mid - 1)
            node.right = run(mid + 1, hi)
            return node

        arr = list()
        traverse(root)
        return run(0, len(arr) - 1)
