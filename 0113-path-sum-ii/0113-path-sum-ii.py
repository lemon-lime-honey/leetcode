class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(node, target, path):
            if not node: return

            target -= node.val
            path.append(node.val)

            if not node.left and not node.right:
                if target == 0:
                    result.append(copy.deepcopy(path))
            else:
                dfs(node.left, target, path)
                dfs(node.right, target, path)

            path.pop()
        
        result = list()
        dfs(root, targetSum, list())
        return result