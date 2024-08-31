class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        def dfs(node, route):
            if not node.left and not node.right:
                result.append(''.join(route))
                return
            if node.left:
                dfs(node.left, route + ['-', '>', str(node.left.val)])
            if node.right:
                dfs(node.right, route + ['-', '>', str(node.right.val)])

        result = list()
        dfs(root, [str(root.val)])
        return result