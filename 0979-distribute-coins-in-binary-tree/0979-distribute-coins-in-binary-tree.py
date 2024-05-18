class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node: return 0

            nonlocal result
            lCoin = dfs(node.left)
            rCoin = dfs(node.right)
            coins = node.val - 1 + lCoin + rCoin
            result += abs(coins)
            return coins


        result = 0
        dfs(root)
        return result