class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        def solve(node, is_root):
            if not node: return None
            if is_root and node.val not in targets:
                result.append(node)
            node.left = solve(node.left, node.val in targets)
            node.right = solve(node.right, node.val in targets)
            return None if node.val in targets else node


        result = list()
        targets = set(to_delete)
        solve(root, True)
        return result
