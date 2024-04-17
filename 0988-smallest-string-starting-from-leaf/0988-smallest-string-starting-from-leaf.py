class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        def get(node, route):
            route.append(chr(node.val + ord('a')))
            if not node.left and not node.right:
                if result[0] is None:
                    result[0] = ''.join(route[::-1])
                else:
                    result[0] = min(result[0], ''.join(route[::-1]))
            if node.left:
                get(node.left, route)
            if node.right:
                get(node.right, route)
            route.pop()


        result = [None]
        get(root, list())
        return result[0]